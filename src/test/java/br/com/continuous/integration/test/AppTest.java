package br.com.continuous.integration.test;

import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.continuous.integration.endereco.Uf;
import br.com.continuous.integration.user.UsuarioController;
import br.com.continuous.integration.utils.ServicePath;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest{
	
	private static final Logger LOGGER = Logger.getLogger(AppTest.class);

	@Autowired
	private UsuarioController usuarioController;

	private MockMvc mockMvc;
	
	@Before
	public void init() throws IOException {
		mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).setControllerAdvice(new Exception()).build();
	}

	@Test
	public void enviandoUmJsonVazioBadRequest() throws Exception {
		mockMvc.perform(post(ServicePath.USER_PATH + "/")
						.contentType(APPLICATION_JSON)
						.content(new JSONObject().toString().getBytes()))
				.andDo(print())
				.andExpect(status().isBadRequest());

	}

	@Test
	public void enviandoUmJsonValido() throws Exception {
		mockMvc.perform(post(ServicePath.USER_PATH + "/")
						.contentType(APPLICATION_JSON)
						.content(buildJson()))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void buscandoUsuario() throws Exception {
		mockMvc.perform(get(ServicePath.USER_PATH + "/id/10")
						.accept(APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("nome", is("Leonardo Mendes de Oliveira")))
				.andExpect(jsonPath("email", is("leonardo@gmail.com")));
	}

	@Test
	public void printInfo() throws Exception {
		mockMvc.perform(get(ServicePath.USER_PATH + "/id/1")).andDo(print());

	}
	
	@Test
	public void testUf() throws Exception {
		LOGGER.info(Uf.getSerialversionuid());
	}

	private byte[] buildJson() throws JSONException {
		
		JSONObject ufJson = new  JSONObject();
		ufJson.put("id", 13);
		ufJson.put("sigla", "SP");
		
		JSONObject cidadeJson = new  JSONObject();
		cidadeJson.put("id", 12);
		cidadeJson.put("nome", "São Paulo");
		cidadeJson.put("uf", ufJson);
		
		JSONObject bairroJson = new  JSONObject();
		bairroJson.put("cidade", cidadeJson);
		bairroJson.put("id", 11);
		bairroJson.put("nome", "São Paulo");
		
		JSONObject enderecoJson = new  JSONObject();
		enderecoJson.put("id", 10);
		enderecoJson.put("nome", "Alemanha");
		enderecoJson.put("cep", "38410250");
		enderecoJson.put("bairro", bairroJson);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nome", "leonardo");
		jsonObject.put("telefone", "99143829");
		jsonObject.put("email", "leonardo@gmail.com");
		jsonObject.put("numero", 121);
		jsonObject.put("endereco", enderecoJson);
		
		return jsonObject.toString().getBytes();
	}
}