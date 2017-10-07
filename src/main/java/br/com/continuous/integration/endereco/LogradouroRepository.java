package br.com.continuous.integration.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Leonardo Mendes
 *
 */
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

	public Logradouro findByCep(String cep);
}
