package web.WEBINF.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.IndexPage;

public class LoginFormPage {
    protected WebDriver driver;
    private final By loginBy = By.id("login");
    private final By passwordBy = By.id("password");
    private final By loginButtonBy = By.xpath("//input[@type='submit']");

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public IndexPage loginValidUser(String login, String password) {
        driver.findElement(loginBy).sendKeys(login);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
        return new IndexPage(driver);
    }

}