/**
 * 
 */
package appuimTest_1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * @author shridharn
 *
 */
public class StartApplication {

		//create global variable
		private static AndroidDriver<AndroidElement> driver;
//		public static void main(String[] args) throws MalformedURLException, InterruptedException 
//		{

		@Test
		public static void runM()throws MalformedURLException, InterruptedException{

			// Create object of DesiredCapabilities class                             
			DesiredCapabilities capabilities = new DesiredCapabilities();

		    String apkpath = "D:\\installation DIR\\Appium_softReq\\Software4appium\\TEST_DATA\\selendroid-test-app-0.17.0.apk";
		    File app = new File (apkpath);

			capabilities.setCapability("clearSystemFiles", true);
			//Optional
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

			//Specify the device name (any name)
			capabilities.setCapability("deviceName", "Pixel_2_XL_API_28_Andriod-9_-max-mem");//Google Nexus 5X-8.0-API 26-1080x1920

			//Platform version
			capabilities.setCapability("platformVersion", "9.0");//8.0.0//9.0

			//platform name
			capabilities.setCapability("platformName", "Android");
			
			//specify the application package that we copied from appium                
			capabilities.setCapability("appPackage", "io.selendroid.testapp");

			//specify the application activity that we copied from appium                   
			capabilities.setCapability("appActivity", ".HomeScreenActivity");

//			capabilities.setVersion("1.4.16");
			capabilities.setCapability("appium-version", "1.12.1");//1.4.16
			capabilities.setCapability("app",app.getAbsolutePath());
			

			//Start android driver I used 4727 port by default it will be 4723
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//127.0.0.1:4723



			//Specify the implicit wait of 5 second
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



			//Enter the text in textbox
			driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");


			//click on registration button  
			driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();

			//Wait for 10 second
			Thread.sleep(10000);


			//close the application
			driver.quit();



		}





	
}
