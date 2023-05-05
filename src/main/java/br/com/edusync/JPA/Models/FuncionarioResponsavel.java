package br.com.edusync.JPA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity (name = "tb funcionario_responsavel")
public class FuncionarioResponsavel {

    @Id
    @Column(name = "id_responsavel")
    private Integer idResponsavel;


    @ManyToOne
    private EstoqueMovimento estoque_movimento;
    @Column(length = 256)
    private String nome;
    @Column(length = 50)
    private String cpf;

}

 //falta fazer o controller, repository e o servece