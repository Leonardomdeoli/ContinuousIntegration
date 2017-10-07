package br.com.continuous.integration.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.continuous.integration.utils.BaseEntity;

/**
 * @author Leonardo Mendes
 *
 */
@Entity
public class Cidade extends BaseEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "O campo cidade não pode ser nulo")
	@NotEmpty(message = "O campo cidade não pode ser vazio")
	@Column(length = 25, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "uf", nullable = false)
	private Uf uf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
}
