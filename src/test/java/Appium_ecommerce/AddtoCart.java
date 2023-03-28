package Appium_ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AddtoCart extends Base_class{
@Test
public void Add_to_cart() {
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("xyz");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		//scroll to Mexico
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mexico\"));")).click();     
     
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Algeria\"));")).click();  
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		//scroll to element
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));")); 
        
		
        int productCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
        
        for(int i=0;i<productCount;i++)
        {
        	String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        	
        	if(productName.equalsIgnoreCase("Jordan Lift Off"))
        	{
        		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        	}
        }
   
      driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
     
      //explicit wait until the expected page opens
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
      
      //assertion to check the item is successfully added to cart
      String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
      Assert.assertEquals(lastPageProduct, "Jordan Lift Off");
      
      
      
      
      
      
      

      }
  }

