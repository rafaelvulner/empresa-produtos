package com.produto.api.repository;

import java.util.ArrayList;
import java.util.List;
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

import com.produto.api.entities.Usuario;
import com.produto.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;


	@Before
	public void setUp() throws Exception {
		
		this.usuarioRepository.saveAll(obterListUsuario());
	}

	@After
	public final void tearDown() {
		this.usuarioRepository.deleteAll();
	}

	@Test
	public void findByUsuario() {

		Optional<Usuario> usuario = this.usuarioRepository.findByUsuario("rafaeluser");

		Assert.assertEquals("rafaeluser", usuario.get().getUsuario());

	}
	
	@Test
	public void save() {
		Usuario usuario = this.usuarioRepository.save(obterDadosUsuario());
		
		Assert.assertEquals(obterDadosUsuario(), usuario);
	}

	public Usuario obterDadosUsuario() {
		Usuario usuario = new Usuario();

		usuario.setId(1L);
		usuario.setNome("rafael");
		usuario.setUsuario("rafaeluser");
		usuario.setSenha(PasswordUtils.generateBCrypt("123"));

		return usuario;
	}

	public List<Usuario> obterListUsuario() {
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();

		usuario1.setId(1L);
		usuario1.setNome("rafael");
		usuario1.setUsuario("rafaeluser");
		usuario1.setSenha(PasswordUtils.generateBCrypt("123"));
		
		usuario2.setId(2L);
		usuario2.setNome("Elias");
		usuario2.setUsuario("eliasuser");
		usuario2.setSenha(PasswordUtils.generateBCrypt("1234"));
		
		usuario3.setId(1L);
		usuario3.setNome("Monteiro");
		usuario3.setUsuario("monteirouser");
		usuario3.setSenha(PasswordUtils.generateBCrypt("12345"));
		
		list.add(usuario1);
		list.add(usuario2);
		list.add(usuario3);
		
		return list;
		
	}
	

}
