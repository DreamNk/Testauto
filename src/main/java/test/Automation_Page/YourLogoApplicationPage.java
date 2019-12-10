package test.Automation_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.File;

public class YourLogoApplicationPage extends AbstractPage<YourLogoApplicationPage> {

	public YourLogoApplicationPage(WebDriver driver) {
		super(driver);
	}

	private By sign_in = By.xpath("//*[contains(text(),'Sign in')]");
	private By emailaddress = By.xpath("//input[@id='email_create']");
	private By create_an_account = By.cssSelector("#SubmitCreate > span > i");
	private By mr_checkbox = By.cssSelector("#uniform-id_gender1");
	private By firstname = By.cssSelector("#customer_firstname");
	private By lastname = By.cssSelector("#customer_lastname");
	private By password = By.cssSelector("#passwd");
	private By address = By.cssSelector("#address1");
	private By city = By.cssSelector("#city");
	private By state = By.cssSelector("#id_state");
	private By zipcode = By.cssSelector("#postcode");
	private By mobilePhone = By.cssSelector("#phone_mobile");
	private By alias_address = By.cssSelector("#alias");
	private By register = By.xpath("//*[contains(text(),'Register')]");
	private By my_username = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span");
	private By signout_Button = By.xpath("//*[contains(text(),'Sign out')]");
	private By loginId = By.cssSelector("#email");
	private By loginPsw = By.cssSelector("#passwd");
	private By signIn = By.cssSelector("#SubmitLogin > span > i");
	private By searchBox = By.cssSelector("#search_query_top");
	private By searchBoxSearch = By.cssSelector("#searchbox > button");
	private By eyeOpenIcon = By.cssSelector(".icon-eye-open");
	private By getResultCountOnUi = By.cssSelector("#center_column > h1 > span.heading-counter");
	private By first_product = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img");
	private By add_to_cart_button = By.xpath("//*[contains(text(),'Add to cart')][1]");
	private By proceed_to_checkout_button = By.xpath("//*[contains(text(),'Proceed to checkout')]//parent :: a");
	private By proceed_to_checkout_button_on_summery_page = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
	private By proceed_to_checkout_button_on_address_page = By.cssSelector("#center_column > form > p > button");
	private By termsandcondition_checkbox = By.cssSelector("#cgv");
	private By proceed_to_checkout_button_on_shipping_page = By.cssSelector("#form > p > button");
	private By bank_wire_payment = By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
	private By confirm_order = By.cssSelector("#cart_navigation > button");
	private By order_confirmation = By.xpath("//*[contains(text(),'Your order on My Store is complete.')]");
	private By back_to_orders = By.xpath("//*[contains(text(),'Back to orders')]");
	private By PDF_download = By.xpath("//*[@class='icon-file-text large']");
	
	
	private static String downloadPath = "C:\\Users\\nandakishor.ban\\Downloads";
	
	
	
	public YourLogoApplicationPage clickSignIn_Button() throws InterruptedException {	
		click(sign_in);
		return this;
	}

