package Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.ObjectsFlowBolivia;

public class FlowBoliviaTestng {

	WebDriver  driver	=	new ChromeDriver();
	ObjectsFlowBolivia utilities = new ObjectsFlowBolivia();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	
	@Test
	public void inciarWebSite() {
		String url			=	"https://flow.bo/";
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@Test(alwaysRun = true)
	public void autentication(){						
		WebElement sesion	=	driver.findElement(By.xpath("//div[@class='header content']//ul[@class='header links']//li[@class='link authorization-link']//a[contains(text(),'Iniciar sesión')]")); 
		sesion.click();
		WebElement email	=	driver.findElement(By.name("login[username]"));
		email.clear();
		email.sendKeys("trini@trueforce.com");
		WebElement password	=	driver.findElement(By.name("login[password]"));
		password.clear();
		password.sendKeys("sistemas.01");
		WebElement buttonSesion	=	driver.findElement(By.name("send"));
		buttonSesion.click();
	}
	
	@Test
	public void seleccionarProducto() {
		WebElement moreProduct	=	driver.findElement(By.cssSelector(".block-images:nth-child(5) .button-2"));
		utilities.moveScroll(moreProduct, driver);
		moreProduct.click();
		WebElement selecProduct	=	driver.findElement(By.cssSelector(".product-image-container-17045 .product-image-photo"));
		utilities.moveScroll(selecProduct, driver);
		selecProduct.click();
	}
	
	@Test
	public void addCarrito() {
		WebElement addCarrito	=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-addtocart-button >span")));
		if (addCarrito.isDisplayed())addCarrito.click();
	}
	
	@Test
	public void buyProduct() {
		WebElement buyNow	=	driver.findElement(By.cssSelector("#buy-now >span"));
		buyNow.click();
	}
	
	@Test
	public void visibleTitleResum() {
		WebElement titleResumenPdido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'title')]"))); 
	}
	
	@Test
	public void modoEnvio() throws Exception {
		WebElement modoEnvio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Métodos de envío')]"))); 	   		 
		utilities.moveScroll(modoEnvio, driver);
		
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-bind,'text: method.error_message')]")));
        if (error.isDisplayed()) {
        	utilities.screenshot(driver); 
   		    utilities.report("============================================");
        	utilities.report("Fecha: " + utilities.date());
        	utilities.report("Salida:  El apartado METODOS DE ENVIO presenta un mensaje de error.");
        } else {
        	utilities.screenshot(driver); 
        	utilities.report("============================================");
        	utilities.report("Fecha: " + utilities.date());
        	utilities.report("Salida:  El apartado METODOS DE ENVIO no presenta un mensaje de error.");
        }
	}

}
