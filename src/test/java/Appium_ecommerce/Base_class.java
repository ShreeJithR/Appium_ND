package Appium_ecommerce;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Base_class {
	  public AndroidDriver driver;
		
		@BeforeClass
		public void ConfugureAppium() throws MalformedURLException, InterruptedException
		{
			//AndroidDriver
			//Appium code --> Appium Server -->Mobile
			UiAutomator2Options options=new UiAutomator2Options();
			options.setDeviceName("Puu");
			options.setApp("//home//navadhiti//eclipse-workspace//Appium_e-commerce//resources//General-Store.apk");	
			
			driver=new AndroidDriver(new URL("http://127.0.0.0:4723"), options);
			
			Thread.sleep(5000);
		}
			
			
			@AfterClass
			public void TearDown() throws InterruptedException
			{
				Thread.sleep(5000);
				driver.quit();
			}

		}
