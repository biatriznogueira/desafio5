package br.com.edusync.JPA.Repository.param;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoFilterParam {
    private String Descricao;
    private BigDecimal PrecoVenda;
    private Integer saldoAtual;

}

