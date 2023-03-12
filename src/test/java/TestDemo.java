import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestDemo {
    private static final String ONLINER = "https://onliner.by";
    private static final By LOCATOR_HAIR_DRYERS = By.xpath("//span[text()='Фены']");
    private static final String DYSON = "Dyson";
    private static final String ROWENTA = "Rowenta";
    private static final String BABYLISS = "BaByliss";
    private static final String BABYLISS_PRO = "BaByliss PRO";

//    @Test
//    public void checkIfHairDryerIsSelected() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get(ONLINER);
//        driver.findElement(LOCATOR_HAIR_DRYERS).click();
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
//        driver.findElement(By.xpath("(//span[text()='" + DYSON + "'])[1]/..")).click();
//
//        String expectedResult = driver
//                .findElement(By.xpath("//span[@class='schema-tags__text' and text()='Dyson']"))
//                .getText();
//
//        assertThat(expectedResult).isEqualTo(DYSON);
//
//        driver.quit();
//    }

    @Test
    public void checkIfSeveralHairDryerIsSelected() {
        ArrayList<String> manufacturesHairDryer = new ArrayList<>();
        manufacturesHairDryer.add(DYSON);
        manufacturesHairDryer.add(ROWENTA);
        manufacturesHairDryer.add(BABYLISS);
        manufacturesHairDryer.add(BABYLISS_PRO);

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(ONLINER);
        driver.findElement(LOCATOR_HAIR_DRYERS).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");

        driver.findElement(By.xpath("(//span[text()='" + manufacturesHairDryer.get(0) + "'])[1]/..")).click();
        driver.findElement(By.xpath("(//span[text()='" + manufacturesHairDryer.get(1) + "'])[1]/..")).click();
        driver.findElement(By.xpath("(//span[text()='" + manufacturesHairDryer.get(2) + "'])[1]/..")).click();
        driver.findElement(By.xpath("(//span[text()='" + manufacturesHairDryer.get(3) + "'])[1]/..")).click();


    }
}
