package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	//define repository
	@FindBy(xpath="//input[@id='username']")
	WebElement objUser;
	@FindBy(name="password")
	WebElement objPass;
	@FindBy(id="btnsubmit")
	WebElement objlogin;
	@FindBy(xpath="//button[@id='btnreset']")
	WebElement objreset;
	//write method for login
	public void adminLogin(String username,String password)
	{
		objreset.click();
		objUser.sendKeys(username);
		objPass.sendKeys(password);
		objlogin.click();
	}

}
