package br.com.continuous.integration.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import br.com.continuous.integration.utils.BaseEntity;


/**
 * @author Leonardo Mendes
 *
 */
@Entity
public class Logradouro extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O campo logradouro é obrigátorio")
	@Column(length = 30, nullable = false)
	private String nome;
	
	@NotBlank(message = "O campo CEP é obrigátorio")
	@Column(length = 9, nullable = false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "bairro", nullable = false)
	private Bairro bairro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
}
