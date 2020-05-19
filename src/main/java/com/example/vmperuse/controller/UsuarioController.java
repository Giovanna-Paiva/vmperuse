package com.example.vmperuse.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vmperuse.dao.UsuarioDAO;
import com.example.vmperuse.model.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;

	@PostMapping("/login")
	public ResponseEntity<Usuario> loginPorEmail(@RequestBody Usuario incompleto) {
		Usuario logado = dao.findByEmailAndSenha(incompleto.getEmail(), incompleto.getSenha());
		try {
			if (logado != null) {
				return ResponseEntity.ok(logado);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception ex) {
			return ResponseEntity.status(500).build();
		}
	}

	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<Usuario>> buscarTodos() {
		ArrayList<Usuario> lista = (ArrayList<Usuario>) dao.findAll();
		return ResponseEntity.ok(lista);
	}
}
