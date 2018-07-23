package com.produto.api.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.produto.api.entities.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Before
	public void setUp() throws Exception {
		this.produtoRepository.save(this.obterProduto());
	}

	@After
	public final void tearDown() {
		this.produtoRepository.deleteAll();
	}
	
	@Test
	public void save() {
		Produto produto = this.produtoRepository.save(this.obterProduto());
		
		Assert.assertEquals(this.obterProduto(), produto);
	}
	
	@Test
	public void findByCodProduto() {
		
		Optional<Produto> produto = this.produtoRepository.findByCodProduto(102030L);
		
		Assert.assertEquals(this.obterProduto().getCodProduto(), produto.get().getCodProduto());
		
	}

	private Produto obterProduto() {
		Produto produto = new Produto();
		
		produto.setCodProduto(102030L);
		produto.setDataCricao(Calendar.getInstance());
		produto.setDescProduto("Playstation 4");
		produto.setValorUnitario(new BigDecimal("1800.00"));
		
		return produto;
	}

}
