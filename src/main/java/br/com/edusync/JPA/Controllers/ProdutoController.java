package br.com.edusync.JPA.Controllers;

import br.com.edusync.JPA.Models.Produto;
import br.com.edusync.JPA.Repository.param.ProdutoFilterParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


//CRUD
// CRIAR, LISTAR, BUSCAR E DELETAR
// criar, buscar e deletar criados!!!!
// falata fazer o listar, filtrar e o criterabuilder

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    //adicionar
    @GetMapping(value = "/adicionar")
    public ResponseEntity novoProduto(@RequestBody Produto produto) {
        return new ResponseEntity(produto, HttpStatus.CREATED);
    }


    //listar

    @GetMapping(value = "/listar")
    public ResponseEntity listarProduto() {
        return new ResponseEntity(service.listarTudo(), HttpStatus.OK);
    }
    @GetMapping(value = "/nome/{busca}")
    public ResponseEntity listarPorNome(@RequestParam(defaultValue = "") String busca) {
        return new ResponseEntity(service.listarPorNome(busca), HttpStatus.OK);
    }

    //atualizar
    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity update(@PathVariable Integer codigo, @RequestBody Produto produto) {
        service.update(codigo, produto);
        return new ResponseEntity("Produto " + codigo + " atualizado com sucesso!", HttpStatus.OK);
    }


    //deletar
    @DeleteMapping(value = "/deletar/{codigo}")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        service.remover(codigo);
        return new ResponseEntity("Produto " + codigo + " deletado com sucesso!", HttpStatus.OK);
    }

    //filtros


    @GetMapping(value = "/filtrar")
    public ResponseEntity filtrar(ProdutoFilterParam param) {
        return new ResponseEntity(service.filtrar(param), HttpStatus.OK);

    }



    @GetMapping(value = "/filtrarprodutoscadastrados")
    public ResponseEntity filtrarProdutosCadastrados(@RequestParam(required = false) String descricao,
                                                     @RequestParam(required = false) BigDecimal precoVenda,
                                                     @RequestParam(required = false) Integer saldoAtual) {


        return new ResponseEntity(service.filtrar(new ProdutoFilterParam()), HttpStatus.OK);
    }
}




