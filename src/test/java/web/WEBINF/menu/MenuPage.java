package web.WEBINF.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.WEBINF.admin.AdminPanelPage;
import web.WEBINF.guest.LoginFormPage;
import web.general.ListBuyersPage;

public class MenuPage {
    protected WebDriver driver;
    private final By loginFormBy = By.id("loginForm");
    private final By adminFormBy = By.id("adminForm");
    private final By listBuyersBy = By.id("listBuyers");
    private final By logoutBy = By.id("logout");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFormPage getLoginFormPage() {
        driver.findElement(loginFormBy).click();
        return new LoginFormPage(driver);
    }

    public AdminPanelPage getAdminFormPage() {
        driver.findElement(adminFormBy).click();
        return new AdminPanelPage(driver);
    }

    public ListBuyersPage getListBuyersPage() {
        driver.findElement(listBuyersBy).click();
        return new ListBuyersPage(driver);
    }

    public void logout() {
        driver.findElement(logoutBy).click();
    }
}