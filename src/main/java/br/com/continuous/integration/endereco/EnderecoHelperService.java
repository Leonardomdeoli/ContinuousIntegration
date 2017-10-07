package br.com.continuous.integration.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.continuous.integration.user.Usuario;


@Service
public class EnderecoHelperService {
	
	@Autowired
	private LogradouroRepository logradouroRepository;

	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private UfRepository ufRepository;
	
	public Logradouro getLogradouro(Usuario user){
		return logradouroRepository.findByCep(user.getEndereco().getCep());
	}

	public Logradouro buildEndereco(Logradouro endereco) {

		Bairro bairro = bairroRepository.findByNome(endereco.getBairro().getNome());
		if (bairro == null) {

			Cidade cidade = cidadeRepository.findByNome(endereco.getBairro().getCidade().getNome());
			if (cidade == null) {

				Uf uf = ufRepository.findBySigla(endereco.getBairro().getCidade().getUf().getSigla());
				if (uf == null) {
					uf = ufRepository.save(endereco.getBairro().getCidade().getUf());
				}
				cidade = endereco.getBairro().getCidade();
				cidade.setUf(uf);
				
				cidade.setId(null);
				cidade = cidadeRepository.save(cidade);
			}

			bairro = endereco.getBairro();
			bairro.setCidade(cidade);
			
			bairro.setId(null);
			bairro = bairroRepository.save(bairro);
		}
		endereco.setBairro(bairro);
		
		endereco.setId(null);
		return logradouroRepository.save(endereco);
	}

}
