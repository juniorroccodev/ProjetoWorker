package com.wolkersomar.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "seq_result", sequenceName = "seq_result", allocationSize = 1, initialValue = 1)
@Setter
@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CalcResultado implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_result")
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Calc> calcs;

    private Integer resultado;

}
