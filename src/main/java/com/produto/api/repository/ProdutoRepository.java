package com.produto.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produto.api.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Optional<Produto> findByCodProduto(Long ig);
	

}
