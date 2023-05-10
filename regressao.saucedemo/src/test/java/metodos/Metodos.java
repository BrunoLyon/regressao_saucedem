package metodos;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

import drivers.DriversFactory;

public class Metodos extends DriversFactory {

	public void abrirNavegador() {
		// configurando navegador
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		// escolhendo navegador que vai ser executado
		driver = new FirefoxDriver();
		// site que vai ser carregado
		driver.get("https://www.saucedemo.com");
		// configuracao de maximinizar navegador
		driver.manage().window().maximize();
	}

	public void fecharNavegador() {
		driver.quit();
	}

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}

	public void validarUrl(String texto) {
		String validarUrl = driver.getCurrentUrl();
		assertTrue(validarUrl.contains(texto));

	}

	public void evidencia(String nomeTeste) {
		// tive que fazer um cast pq o scrShot nao e do tipo webdriver
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias/"+nomeTeste+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRO AO TIRAR EVIDENCIA");
		}
	}

}
