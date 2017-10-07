package br.com.continuous.integration.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Leonardo Mendes
 *
 */
public interface BairroRepository extends JpaRepository<Bairro, Long> {

	public Bairro findByNome(String nome);
}
