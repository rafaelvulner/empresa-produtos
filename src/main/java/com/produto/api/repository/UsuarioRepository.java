package com.produto.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario save(Usuario usuario);
	
	List<Usuario> findAll();
	
	Optional<Usuario> findByUsuario(String string);

}
