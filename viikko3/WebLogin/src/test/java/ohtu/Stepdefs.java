package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }      
    
    @Given("user with username \"lea\" with password \"salainen1\" is successfully created")
    public void userSuccesfullyCreated() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        
        createUser("lea", "salainen1", "salainen1");
    }

    @Given("user with username \"aa\" and password \"bad\" is tried to be created")
    public void userUnsuccesfullyCreated() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        
        createUser("aa", "bad", "bad");
    }    
    
    @When("newly created username {string} and password {string} are entered")
    public void newUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }  
    
    @When("unsuccesfully created username {string} and password {string} are entered")
    public void badUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    } 
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndPasswordAreGiven(String username, String password) {
        createUser(username, password, password);
    }  
    
    @When("a short username {string} and valid password {string} and matching password confirmation are entered")
    public void shortUsernameAndValidPasswordAreGiven(String username, String password) {
        createUser(username, password, password);
    } 
    
    @When("a valid username {string} and short password {string} and matching password confirmation are entered")
    public void validUsernameAndShortPasswordAreGiven(String username, String password) {
        createUser(username, password, password);
    } 

    @When("a valid username {string} and valid password {string} and non-matching password {string} are entered")
    public void wrongConfirmationGiven(String username, String password, String wrong) {
        createUser(username, password, wrong);
    } 
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @Then("a new user is created")
    public void userIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @Then("user is not created and error \"username should have at least 3 characters\" is reported")
    public void userIsNotCreatedShortUsername() {
        pageHasContent("username should have at least 3 characters");
    }    
    
    @Then("user is not created and error \"password should have at least 8 characters\" is reported")
    public void userIsNotCreatedShortPassword() {
        pageHasContent("password should have at least 8 characters");
    }     
    
    @Then("user is not created and error \"password and password confirmation do not match\" is reported")
    public void userIsNotCreatedWrongConfirmation() {
        pageHasContent("password and password confirmation do not match");
    }      
    
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @Then("uncreated user is not logged in and error message is given")
    public void uncreatedUserIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    } 
    
    @Then("nonexistent user is not logged in and error message is given")
    public void nonexistentUserIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    } 
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String string, String string2) {
        logInWith(string, string2);
    }

    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createUser(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }     
}
