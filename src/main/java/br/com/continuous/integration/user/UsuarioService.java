package br.com.continuous.integration.user;

import javax.transaction.Transactional;

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

	@Transactional
	public Usuario save(Usuario user) {
		LOGGER.info("Salvando o usuário " + user.getNome());
		return userRepository.save(user);
	}

	@Transactional
	public Usuario update(Usuario user) {
		LOGGER.info("Atualizando o usuário " + user.getNome());
		return userRepository.save(user);
	}

	public void delete(Long id) {
		LOGGER.info("Removendo  usuário com código " + id);
		userRepository.delete(id);
	}

}
