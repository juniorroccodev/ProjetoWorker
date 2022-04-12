package com.wolkersomar.consumer;

import com.google.gson.Gson;
import com.wolkersomar.models.Calc;
import com.wolkersomar.models.CalcResultado;
import com.wolkersomar.models.Status;
import com.wolkersomar.repository.CalcRepository;
import com.wolkersomar.repository.CalcResultadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class Consumer {

    private final Queue queue;
    private final CalcRepository calcRepository;
    private final CalcResultadoRepository calcResultadoRepository;

    @RabbitListener (queues = "${queue.name}")
    public void consumeMessageFromQueue (@Payload String calc) throws Exception{
        System.out.println("Mensagem recebida: " + calc);
        Calc calculo = new Gson().fromJson(calc, Calc.class);
        System.out.println("Objeto depois da conversão: " + calculo.toString());

        Thread.sleep(2000);
        //Atualiza o status do calculo para processando
        calculo.setStatus(Status.PROCESSANDO);
        calcRepository.save(calculo);
        System.out.println("Calculo com status processando " + calculo.toString());
        Thread.sleep(2000);

        //Realiza o cálculo
        Function<Calc, Integer> soma = c -> c.getNumero1() + c.getNumero2();
        CalcResultado resultado = CalcResultado.builder()
                .resultado(soma.apply(calculo))
                .calcs(new ArrayList<Calc>())
                .build();
        resultado.getCalcs().add(calculo);
        calcResultadoRepository.save(resultado);
        System.out.println("Resultado do calculo " + resultado.getResultado());

        //Atualiza o cálculo para PROCESSADO
        calculo.setStatus(Status.PROCESSADO);
        System.out.println("Calculo com status processado " + calculo.toString() + "\n");
        calcRepository.save(calculo);


    }
    
}
