package br.com.edusync.JPA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity (name = "tb_produto")
public class Produto {

    //criando as tabelas

    @Id
    @Column(name = "id_produto")
    private Integer codigoProduto;
    @ManyToOne
    private EstoqueMovimento estoque_movimento;
    @Column(length = 256)
    private String descricao;

    @Column(name = "preco_venda")
    private BigDecimal precoVenda;

    private Integer saldoAtual;

    //falta fazer o controller, repository e o servece
    //servece feito!!
    //repository feito!!
    //preciso ajeitar um erro no service



}
