package br.com.continuous.integration.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Leonardo Mendes
 *
 */
public interface UfRepository extends JpaRepository<Uf, Long> {

	public Uf findBySigla(String sigla);
}
