import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.By.xpath;

public class TestDemo {
    private static final String ONLINER = "https://onliner.by";
    private static final String DYSON = "Dyson";
    private static final String ROWENTA = "Rowenta";
    private static final String BABYLISS = "BaByliss";
    private static final String BABYLISS_PRO = "BaByliss PRO";

    private static final By LOCATOR_HAIR_DRYERS = xpath("//span[text()='Фены']");
    private static final By LOCATOR_CHOOSE_CURRENT_LOCATION = xpath("//div[@class='popover-style__content']/div[2]/span[1]");

    @Test
    public void checkIfHairDryerIsSelected() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(ONLINER);
        driver.findElement(LOCATOR_HAIR_DRYERS).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        driver.findElement(By.xpath("(//span[text()='" + DYSON + "'])[1]/..")).click();

        String expectedResult = driver
                .findElement(By.xpath("//span[@class='schema-tags__text' and text()='Dyson']"))
                .getText();

        assertThat(expectedResult).isEqualTo(DYSON);

        driver.quit();
    }

    @Test
    public void checkIfSeveralHairDryerIsSelected() {
        List<String> manufacturesHairDryer = new ArrayList<>();
        manufacturesHairDryer.add(DYSON);
        manufacturesHairDryer.add(ROWENTA);
        manufacturesHairDryer.add(BABYLISS);
        manufacturesHairDryer.add(BABYLISS_PRO);

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(ONLINER);
        driver.findElement(LOCATOR_HAIR_DRYERS).click();
        driver.findElement(LOCATOR_CHOOSE_CURRENT_LOCATION).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");

        driver.findElement(xpath("(//span[text()='" + manufacturesHairDryer.get(0) + "'])[1]/..")).click();
        driver.findElement(xpath("(//span[text()='" + manufacturesHairDryer.get(1) + "'])[1]/..")).click();
        driver.findElement(xpath("(//span[text()='" + manufacturesHairDryer.get(2) + "'])[1]/..")).click();
        driver.findElement(xpath("(//span[text()='" + manufacturesHairDryer.get(3) + "'])[1]/..")).click();

        List<String> listOfManufacturesHairDryer = new ArrayList<>();
        driver.findElements(xpath("//span[@class='schema-tags__text']"))
                .forEach((WebElement questionEl) -> listOfManufacturesHairDryer
                        .add(questionEl.getText()));

        assertThat(listOfManufacturesHairDryer.containsAll(manufacturesHairDryer)).isTrue();

        driver.quit();
    }
}
