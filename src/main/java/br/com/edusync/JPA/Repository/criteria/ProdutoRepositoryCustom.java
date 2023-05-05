package br.com.edusync.JPA.Repository.criteria;

import br.com.edusync.JPA.Models.Produto;
import br.com.edusync.JPA.Repository.param.ProdutoFilterParam;

import java.util.List;

public interface ProdutoRepositoryCustom {


    List<Produto> getFiltro (ProdutoFilterParam param);

    List<Produto>positivo(Integer codigo);
}
