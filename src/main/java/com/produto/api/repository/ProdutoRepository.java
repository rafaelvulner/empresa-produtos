package com.produto.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.api.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto save(Produto produto);
	
	Optional<Produto> findByCodProduto(Long ig);
	

}
