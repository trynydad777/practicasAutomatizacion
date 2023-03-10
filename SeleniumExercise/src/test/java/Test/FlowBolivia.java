package Test;



import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ObjectsFlowBolivia;




public class FlowBolivia {

	public static void main(String[] args) throws Exception {
	
		WebDriver driver	=	new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		ObjectsFlowBolivia utilities = new ObjectsFlowBolivia();

		
		String url			=	"https://flow.bo/";
		driver.get(url);
		driver.manage().window().maximize();
		WebElement sesion	=	driver.findElement(By.cssSelector(" li.link.authorization-link > a"));
		sesion.click();
		WebElement email	=	driver.findElement(By.name("login[username]"));
		email.clear();
		email.sendKeys("trini@trueforce.com");
		WebElement password	=	driver.findElement(By.name("login[password]"));
		password.clear();
		password.sendKeys("sistemas.01");
		WebElement buttonSesion	=	driver.findElement(By.name("send"));
		buttonSesion.click();
		WebElement moreProduct	=	driver.findElement(By.cssSelector(".block-images:nth-child(5) .button-2"));
		utilities.moveScroll(moreProduct, driver);
		moreProduct.click();
		WebElement selecProduct	=	driver.findElement(By.cssSelector(".product-image-container-17045 .product-image-photo"));
		utilities.moveScroll(selecProduct, driver);
		selecProduct.click();
		WebElement addCarrito	=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-addtocart-button >span")));
		if (addCarrito.isDisplayed())addCarrito.click();
		
		WebElement buyNow	=	driver.findElement(By.cssSelector("#buy-now >span"));
		buyNow.click();
		
		WebElement titleResumenPdido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'title')]"))); 
	        if (titleResumenPdido.isDisplayed()) {
	        	WebElement modoEnvio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'M??todos de env??o')]"))); 	   		 
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
	    		
	        } else {
	            System.out.println("titleResumenPdido no visible");
	        }
		
	   
		
	
	}

}
