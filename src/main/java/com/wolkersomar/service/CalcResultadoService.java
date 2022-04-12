package com.wolkersomar.service;

import com.wolkersomar.models.CalcResultado;
import com.wolkersomar.repository.CalcResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CalcResultadoService {

    @Autowired
    private CalcResultadoRepository calcResultadoRepository;

    @Transactional(readOnly = true)
    public CalcResultado findById(Long id){
        return calcResultadoRepository.findById(id).get();
    }

    @Transactional(rollbackFor = Exception.class)
    public CalcResultado save(CalcResultado calcResultado){
        Optional<CalcResultado> queryResultado = calcResultadoRepository.getResultado(calcResultado.getResultado());
        if (queryResultado == null) {
            return calcResultadoRepository.save(calcResultado);
        } else {
            return queryResultado.get();
        }
    }

}