package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;

public class Logins extends Base{

    By username = By.id("IDToken1");
    By password = By.id("IDToken2");
    By loginButton = By.id("loginButton");
    By sfLogo = By.className("sf_logo");

    public void usernameSidevall(){
        type(username, "sidevall");
    }

    public void passwordSidevall(){
        type(password, "HeadCheese!5");
    }

    public void usernameSitest01_all(){
        type(username, "sitest01_all");
    }

    public void passwordSitest01_all(){
        type(password, "HeadCheese!8");
    }

    public void usernameBellevue_qa(){
        type(username, "sidevall");
    }

    public void passwordBellevue_qa(){
        type(password, "HeadCheese!5");
    }


    public void clickLogin(){
        click(loginButton);
    }

    public void loginSidevall() {
        usernameSidevall();
        passwordSidevall();
        clickLogin();
    }

    public void loginSitest01_all() {
        usernameSitest01_all();
        passwordSitest01_all();
        clickLogin();
    }

    public void loginBellevue_qa() {
        usernameBellevue_qa();
        passwordBellevue_qa();
        clickLogin();
    }


    //ASSERTIONS ASSERTIONS ASSERTIONS

    public Boolean loginSuccess() {
        return isDisplayedBy(sfLogo, 15);
    }




}
