package br.edu.universidadedevassouras.SCP.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@Entity
public class Presenca implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpresenca;
    @Column(nullable = false)
    private Date data;
    @Column(nullable = false)
    private Boolean situacao;
    @ManyToOne(optional = false)
    @JoinColumn(name="idpessoa")
    private Pessoa pessoaidPessoa;


}
