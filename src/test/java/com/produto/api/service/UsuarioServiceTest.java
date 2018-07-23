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

import com.produto.api.entities.Usuario;
import com.produto.api.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@MockBean
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.usuarioRepository.save(Mockito.any(Usuario.class))).willReturn(new Usuario());
		BDDMockito.given(this.usuarioRepository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(new Usuario()));
		BDDMockito.given(this.usuarioRepository.findByUsuario(Mockito.anyString())).willReturn(Optional.ofNullable(new Usuario()));
	}
	
	@Test
	public void save() {
		Usuario Usuario = this.usuarioService.save(new Usuario());

		assertNotNull(Usuario);
	}
	
	@Test
	public void findById() {
		Optional<Usuario> Usuario = this.usuarioService.findById(1L);

		assertTrue(Usuario.isPresent());
	}
	
	@Test
	public void findByUsuario() {
		Optional<Usuario> Usuario = this.usuarioService.findByUsuario("rafaelusers");

		assertTrue(Usuario.isPresent());
	}

}
