package Appium_ecommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class toast_message extends Base_class{
	@Test
	public void toastmsg() {
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//default tag namefor toast message --> android.widget.Toast  and by default Attribute will be --->name
		
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	    Assert.assertEquals(toastMessage, "Please enter your name");
	}

}
