package br.com.continuous.integration.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import br.com.continuous.integration.endereco.Logradouro;
import br.com.continuous.integration.utils.BaseEntity;


/**
 * @author Leonardo Mendes
 *
 */
@Entity
@EntityListeners(UsuarioListener.class)
@Table(name = "usuario")
public class Usuario extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O nome é obrigátorio")
	@Column(length = 70, nullable = false)
	private String nome;

	@NotBlank(message = "O telefone é obrigátorio")
	@Column(length = 16, nullable = false)
	private String telefone;
	
	@NotBlank(message = "O email é obrigátorio")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "cod_endereco", nullable = false)
	private Logradouro endereco;
	
	@Column(length = 5)
	private int numero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Logradouro getEndereco() {
		return endereco;
	}

	public void setEndereco(Logradouro endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}