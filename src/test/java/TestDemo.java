import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestDemo {
    private static final String ONLINER = "https://onliner.by";
    private static final String DYSON = "Dyson";

    @Test
    public void checkIfHairDryerIsSelected() {
        String dyson = "Dyson";

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(ONLINER);
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        driver.findElement(By.xpath("(//span[text()='" + DYSON + "'])[1]/..")).click();

        String expectedResult = driver
                .findElement(By.xpath("//span[@class='schema-tags__text' and text()='Dyson']"))
                .getText();

        assertThat(expectedResult).isEqualTo(DYSON);

        driver.quit();
    }
}
