package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        driver.findElement(MyStorePage.iniciarSesion).click();
        WebElement userInputElement = driver.findElement(MyStorePage.email);
        userInputElement.sendKeys(user);
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(MyStorePage.password).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(MyStorePage.loginButton).click();
    }

}
