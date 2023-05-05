package br.com.edusync.JPA.Repository;

import br.com.edusync.JPA.Models.EstoqueMovimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueMovimento, Integer> {


}
