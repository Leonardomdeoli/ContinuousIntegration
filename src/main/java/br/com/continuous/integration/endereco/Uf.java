package br.com.continuous.integration.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.continuous.integration.utils.BaseEntity;


/**
 * @author Leonardo Mendes 
 *
 */
@Entity
public class Uf extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "sigla", columnDefinition = "char(2)", nullable = false, unique = true)
	private String sigla;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
