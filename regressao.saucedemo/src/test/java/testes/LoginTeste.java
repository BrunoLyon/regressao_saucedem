package testes;


import org.junit.Test;

import elementos.Elementos;
import homePage.MassaDeDados;
import metodos.Metodos;

public class LoginTeste {
	// criar ponteiro
	Metodos metodos = new Metodos();
	Elementos el = new Elementos();
	MassaDeDados md = new MassaDeDados();



	
	@Test
	public void loginValido() {
		metodos.abrirNavegador();

		metodos.escrever(el.username, md.userNameValido);
		metodos.escrever(el.passaword, md.passwordValido);
		metodos.clicar(el.btnLogin);
		metodos.validarUrl(md.urlLoginValido);
		metodos.evidencia("ct - loginValido");
		metodos.fecharNavegador();

	}

}
