package pages;

import org.openqa.selenium.WebDriver;

import action.wrapper;


public class Login extends wrapper{
	
	public Login (WebDriver driver1)
	{
		this.driver=driver1;
		
	}
	public void clietid()
	{
		type("#logintype_clientid", "16265");
	}
	public void username()
	{
		type("#logintype_username", "maya");
	}
public void password()

{
	type("$logintype[password]", "demo123");
}
public void loginbutton()
{
	click("#successful-login");
}
}
