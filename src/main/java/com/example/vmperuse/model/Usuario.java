package com.example.vmperuse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "racf", length = 7)
	private String racf;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "senha", length = 8)
	private String senha;

	@Column(name = "email", length = 80)
	private String email;

	@Column(name = "telefone", length = 20)
	private String telefone;

	@Column(name = "setor", length = 50)
	private String setor;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "linkfoto", length = 200)
	private String linkfoto;

	@OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("solicitante")
	private List<Solicitacao> pedidos;

	// GETs e SETs

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getLinkfoto() {
		return linkfoto;
	}

	public void setLinkfoto(String linkfoto) {
		this.linkfoto = linkfoto;
	}

	public List<Solicitacao> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Solicitacao> pedidos) {
		this.pedidos = pedidos;
	}
}
