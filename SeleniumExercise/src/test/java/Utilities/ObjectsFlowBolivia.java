package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ObjectsFlowBolivia {

	public  String date() {
		Date todayDate	=	new Date();
		SimpleDateFormat date	=	new SimpleDateFormat("dd-MM-YYYY HH.mm.ss");
		String actualDate	=	date.format(todayDate);
		return actualDate;
	}
	 
	public  void screenshot(WebDriver driver) throws Exception{
		Screenshot screen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		String nameImg	=	"screenShot/"+"Img "+this.date()+".png";
    	ImageIO.write(screen.getImage(), "PNG", new File(nameImg));
	 
	} 
	
	public void report(String message) {	
		 try {
	            String rute	=	"report/log.txt";
	            File file	=	new File(rute);
	            if (!file.exists()) {
	                file.createNewFile();
	            }
	            FileWriter fw	=	new FileWriter(file,true);
	            BufferedWriter bw	=	new BufferedWriter(fw);
	            bw.write(message);
	            bw.newLine();
	            bw.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void moveScroll(WebElement element,WebDriver driver) {
		int positionY;
		positionY	=	element.getLocation().getY()-20;
		((JavascriptExecutor)driver).executeScript("scroll(0,".concat(String.valueOf(positionY)).concat(")"));
	}
}
