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
public class Bairro extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "O campo bairro não pode ser vazio")
	@NotNull(message = "O campo bairro não pode ser nulo")
	@Column(length = 30, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "cidade", nullable = false)
	private Cidade cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
