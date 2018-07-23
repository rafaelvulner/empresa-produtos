package com.produto.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.api.entities.Usuario;
import com.produto.api.repository.UsuarioRepository;
import com.produto.api.utils.PasswordUtils;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario){
		
		return this.usuarioRepository.save(usuario);
		
	}
	
	public List<Usuario> getAll(){
		
		return this.usuarioRepository.findAll();
	}
	
	public Optional<Usuario> findById(Long id) {
		return this.usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> findByUsuario(String usuario) {
		return this.usuarioRepository.findByUsuario(usuario);
	}

}
