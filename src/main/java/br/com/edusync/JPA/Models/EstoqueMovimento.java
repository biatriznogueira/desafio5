package br.com.edusync.JPA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity (name = "tb_estoque_movimento")
public class EstoqueMovimento {

      //primarykey
      @Id
        private Integer id;

        private Timestamp dataHora;

        @Column(length = 1, name = "tipo_movimento")
        private String tipoMovimento;

        private Integer quantidade;

    public void save(EstoqueMovimento estoqueSalvo) {
    }


    //falta fazer o controller, repository e o servece
}

