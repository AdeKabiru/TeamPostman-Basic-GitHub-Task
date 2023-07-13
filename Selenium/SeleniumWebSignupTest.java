//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

//import javax.annotation.Priority;


public class SeleniumWebSignupTest {
    //Import the Selenium WebDriver
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the ChromeDriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open the Chrome browser
        driver = new ChromeDriver();
        Thread.sleep(1000);
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //wait globally for full loading
        //TC1 Verify the user input the right url and he's on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(1000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //4. Click on Signup button to open the Signup page
        // Open the link, right click on the page and select inspect
        // Navigate to the location of your link
        // Right click and select copy, then copy by xPath
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 0)
    public void signUpPage() throws InterruptedException {
        //TC2 Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
                if (actualUrl.contains(expectedUrl))
                    //Pass
                    System.out.println("Correct Webpage");
                else
                    //Fail
                    System.out.println("Wrong Webpage");
        Thread.sleep(1000);

    }

    @Test (priority = 1)
    public void emptySignup() throws InterruptedException {
        //TC3 Verify that user cannot signup with either/all of the fields blank
        driver.findElement(By.id("submit")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Empty field(s)");
        else
            //Fail
            System.out.println("Account created with empty field");
        Thread.sleep(10000);

    }

    @Test (priority = 2)
    public void invalidUsernameSignup() throws InterruptedException {
        //TC4 Verify that user cannot signup with username less than 3 characters valid email and password
        //5. Input your invalid username, valid email and valid password in the fields
        driver.findElement(By.id("user_username")).sendKeys("kb");
        driver.findElement(By.id("user_email")).sendKeys("kabiru20@mailnator.com");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Invalid Username");
        else
            //Fail
            System.out.println("User signed up with invalid username");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
    }

    @Test (priority = 3)
    public void invalidemailSignup() throws InterruptedException {
        //TC5 Verify that user cannot signup with invalid email and valid username and password
        //5. Input your invalid email, valid username and valid password in the fields
        driver.findElement(By.id("user_username")).sendKeys("kaybest");
        driver.findElement(By.id("user_email")).sendKeys("kabiru20@mailnator");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Invalid email");
        else
            //Fail
            System.out.println("User signed up with invalid email");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();

    }

    @Test (priority = 4)
    public void invalidpasswordSignup() throws InterruptedException {
        //TC6 Verify that user cannot signup with invalid password and valid username and email
        //5. Input your invalid password, valid username and valid email in the fields
        driver.findElement(By.id("user_username")).sendKeys("kaybest1");
        driver.findElement(By.id("user_email")).sendKeys("kaybest1@mailnator.com");
        driver.findElement(By.id("user_password")).sendKeys("p");
        driver.findElement(By.id("submit")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
           //Pass
           System.out.println("Invalid Password");
        else
           //Fail
           System.out.println("User signed up with invalid password");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();

    }

    @Test (priority = 5)
    public void positiveSignup() throws InterruptedException {
        //TC7 Verify that user can successfully signup with valid details
        //5. Input your username in the username field
        driver.findElement(By.name("user[username]")).sendKeys("kabiru150");
        //6. Input your email in the email field
        driver.findElement(By.id("user_email")).sendKeys("kabiru150@mailnator.com");
        //7. Input your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("password");
        //8. Click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users"))
        //if (driver.findElement(By.xpath("/html/body/div[1]/div/div")))
            //Pass
            System.out.println("Successful signup with valid details");
        else
            //Fail
            System.out.println("Invalid details");
    }
    @Test (priority = 6)
    public void clickUser1Item() throws InterruptedException {
        //TC8 Verify that meaghan item is present on the item list page
        //9. Click on meaghan item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users/1"))
            //Pass
            System.out.println("Meaghan item is present");
        else
            //Fail
            System.out.println("Meaghan item is absent");
        Thread.sleep(1000);
    }
    @Test (priority = 7)
    public void verifyItem() throws InterruptedException {
        //TC9 Verify that User Python with Selenium item is present in the meaghan item
        //10. Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/articles/4"))
            //Pass
            System.out.println("Using Python with Selenium is present");
        else
            //Fail
            System.out.println("Using Python with Selenium is absent");
        //TC10 Verify that when you logout, you are directed to the home page
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("We are back to Homepage");
        else
            //Fail
            System.out.println("This is not Homepage");
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser(){
        //12. Quit the browser
        driver.quit();
    }

}
