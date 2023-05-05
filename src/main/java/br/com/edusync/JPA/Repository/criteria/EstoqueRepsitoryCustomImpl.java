package br.com.edusync.JPA.Repository.criteria;

import br.com.edusync.JPA.Models.EstoqueMovimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class EstoqueRepsitoryCustomImpl implements EstoqueRepositoryCustom {
    private EntityManager entityManager;
    public EstoqueRepsitoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<EstoqueMovimento> listarHistoricoDeMovimento(Integer produtoId){
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<EstoqueMovimento> estoqueMovimentoCriteriaQuery = criteriaBuilder.createQuery(EstoqueMovimento.class);

        Root<EstoqueMovimento> produtoRoot = estoqueMovimentoCriteriaQuery.from(EstoqueMovimento.class);

        estoqueMovimentoCriteriaQuery.select(produtoRoot).where(criteriaBuilder.equal(produtoRoot.get("produto"), produtoId));

        TypedQuery<EstoqueMovimento> estoqueMovimentoTypedQuery = this.entityManager.createQuery((estoqueMovimentoCriteriaQuery));

        return estoqueMovimentoTypedQuery.getResultList();

        }



}
