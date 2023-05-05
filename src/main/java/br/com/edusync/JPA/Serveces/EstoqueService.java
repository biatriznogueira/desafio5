package br.com.edusync.JPA.Serveces;

import br.com.edusync.JPA.Models.EstoqueMovimento;
import br.com.edusync.JPA.Repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    private EstoqueMovimento estoqueMovimentoRepository;
    EstoqueService estoqueMovimentoCustom;
    //criar
    private void adicionar (EstoqueMovimento estoqueSalvo) {
        estoqueMovimentoRepository.save(estoqueSalvo);


    }
    //buscar
    private  EstoqueMovimento buscarCodigo(Integer codigo) {
        Optional<EstoqueMovimento> optionalDeEstoque = estoqueMovimentoRepository.findById(codigo);
        if (optionalDeEstoque.isPresent()) {
            return optionalDeEstoque.get();
        }return null;
    }

    //deletar
    private void delete (Integer codigo){

        estoqueMovimentoRepository.deleteById(codigo);
    }

    //atualizar

    private void atualizar (Integer codigo){
        if (estoqueMovimentoRepository.existsById(codigo)){
            estoqueMovimentoRepository.deleteById(codigo);
        }
    }
//listartodos

    public List<EstoqueMovimento> listarTudo(){
        return estoqueMovimentoRepository.findAll();

    }
    public List<EstoqueMovimento>listarHistoricoEstoque(Integer codigo){


        return estoqueMovimentoCustom.listarHistoricoEstoque(codigo);
    }

    public void remover(Integer codigo) {
        if (estoqueMovimentoRepository.existsById(codigo)) {
            estoqueMovimentoRepository.deleteById(codigo);
        }

    }


    public void update(Integer codigo, EstoqueMovimento estoqueMovimento) {
        if (estoqueMovimentoRepository.existsById(codigo)) {
            estoqueMovimentoRepository.save(estoqueMovimento);
        }
    }

}
