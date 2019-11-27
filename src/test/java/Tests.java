import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    WebDriver webDriver = null;

    @Test
    public void checkHomePageTitle() throws InterruptedException {

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.setProperty("webdriver.chrome.driver",projectPath+"\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //Ödevin 1. aşaması
        webDriver.get("https://www.finartz.com/");
        webDriver.manage().window().maximize();
        Thread.sleep(2000);
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Finartz - Homepage";
        Assertions.assertEquals(expectedTitle,actualTitle);
        // 2. aşaması
        Thread.sleep(2000);
        WebElement solutionsClick = webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/nav/div/div[2]/div/a[3]"));
        solutionsClick.click();
        Thread.sleep(3000);
        //3. aşaması
        List<WebElement> solutions=webDriver.findElements(By.className("dark-text"));
        for (int i=0; i<solutions.size(); i++){
            System.out.println(solutions.get(i).getText());
        }
        Thread.sleep(2000);

        //4. aşaması
        WebElement blogClick = webDriver.findElement(By.cssSelector("body > div.hero.parallax.is-cover.is-relative.is-default.is-bold > div.navbar-placeholder > nav > div > div.navbar-menu > div > a:nth-child(7)"));
        blogClick.click();
        Thread.sleep(2000);
        String actualTitles = webDriver.getTitle();
        String expectedTitles = "Finartz";
        Assertions.assertEquals(expectedTitle,actualTitle);

        //5. aşaması
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(tabs.size() - 1));
        Thread.sleep(2000);
        WebElement searchButton = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/nav/div[1]/label/span"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement searchTextBox = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/nav/div[1]/label/input"));
        searchTextBox.sendKeys("Financial Services");
        Thread.sleep(2000);
        searchTextBox.sendKeys(Keys.RETURN);
        Thread.sleep(10000);

        //6. aşaması
        webDriver.quit();

        //thread.sleep(); kodları testin o aşamasının gerçekletiğini bildirmek için koyuldu ve
        //5nci aşamada Medium.com da ki search box arama kısmıda orada ki animasyon açılımını bekleme
        //amaçlı yerleştirildi.
    }


}
