package br.com.continuous.integration.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioRepository userRepository;

	public Usuario getUser(Long id) {
		LOGGER.info("Buscando o usuário de código " + id);
		return userRepository.findOne(id);
	}

	public Usuario save(Usuario user) {
		LOGGER.info("Salvando o usuário " + user.getNome());
		return userRepository.save(user);
	}

}
