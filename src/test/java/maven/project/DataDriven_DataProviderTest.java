package maven.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven_DataProviderTest {

	/* step1: Launch the browser and open the app orangehrms
	 * step2: Test the orange hrms login panel with multiples of test data values
	 * step3: Reading the test data from a method  -- @DataProvider annotation -- Testng
	 * 
	 */
	
	    static WebDriver driver;
	    
	    @Test(dataProvider="testdata")
	    public static void Orangehrmslogin(String username,String password) throws InterruptedException {
	    	
	    	 System.setProperty("webdriver.gecko.driver","geckodriver.exe");
	    	 driver=new FirefoxDriver();
	    	 driver.get("https://opensource-demo.orangehrmlive.com/");
	    	 driver.manage().window().maximize();
	    	 driver.findElement(By.id("txtUsername")).sendKeys(username);
	    	 driver.findElement(By.name("txtPassword")).sendKeys(password);
	    	 driver.findElement(By.id("btnLogin")).click();
	    	 
	    	      if(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
	    	    	  
	    	    	  Reporter.log("orange hrms login successfully into home page",true);
	    	    	  
	    	    	  Thread.sleep(3000);
	    	    	  
	    	    	  driver.findElement(By.id("welcome")).click();
	    	    	  
	    	    	  Thread.sleep(3000);
	    	    	  
	    	    	  driver.findElement(By.xpath("//a[contains(@href,'/index.php/auth/logout')]")).click();
	    	    	  
	    	      }
	    	 
	    	      else {
	    	    	  
	    	    	  Reporter.log("unable to login successfully into ornage hrms home page",true);
	    	      }
	    }

	    
	    
	      @DataProvider(name="testdata")
	      public String[][]  getdata() {
	    
	    	   String[][] data=new String[3][2]; // 3 no of rows, 2 no of colums, username & password
	    	   
	    	     data[0][0]="Admin";
	    	     data[0][1]="admin123";
	    	     
	    	     data[1][0]="Admin123";
	    	     data[1][1]="admin123";
	    	     
	    	     data[2][0]="Admin";
	    	     data[2][1]="admin123";
				
	    	     return data;
	    
	    	     
	    	     
	    	     
	      }
}
