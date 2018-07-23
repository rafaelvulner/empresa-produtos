package com.produto.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.api.dtos.UsuarioDto;
import com.produto.api.entities.Usuario;
import com.produto.api.response.Response;
import com.produto.api.service.UsuarioService;
import com.produto.api.utils.PasswordUtils;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> getAll(){
		return this.usuarioService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Usuario>> findById(@PathVariable("id") Long id){
		
		Response<Usuario> response = new Response<Usuario>();
		
		Optional<Usuario> usuario = this.usuarioService.findById(id);
		
		response.setData(usuario.get());
		
		return ResponseEntity.ok(response);		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Response<Usuario>> createUser(@RequestBody UsuarioDto usuarioDto){
		
		Response<Usuario> response = new Response<Usuario>();	
		
		Usuario usuario = this.convertDtoToUsuario(usuarioDto);

		response.setData(usuarioService.save(usuario));

		return ResponseEntity.ok(response);
		
	}

	private Usuario convertDtoToUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		
		usuario.setNome(usuarioDto.getNome());
		usuario.setUsuario(usuarioDto.getUsuario());
		usuario.setSenha(PasswordUtils.generateBCrypt(usuarioDto.getSenha()));
		
		return usuario;
	}

}
