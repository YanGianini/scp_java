package br.edu.universidadedevassouras.SCP.Model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpessoa;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private int matricula;
    @Column(nullable = true)
    private Date nascimento;
    @Column(nullable = true)
    private char genero;
    @Column(nullable = true)
    @Lob
    private String foto;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

}
