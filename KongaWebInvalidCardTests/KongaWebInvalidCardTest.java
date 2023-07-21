import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class KongaWebInvalidCardTest {
    //Import the Selenium WebDriver
    private WebDriver driver;    

    @BeforeTest
    public void start() throws InterruptedException {
        //1. locate where the ChromeDriver is
        System.setProperty("webdriver.chrome.driver", "resourcesKonga/chromedriver.exe");
        //2. Open the Chrome browser
        driver = new ChromeDriver();
        Thread.sleep(2000);
        //3. Input Konga URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //TC1 Verify the user input the right URL and he/she is on the right page
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(1000);
        //4. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test (priority = 0)
    public void loginPage() throws InterruptedException {
        //5. User about to login by clicking on login button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(1000);
        //6. Input email address in the field provided
        driver.findElement(By.id("username")).sendKeys("kabirojo@gmail.com");
        //7. Input password in the field provided
        driver.findElement(By.id("password")).sendKeys("****************");
        //8. Click on login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 1)
    public void computersAndAccessories() throws InterruptedException {
        //9. User select Computers and Accessories category
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //10. Select Laptops subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        //driver.findElement(By.xpath("/div/a[6]")).click();
        Thread.sleep(2000);
        //11. Select Apple Macbooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(2000);
        //12. Add an Item to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[17]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
        //13. Click on My Cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(2000);
        //14. Click Checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void deliveryAddress() throws InterruptedException {
        //11 Add delivery address
        /*driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(2000);
        //12 Fill in address form
        driver.findElement(By.id("firstname")).sendKeys("Kabiru");
        driver.findElement(By.id("lastname")).sendKeys("Ojo");
        driver.findElement(By.id("telephone")).sendKeys("08101121575");
        driver.findElement(By.id("street")).sendKeys("5 Taiye Atobatele Street, Ige Estate");
        driver.findElement(By.id("city")).sendKeys("Ipaja");
        driver.findElement(By.name("regionId")).click();
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[6]/div/div/select/option[26]")).click();
        driver.findElement(By.name("areaId")).click();
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[7]/div/div/select/option[4]")).click();
        driver.findElement(By.name("saveDeliveryAddress")).click();
        // Select the saved address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        // Select Use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        */
        //15. Select payment option Pay Now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(2000);
        //16. Select Continue to payment
        driver.findElement(By.name("placeOrder")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void selectPayment() throws InterruptedException {
        //17. Switch to iframe
        By locIframe = By.xpath("//*[@id=\"kpg-frame-component\"]");
        driver.switchTo().frame(driver.findElement(locIframe));
        Thread.sleep(1000);
        //18. Select Payment method (By Card)
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div[1]/div[2]/div/div[2]/button")).click();
        Thread.sleep(2500);
        //19. Input invalid card details
        driver.findElement(By.id("card-number")).sendKeys("5456543223451234");
        driver.findElement(By.id("expiry")).sendKeys("0126");
        driver.findElement(By.id("cvv")).sendKeys("103");
        Thread.sleep(2000);
        driver.findElement(By.id("card-pin-new")).click();
        //20. Select pin
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[7]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[7]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[7]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[7]")).click();
        Thread.sleep(2000);
        //21. Select pay now
        driver.findElement(By.id("validateCardForm")).click();
        if (driver.findElement(By.id("card-number_unhappy")).isDisplayed())
            //Pass
            System.out.println("Invalid Card Details");
        else
            //Fail
            System.out.println("Could not recorgnize an invalid Card details");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        //22. Close iframe
        WebElement ClosePopUp = driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside"));
        ClosePopUp.click();
        //23. Switch out of iframe
        driver.switchTo().defaultContent();
        System.out.println("Close pop-up");
        Thread.sleep(1000);
        //24. Quit the browser
        driver.close();
    }

}

