package test;

import java.util.Iterator;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.NaaptolHomePage;
import pom.ProductResultPage;

@Listeners(test.Listeners.class)

public class ViewProductDetailsTest extends BaseTest {
	@BeforeMethod
	public void openApplication() {
	driver =Browser.launchApplication();
	}
	
	@AfterMethod
	  public void closeNaaptol () {
	 driver.close();
    }
	
	@Test
	public void verifyIfUserIsViewProductDetailsFromQuickView() {
	    NaaptolHomePage naptolHomePage = new NaaptolHomePage(driver);
	    naptolHomePage.enterProductToSearch("cooker");
	    naptolHomePage.clickOnSearch();
	    ProductResultPage productResultPage = new ProductResultPage(driver);
	    String productName = productResultPage.getProductTitle(1);
	    String productPrice = productResultPage.getProductPrice(1);
	    productResultPage.moveToDesiredProduct(driver, 1);
	    productResultPage.clickOnQuickView(1);
	    Assert.assertEquals(productResultPage.getProductNameOnQuickView(),productName );
	    Assert.assertEquals(productResultPage.getProductPriceOnQuickView(), productPrice);
	   }
	
	@Test
    public void verifyIfUserIsViewProductDetailsbydirectclick() throws InterruptedException {
		
         NaaptolHomePage naptolHomePage = new NaaptolHomePage(driver);
         naptolHomePage.enterProductToSearch("cooker");
         naptolHomePage.clickOnSearch();
         ProductResultPage productResultPage = new ProductResultPage(driver);
         String productName = productResultPage.getProductTitle(1);
         String productPrice = productResultPage.getProductPrice(1);
         productResultPage.moveToDesiredProduct(driver, 1);
         productResultPage.selectDesiredProduct(1);
         switchToChildBrowser();
         Thread.sleep(4000);
         String name=productResultPage.getProductNamebyClick();
         Double price = productResultPage.getProductpricebyClick();         
         Assert.assertEquals(productResultPage.getProductNamebyClick(), productName);
         Assert.assertEquals(productResultPage.getProductpricebyClick(), productPrice);
        }
	
	     @AfterTest
	     public void publishReport() {
		 reports.flush();
	    }
 }
