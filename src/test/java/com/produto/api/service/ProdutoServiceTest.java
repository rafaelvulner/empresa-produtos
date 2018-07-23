package com.produto.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.produto.api.entities.Produto;
import com.produto.api.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceTest {
	
	@MockBean
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.produtoRepository.save(Mockito.any(Produto.class))).willReturn(new Produto());
		BDDMockito.given(this.produtoRepository.findByCodProduto(Mockito.anyLong())).willReturn(Optional.ofNullable(new Produto()));
	}
	
	@Test
	public void save() {
		Produto produto = this.produtoService.save(new Produto());

		assertNotNull(produto);
	}
	
	@Test
	public void findByCodProduto() {
		Optional <Produto> produto = this.produtoService.findByCodProduto(1L);
		
		assertTrue(produto.isPresent());
	}

}
