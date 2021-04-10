package web.general;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.IndexPage;
import web.WEBINF.admin.AdminPanelPage;
import web.WEBINF.guest.LoginFormPage;
import web.WEBINF.menu.MenuPage;

import java.util.concurrent.TimeUnit;

public class AdminLoginTest {
    static private WebDriver driver;

    public AdminLoginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        String path = "C:\\Melnikov\\JPTVR19WebShop-master\\lib\\chromedriver.exe";
//        OperaOptions operaOptions = new OperaOptions();
//        operaOptions.setBinary("C:\\Users\\kirya\\AppData\\Local\\Programs\\Opera GX\\launcher.exe");
//        System.setProperty("webdriver.opera.driver", path);
//        driver = new OperaDriver(operaOptions);
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/JPTVR19WebShop_jakarta-1.0-SNAPSHOT/");
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lostOfControlTest() {
        System.out.print("LostOfControlTest: ");
        MenuPage menuPage = new MenuPage(driver);
        LoginFormPage loginFormPage = menuPage.getLoginFormPage();
        IndexPage indexPage = loginFormPage.loginValidUser("admin", "admin");
        if (!"Вы вошли как admin".equals(indexPage.getMessageInfo())) {
            Assert.fail("Ошибка входа!");
        }
        AdminPanelPage adminPanelPage = menuPage.getAdminFormPage();
        String message = adminPanelPage.validLostAccess();
        if (!"Изменить роль невозможно".equals(message)) {
            Assert.fail("Ошибка в тесте понижения роли админу!");
        }
        System.out.println("Пройден.");
        disableAccessToAdminProfile();
    }

    public void disableAccessToAdminProfile() {
        System.out.print("disableAccessToAdminProfileTest: ");
        MenuPage menuPage = new MenuPage(driver);
        menuPage.logout();
        LoginFormPage loginFormPage = menuPage.getLoginFormPage();
        loginFormPage.loginValidUser("admin", "admin");
        ListBuyersPage listBuyersPage = menuPage.getListBuyersPage();
        EditUserPage editUserPage = listBuyersPage.getEditUserPage("admin");
        IndexPage indexPage = editUserPage.changeUserProfile();
        String message = indexPage.getMessageInfo();
        Assert.assertEquals("Вы не имеете прав на изменение данных этого пользователя", message);
        System.out.println("Пройден.");
    }
}
