package project.ton.test;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.ton.dao.hibernate.DaoFactory;
import project.ton.dao.i.UserDAO;
import project.ton.dto.UserDTO;
import project.ton.enums.ProviderSituation;
import project.ton.hibernate.HibernateUtil;
import project.ton.model.User;
import project.ton.util.ExceptionUtil;
import project.ton.util.JsonUtil;

public class UserWSTest {

	private static String sUrlApplicationWs = "http://localhost:8180/TON-WS/WS/Usuario";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper tConversorJsonJava = new ObjectMapper();

		User user1 = new User(1, "Valentina", "Margarita", "valen@hotmail", "12.212.212-21", "100.000.000-03",
				"(41)3032-2120", "(41)9798-9695", "Rua rei ragnar", "80.800-000", "123456", new Date(),
				ProviderSituation.N);

		// Convertendo o objeto para JSON
		String tUserJson1 = tConversorJsonJava.writeValueAsString(user1);
		System.out.println("Usuario convertido em JSON");
		System.out.println(tUserJson1);

		User user2 = new User(2, "Miguel", "Valadares", "miguel@gmail.com", "12.222.111-00", "100.001.001-10",
				"(41)3434-3131", "(41)97955997", "Rua juscelino", "80.080-090", "123456", new Date(),
				ProviderSituation.S);

		// Convertendo o objeto para JSON
		String tUserJson2 = tConversorJsonJava.writeValueAsString(user2);
		System.out.println("Usuario Convertido em JSON");
		System.out.println(tUserJson2);

		// Criando DAO
		UserDAO tUserDAO = DaoFactory.getUserDAO();
		try {

			HibernateUtil.iniciarTransacao();


			// Incluindo os objetos
			System.out.println();
			System.out.println("Incluindo os Usuarios");

			System.out.println("Incluindo os usuarios validos");
			String tResultadoJson = JsonUtil.enviarPost(sUrlApplicationWs + "/Cadastrar", tUserJson1);

			System.out.println("Resposta Recebida");
			System.out.println(tResultadoJson);
			UserDTO tDto = tConversorJsonJava.readValue(tResultadoJson, UserDTO.class);
			if (tDto.isOk()) {
				user1 = tDto.getObjeto();
				System.out.println("\tOK... : " + tDto.getMensagem());
				System.out.println("\tUsuario : " + user1);
			} else
				System.out.println("\tERRO. : " + tDto.getMensagem());

			String tResultadoJson2 = JsonUtil.enviarPost(sUrlApplicationWs + "/Cadastrar", tUserJson2);

			System.out.println("Resposta Recebida");
			System.out.println(tResultadoJson2);
			UserDTO tDto2 = tConversorJsonJava.readValue(tResultadoJson2, UserDTO.class);
			if (tDto.isOk()) {
				user2 = tDto2.getObjeto();
				System.out.println("\tOk..." + tDto2.getMensagem());
				System.out.println("\tUsuario. :" + user2);
			} else {
				System.out.println("\tERRO.  :" + tDto2.getMensagem());
			}

			// Listando todos os usuarios
			System.out.println();
			System.out.println("Listando os usuarios do cadastro");

			String tResultadoJson3 = JsonUtil.enviarGet(sUrlApplicationWs + "/Pesquisar");

			System.out.println("Resposta Recebida");
			System.out.println(tResultadoJson3);
			UserDTO tDto3 = tConversorJsonJava.readValue(tResultadoJson3, UserDTO.class);
			System.out.println("\tOK... : " + tDto3.getMensagem());
			for (User tUser : tDto3.getLista()) {
				System.out.println("\tUser : " + tUser);
			}

			HibernateUtil.confirmarTransacao();
		} catch (Exception tExecpt) {
			ExceptionUtil.mostrarErro(tExecpt, "Erro na criação do usuario");
			HibernateUtil.cancelarTransacao();
		} finally {
			// Fechando a conexão Hibernate
			HibernateUtil.fecharConexao();
		}

	}

}
