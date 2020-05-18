package com.example.vmperuse.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.vmperuse.model.Usuario;

public interface UsuarioDAO extends CrudRepository <Usuario ,Integer>{
	// Para relacionar Email e Senha
	public Usuario findByEmailAndSenha(String email, String senha);

}
