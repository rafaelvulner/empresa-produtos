package com.produto.api.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.api.dtos.UsuarioDto;
import com.produto.api.entities.Produto;
import com.produto.api.entities.Usuario;
import com.produto.api.response.Response;
import com.produto.api.service.ProdutoService;
import com.produto.api.service.UsuarioService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> getAll(){
		return this.produtoService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Produto>> getProduto(@PathVariable("id") Long id){
		System.out.println(id);
		Response<Produto> response = new Response<Produto>();		
		
		Optional<Produto> produto = this.produtoService.findByCodProduto(id);
		
		if(produto.isPresent()) {
			
			response.setData(produto.get());
		}else {
			
			response.getErrors().add("Codigo inválido!");			
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<Usuario>> cadastrarProdutos(@RequestBody UsuarioDto usuarioDto, BindingResult result) {
		
		
		Response<Usuario> response = new Response<Usuario>();		
		
		Optional<Usuario> usuario = this.usuarioService.findByUsuario(usuarioDto.getUsuario());
		
		if(usuario.isPresent()) {
			
			Usuario usuarioSave = this.convertDtoParaProduto(usuario.get(),usuarioDto);
			response.setData(usuarioService.save(usuarioSave));
			
		}else {
			
			result.addError(new ObjectError("Usuario:", "Usuario invalido"));
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));			
			return ResponseEntity.badRequest().body(response);
		}
		
		
		return ResponseEntity.ok(response);
		
		
	}
	
	private Usuario convertDtoParaProduto(Usuario usuario,UsuarioDto usuarioDto) {
		
		usuario.setProdutos(usuarioDto.getProdutos());
		
		return usuario;
		
	}

}