	public YourLogoApplicationPage enterEmailAddress(String email_address)  {
		try {
			click(emailaddress);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		enter(emailaddress, email_address);
		return this;
	}
	
	public YourLogoApplicationPage clickCreateAccountButton() throws InterruptedException {
		Thread.sleep(3000);
		doubleclick(create_an_account);
		
		return this;
	}
	
	public YourLogoApplicationPage selectmrcheckbox() throws InterruptedException {
		Thread.sleep(3000);
		click(mr_checkbox);
		return this;
	}
	
	public YourLogoApplicationPage enterFirstName(String name)  {
			try {
				click(firstname);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			enter(firstname, name);
			return this;
	}
	public YourLogoApplicationPage enterLastName(String Lastname)  {
		try {
			click(lastname);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enter(lastname, Lastname);
		return this;
}
	
	public YourLogoApplicationPage enterPassword(String Password)  {
		try {
			click(password);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enter(password, Password);
		return this;
}
	public YourLogoApplicationPage enterCity(String City)  {
		try {
			click(city);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enter(city, City);
		return this;
}
	public YourLogoApplicationPage enterAddress(String Address)  {
		try {
			click(password);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enter(address, Address);
		return this;
}
	
	public YourLogoApplicationPage selectState(String State)  {
		selectDropdownOption(state,State);
	
	return this;
}
	public YourLogoApplicationPage enterZipCode(String Zipcode)  {
		try {
			click(zipcode);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enter(zipcode, Zipcode);
		return this;
}
	public YourLogoApplicationPage enterMobileNumber(String Mobilenumber)  {
		try {
			click(mobilePhone);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enter(mobilePhone, Mobilenumber);
		return this;
}
	public YourLogoApplicationPage enterAliasAddress(String Aliasaddress)  {
		try {
			click(alias_address);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enter(alias_address, Aliasaddress);
		return this;
}
	public YourLogoApplicationPage click_Register_Button() throws InterruptedException  {	
		click(register);
		return this;
	}
	
	public YourLogoApplicationPage verifyLoggedInUser(String name) throws InterruptedException  {
		
		 Assert.assertEquals(getText(my_username),name);
		return this;
	}
	public YourLogoApplicationPage doSignout() throws InterruptedException  {	
		click(signout_Button);
		return this;
	}
	
	public YourLogoApplicationPage enterLoginId(String LoginId)  {
		try {
			click(loginId);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		enter(loginId, LoginId);
		return this;
	}
	
	public YourLogoApplicationPage enterLoginPassword(String LoginPsw)  {
		try {
			click(loginPsw);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		enter(loginPsw, LoginPsw);
		return this;
	}
	
	public YourLogoApplicationPage clickSignIn() throws InterruptedException {
		Thread.sleep(3000);
		doubleclick(signIn);
		
		return this;
	}
	
	public YourLogoApplicationPage searchProduct(String product)  {
		try {
			click(searchBox);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		enter(searchBox, product);
		return this;
	}
	
	public YourLogoApplicationPage clickSearch_Button() throws InterruptedException {	
		click(searchBoxSearch);
		return this;
	}
	
	public YourLogoApplicationPage verifySearchedResult(int count) throws InterruptedException {
		 Assert.assertEquals(count,elementCount(eyeOpenIcon));
		return this;
		
	}
	
	public YourLogoApplicationPage addFirstProductToCart() throws InterruptedException {
		hover(first_product);
		click (add_to_cart_button);
		return this;
		
	}
	
	public YourLogoApplicationPage proceedToCheckout() throws InterruptedException {
		Thread.sleep(3000);
		doubleclick (proceed_to_checkout_button);
		return this;
		
	}
	public YourLogoApplicationPage proceedToCheckoutSummeryPage() throws InterruptedException {
		Thread.sleep(3000);
		doubleclick (proceed_to_checkout_button_on_summery_page);
		return this;
		
	}
	
	public YourLogoApplicationPage proceedToCheckoutAddressPage() throws InterruptedException {
		Thread.sleep(3000);
		doubleclick (proceed_to_checkout_button_on_address_page);
		return this;
		
	}
	
	public YourLogoApplicationPage checkTermsAndCondionCheckbox() throws InterruptedException {
		
		click (termsandcondition_checkbox);
		return this;
		
	}
	
	public YourLogoApplicationPage proceedToCheckoutOnShippingPage() throws InterruptedException {
		Thread.sleep(5000);
		doubleclick (proceed_to_checkout_button_on_shipping_page);
		return this;
		
	}
	
   public YourLogoApplicationPage clickBankWirePayment() throws InterruptedException {
		
		click (bank_wire_payment);
		return this;
		
	}
   
 public YourLogoApplicationPage clickConfirmOrder() throws InterruptedException {
		
		click (confirm_order);
		return this;
		
	}
 
 public YourLogoApplicationPage orderConfirmationMessage(String message) throws InterruptedException {
	 
		 Assert.assertEquals(getText(order_confirmation),message);
		 return this;
		
	}
 
 public YourLogoApplicationPage clickBackToOrders() throws InterruptedException {
		
		click (back_to_orders);
		return this;
		
	}
 
 public YourLogoApplicationPage downloadPDF_Invoice() throws InterruptedException {
		
		click (PDF_download);
		return this;
		
	}
 
 public YourLogoApplicationPage verifyDownload(String extension)throws InterruptedException {

 Assert.assertTrue(isFileDownloaded_Ext(downloadPath, extension), "Failed to download document which has extension .pdf");
 return this;
	
 }
 private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    
	    String Filename =getLatestFilefromDir(dirPath).getName();
	    if (Filename.contains(ext))
	    {
	    	flag=true;
	    }
	    return flag;
	}
 
 private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
 
	


}
