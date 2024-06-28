package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CartPage;
import pom.LoginPage;
import pom.NaaptolHomePage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;
import pom.RegistrationDetailsPage;

@Listeners(test.Listeners.class)

public class RegistrationDetailsTest extends BaseTest {
	@BeforeTest
	public void openApplication() {
		driver = Browser.launchApplication();
	}
	
	 @AfterMethod
 	 public void closeNaaptol () {
	 driver.close();
	}
	 
	@Test
	public void verifyIfUserAbletoEnterShippingAddress() throws InterruptedException {
	    searchProduct("cooker");
	    productResultPage = new ProductResultPage(driver);
	    productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailsPage(driver);
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
        cartPage.DeliveryproceedtoCheckout();
		switchToChildBrowser();
		loginPage=new LoginPage(driver);
	    loginPage.EnterMobileNumber("8871475299");
		loginPage.ClickonContinue();
		Thread.sleep(4000);
        loginPage.ClickonSubmit();
        switchToChildBrowser();
		regDetails = new RegistrationDetailsPage(driver);
		regDetails.selectTitle();
		regDetails.EnterFirstName("Akshay");
		regDetails.EnterLastname("Mahajan");
		Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
		actions.sendKeys("Housing Board Colony Pithampur");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("Jain Mandir");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("454775");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        regDetails.EnterMobileNumber("8871475299");
        Thread.sleep(4000);
        Thread.sleep(4000);
		regDetails.ClickonSaveandProceed();
        regDetails.ShipToThisAddress();		
	   }
	 
        
        
        @Test
        public void verifyIfUserisableToPlaceOrder() throws InterruptedException {
    	    searchProduct("cooker");
    	    productResultPage = new ProductResultPage(driver);
    	    productResultPage.selectDesiredProduct(0);
    		switchToChildBrowser();
    		productDetailPage = new ProductDetailsPage(driver);
    		productDetailPage.clickOnBuyButton();
    		cartPage = new CartPage(driver);
            cartPage.DeliveryproceedtoCheckout();
    		switchToChildBrowser();
    		loginPage=new LoginPage(driver);
    	    loginPage.EnterMobileNumber("8871475299");
    		loginPage.ClickonContinue();
    		Thread.sleep(30000);
            loginPage.ClickonSubmit();
            switchToChildBrowser();
    		regDetails = new RegistrationDetailsPage(driver);
    		regDetails.selectTitle();
    		regDetails.EnterFirstName("Akshay");
    		regDetails.EnterLastname("Mahajan");
    		Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB);
    		actions.sendKeys("Housing Board Colony");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys("Jain Mandir");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys("454775");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
            regDetails.EnterMobileNumber("8871475299");
            Thread.sleep(4000);
            Thread.sleep(4000);
    		regDetails.ClickonSaveandProceed();
            regDetails.ShipToThisAddress();		
		    Thread.sleep(4000);
	        regDetails.selectpaymentOptions(0);	
	        Thread.sleep(4000);
	        Assert.assertTrue(regDetails.isPaymentOptionDisplayed());
	       }
	
	 
     
}
