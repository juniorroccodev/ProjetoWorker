package com.wolkersomar.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "seq_calc", sequenceName = "seq_calc", allocationSize = 1, initialValue = 1)
@Setter
@Getter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Calc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_calc")
    private Long id;

    private Integer numero1;

    private Integer numero2;

    private Status status;

}
