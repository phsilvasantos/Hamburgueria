package br.com.hamburgueria.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Lanche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLanche;
    private String nomeLanche;
    private Double valorLanche;
    private Boolean disponibilidadeLanche = true;

}
