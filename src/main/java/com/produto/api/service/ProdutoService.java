package com.produto.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.produto.api.entities.Produto;
import com.produto.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	public List<Produto> getAll(){
		return this.produtoRepository.findAll();
	}
	
	public Optional<Produto> findByCodProduto(Long id){
		return this.produtoRepository.findByCodProduto(id);
	}
	
	public Page<Produto> findAll(Pageable pageRequest){
		
		return this.produtoRepository.findAll(pageRequest);
	}
}
