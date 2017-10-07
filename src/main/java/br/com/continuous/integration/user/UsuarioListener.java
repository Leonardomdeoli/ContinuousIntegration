package br.com.continuous.integration.user;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class UsuarioListener {
	
	@PrePersist
	private void beforeInsert(Usuario user) {
		System.out.println("Antes Inserir");
	}
	
	@PostPersist
	private void afterInsert(Usuario user) {
		System.out.println("Apos Inserir");
	}
}
