package com.produto.api.dtos;

import java.util.List;

import com.produto.api.entities.Produto;

public class UsuarioDto {
	
	private Long id;
	
	private String nome;
	
	private String usuario;
	
	private String senha;
	
	private List<Produto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", nome=" + nome + ", usuario=" + usuario + ", senha=" + senha + ", produtos="
				+ produtos + "]";
	}

	



	

}
