package br.com.continuous.integration.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.continuous.integration.endereco.EnderecoHelperService;
import br.com.continuous.integration.endereco.Logradouro;
import br.com.continuous.integration.utils.Message;
import br.com.continuous.integration.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.USER_PATH)
public class UsuarioController {

	private Message<Usuario> message = new Message<>();

	@Autowired
	private UsuarioService usuService;
	
	@Autowired
	private EnderecoHelperService enderecoHelperService;

	@PostMapping
	public ResponseEntity<Message<Usuario>> insert(@RequestBody Usuario user) {
		try {
			user.setId(null);
			
			Logradouro logradouro = enderecoHelperService.getLogradouro(user);

			if (logradouro == null) {
				logradouro = enderecoHelperService.buildEndereco(user.getEndereco());
			}

			user.setEndereco(logradouro);
			user = usuService.save(user);

			message.AddField("mensagem", String.format(" O usuário %s foi salvo com sucesso", user.getNome()));
			message.setData(user);

			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message.AddField("mensagem", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}
	}
	
	@GetMapping(value = "/id/{id}")
	public Usuario getUser(@PathVariable(name = "id") Long id) {
		Usuario usuario = usuService.getUser(id);
		return usuario;
	}
}
