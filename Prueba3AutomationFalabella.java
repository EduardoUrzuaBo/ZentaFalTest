package com.humanevolition.zenta.falabella;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.humanevolution.Common;
import com.humanevolution.Formularios;

public class PruebaFuncional {

	WebDriver driver;
	private static String baseUrl;
	public String menuCategorias = "(//p[contains(text(),'CATEGORÍAS')])[2]";
	public String menuTecnologia = "(//span[contains(text(),'Tecnología')])[1]";
	public String menuConsolas = "(//a[contains(text(),'Consolas')])[2]";
	public String btnVerProducto = "(//button[contains(text(),'VER PRODUCTO')])[1]";
	public String inputFiltrar = "//input[@id='testId-Multiselect-Tipo']";
	public String btnPLus = "(//button[contains(text(),'VER PRODUCTO')])[1]";
	public String xboxOne = "(//span[contains(text(),'Xbox One')])[1]";


	public static void dynamicXpathConsola(String console, WebDriver driver){
    driver.findElement(By.id("//span[contains(text(),'"+xboxOne+"')]")).click();
    }

	@Test
	public void test() throws Exception {
		driver = new ChromeDriver();
		Common common = new Common(driver);
		driver.manage().window().maximize();
 

		try {



  			 // WorkFlow is calling methods
			// 1.- Entrar a: https://www.falabella.com/falabella-cl/
			baseUrl = "https://www.falabella.com/falabella-cl/";
			driver.get(baseUrl);

			// Formulario Falabella
			//test.llenarFormularioContactanos();

		//2.- Ir a “CATEGORÍAS”, luego “Tecnología”, y hacer clic en “Consolas”(Videojuegos)
		driver.findElement(menuCategorias).click();

		driver.findElement(menuTecnologia).click();
		driver.findElement(menuConsolas).click();

			//3.- Filtrar la búsqueda por “Marca”(Seleccionar una sola Marca)
		driver.findElement(inputFiltrar).sendKeys("Xbox One");
		driver.dynamicXpathConsola("Xbox One", driver).click();
	
		//4.- Ver el detalle de cualquier producto (hacer clic en el botón “VER PRODUCTO”) .
		driver.findElement(btnVerProducto);

		driver.click(btnPLus);

			 			
  		// 5.- Aumentar la cantidad hasta 3 (hacer clic en el botón “+” hasta llegar a 3) 

  		//No veo el button +
  		// 6.- Culminar la automatización (No hacer la compra)
   


		} catch (Exception e) {
			common.capturaPantalla();
			common.logger("TestFailFAL-001");
		} finally {
			driver.close();
			driver.quit();
		}

	}
}
