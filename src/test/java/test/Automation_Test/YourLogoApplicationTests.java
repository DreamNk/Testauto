package test.Automation_Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.Automation_Page.DriverContext;
import test.Automation_Page.YourLogoApplicationPage;

public class YourLogoApplicationTests extends AbstractTest {
	
	
	public String email_id = "nandakishor.ban18@gmail.com";
	public String password = "Gltd123@1";
	
	
	@Test(description = "Verify newly created user can login", dataProvider = "getData")
	public void VerifyLogin(String username, String psw) throws InterruptedException {
		try {
			PageFactory.initElements(DriverContext.Driver, YourLogoApplicationPage.class)
			.clickSignIn_Button()		
			.enterLoginId(username)
			.enterLoginPassword(psw)
			.clickSignIn()
			.waitFor(5);
		}

		catch (Exception e) 
		{
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	 @DataProvider (name="getData")
	 public Object[][] getExcelDataForInvalidUsername() {
		 
		 ReadExcelData config = new ReadExcelData("/Users/nandakishor.ban/git/repository/Testauto/TestData/LoginUsers.xlsx");
		 int row = config.getrowCount(0);
		  Object[][] data = new Object[row][2];		  
		 for (int i=0;i<row;i++)
		 {
			  data[i][0]=config.getData(0, i, 0);
			  data[i][1]=config.getData(0, i, 1);
			 
		 }
		  return data;
	}
	

	@Test(priority = 1,description = "Verify newly created user can login",enabled = false)
	public void VerifyNewlyCreatedUserCanLogin() throws InterruptedException {
		try {
			PageFactory.initElements(DriverContext.Driver, YourLogoApplicationPage.class)
			.clickSignIn_Button()		
			.enterEmailAddress(email_id)
		    .clickCreateAccountButton()
		    .waitFor(2)
		    .selectmrcheckbox()
			.enterFirstName("Nandkishor")
			.enterLastName ("Ban")
			.enterPassword(password)
			.enterAddress("DES MONA")
			.enterCity("New York")
			.selectState("New York")
			.enterZipCode("44460")
			.enterMobileNumber("8446891571")
			.enterAliasAddress("Aias Address")
	        .click_Register_Button()
	        .doSignout()
			.enterLoginId(email_id)
			.enterLoginPassword(password)
			.clickSignIn()
			.verifyLoggedInUser("Nandkishor Ban")
			.selectmrcheckbox()
			.waitFor(2); // Assert verification			
															
		}

		catch (Exception e) 
		{
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 2,description = "Verify searched products sre showing proper results",enabled = false)
	public void VerifyTheSearchResults() throws InterruptedException {
		try {
			PageFactory.initElements(DriverContext.Driver, YourLogoApplicationPage.class)
			.searchProduct("Dress")
			.clickSearch_Button()
			.verifySearchedResult(7); // Assert Verification

		} catch (Exception e) {
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 3,description = "Add product to cart and checkout",enabled = false)
	public void addProductToCartAndVerify() throws InterruptedException {
		try {
			PageFactory.initElements(DriverContext.Driver, YourLogoApplicationPage.class)
			.addFirstProductToCart()
			.proceedToCheckout()
			.proceedToCheckoutSummeryPage()
			.proceedToCheckoutAddressPage()
			.checkTermsAndCondionCheckbox()
			.proceedToCheckoutOnShippingPage()
			.clickBankWirePayment()
			.clickConfirmOrder()
			.orderConfirmationMessage("Your order on My Store is complete."); // Assert verifiction																					

		} catch (Exception e) {
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 4,description = "Download invoice and verify",enabled = false)
	public void downloadInvoiceAndVerify() throws InterruptedException {
		try {
			PageFactory.initElements(DriverContext.Driver, YourLogoApplicationPage.class)
			.clickBackToOrders()
			.downloadPDF_Invoice()
			.verifyDownload("pdf"); // Assert Verification

		} catch (Exception e) {
			Assert.assertTrue(false, e.getMessage());
		}

	}
}
