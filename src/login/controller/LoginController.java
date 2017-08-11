package login.controller;

public class LoginController {

	public void checkLogin(String username, String password) throws Exception {

		// Comparação para verificar se o username é diferente de nulo ou diferente de vazio
		if (username == null || username.trim().isEmpty())
			throw new Exception("User is offline");

		// Comparação para verificar se o password é diferente de nulo ou diferente de vazio
		if (password == null || password.trim().isEmpty())
			throw new Exception("Password not informed");

		if (!(username.equals("leonardosiqueira@gea.inatel.br") && password.equals("123456")))
			throw new Exception("Invalid user or password");

		if (!(username.equals("admin") && password.equals("admin")))
			throw new Exception("Invalid user or password");

	}
}
