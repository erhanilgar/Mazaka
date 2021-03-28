package com.mazaka.pages;

import com.mazaka.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
 public LoginPage(){
  PageFactory.initElements(Driver.get(),this);
 }

   // @FindBy(xpath = "//img[@src='/images/logo-dark.png']")
   // public WebElement mazakaLogin;
    @FindBy(css = "#Email")
    public  WebElement email;
    @FindBy(css = "#Password")
    public  WebElement password;
    @FindBy(xpath = "//select[@id='culture']")
    public  WebElement selectLanguage;
    @FindBy(xpath = "//button[contains(text(),'Giriş')]")
    public  WebElement login;
    @FindBy(xpath = "(//span[text()='Dashboard'])[1]")
    public  WebElement dashboard;

    public String getLanguage(String language){
     Select dropdown= new Select(selectLanguage);
     dropdown.selectByVisibleText(language);
     String actualLanguage= dropdown.getFirstSelectedOption().getText();
     System.out.println("actualLanguage = " + actualLanguage);

     return actualLanguage;
    }
    public void getEnter(String enter){
     Driver.get().findElement(By.xpath("//button[contains(text(),'"+enter+"')]")).click();
    }
 public String passwordError(String text) {
  try {
   String errorMessage = Driver.get().findElement(By.xpath("//div[contains(text(),'" + text + "')]")).getText();
   return errorMessage;
  } catch (Exception e) {
   String currentUrl = Driver.get().getCurrentUrl();
   return currentUrl;
  }
 }
}
