package br.com.edusync.JPA.Repository;

import br.com.edusync.JPA.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProdutoRepository extends JpaRepository <Produto, Integer>{
    public List<Produto> findByDescricao(String descricao);



}
