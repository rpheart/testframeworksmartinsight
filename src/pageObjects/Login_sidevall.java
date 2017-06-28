package pageObjects;

import org.openqa.selenium.By;

public class Login_sidevall extends Base {
	

	By username = By.id("IDToken1");
	By password = By.id("IDToken2");
	By loginButton = By.id("loginButton");
	
	public void username(){
		type(username, "sidevall");	
	}
	
	public void password(){
		type(password, "HeadCheese!1");
	}
	
	public void clickLogin(){
		click(loginButton);
	}
	
	public void loginSidevall() {
		username();
		password();
		clickLogin();
	}
	
}
