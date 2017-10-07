package br.com.continuous.integration.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Leonardo Mendes
 *
 */
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	public Cidade findByNome(String nome);
}
