package br.com.edusync.JPA.Serveces;

import br.com.edusync.JPA.Models.Produto;
import br.com.edusync.JPA.Repository.ProdutoRepository;
import br.com.edusync.JPA.Repository.criteria.ProdutoRepositoryCustom;
import br.com.edusync.JPA.Repository.param.ProdutoFilterParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {



    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoRepositoryCustom produtoRepositoryCustom;


    //adicionar os produtos

    private void criar(Produto produtoSalvo) {
        produtoRepository.save(produtoSalvo);


    }


    //buscar
    private Produto buscarCodigo(Integer codigo) {
        Optional<Produto> optionalDeProduto = produtoRepository.findById(codigo);
        if (optionalDeProduto.isPresent()) {
            return optionalDeProduto.get();
        }
        return null;
    }


    //findById= optional pode ou n existir e tipo um try catch ja tratado


    //deletar
    private void delete(Integer codigo) {

        produtoRepository.deleteById(codigo);
    }

    //atualizar
    private void atualizar(Integer codigo) {
        if (produtoRepository.existsById(codigo)) {
            produtoRepository.deleteById(codigo);
        }


    }
    //listartodos

    public List<Produto> listarTudo() {

        return produtoRepository.findAll();
    }



    public void update(Integer codigo, Produto produto) {
        if (produtoRepository.existsById(codigo)) {
            produtoRepository.save(produto);
        }
    }

    public void remover (Integer codigo){
        if (produtoRepository.existsById(codigo)) {
            produtoRepository.deleteById(codigo);
        }
    }

    public List<Produto> filtrar(ProdutoFilterParam param) {

        return produtoRepositoryCustom.getFiltro(param);

    }


    public List <Produto> listarPorNome(String descricaoDaBusca) {
        return produtoRepository.findByDescricaoContainingIgnoreCase(descricaoDaBusca);
    }
     }

