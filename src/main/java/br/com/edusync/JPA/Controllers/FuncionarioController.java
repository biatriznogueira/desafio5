package br.com.edusync.JPA.Controllers;

import br.com.edusync.JPA.Models.FuncionarioResponsavel;
import br.com.edusync.JPA.Serveces.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class FuncionarioController {
    private FuncionarioService serviceF;


    //adicionar
    @GetMapping(value = "/funcionario/adicionar")
    public ResponseEntity novoFuncionario(@RequestBody FuncionarioResponsavel funcionarioResponsavel) {
        return new ResponseEntity(funcionarioResponsavel, HttpStatus.CREATED);
    }


    //listar
    @GetMapping(value = "/funcionario/listar")
    public ResponseEntity listarTodosFuncionario() {
        return new ResponseEntity(serviceF.buscarCodigo(), HttpStatus.OK);
    }

    //deletar
    @DeleteMapping(value = "/funcionario/delete")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        serviceF.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);


    }
    //alterar


    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity atualizarFuncionario(@PathVariable Integer codigo, @RequestBody FuncionarioResponsavel funcionarioResponsavel){
        serviceF.update(codigo, funcionarioResponsavel);
        return new ResponseEntity("Funcionario " + codigo + " atualizado com sucesso!", HttpStatus.OK);
    }

}
