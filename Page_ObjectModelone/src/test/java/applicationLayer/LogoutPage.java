package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	@FindBy(xpath="(//a[starts-with(text(),' Logout')])[2]")
	WebElement objlogout;
	public void adminLogout()
	{
		objlogout.click();
	}

}
