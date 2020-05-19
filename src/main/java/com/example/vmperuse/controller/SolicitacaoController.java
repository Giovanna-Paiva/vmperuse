package com.example.vmperuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vmperuse.dao.SolicitacaoDAO;
import com.example.vmperuse.model.Item;
import com.example.vmperuse.model.Solicitacao;

@RestController
public class SolicitacaoController {

	@Autowired
	SolicitacaoDAO sdao;

	@PostMapping("/solicitacoes/nova")
	public ResponseEntity<Solicitacao> adicionarSolicitacao(@RequestBody Solicitacao nova) {
		try {
			for (Item it : nova.getItensSolicitacao()) {
				it.setSolicitacao(nova);
			}
			sdao.save(nova);
			return ResponseEntity.ok(nova);
		} catch (Exception ex) {
			return ResponseEntity.status(400).build();
		}
	}

}
