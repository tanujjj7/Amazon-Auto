package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import java.time.Duration;

public class IPhoneTest extends BaseTest {

        @Test
        public void searchIPhoneAndAddToCart() {
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            driver.get("https://www.amazon.in");
            System.out.println("[iPhone Test] Open Amazon");

            WebElement searchBox = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox"))
            );
            searchBox.clear();
            searchBox.sendKeys("iPhone");
            searchBox.sendKeys(Keys.ENTER);
            System.out.println("[iPhone Test] Search: iPhone");


            WebElement firstResult = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("div[data-component-type='s-search-result'] h2 a")
                    )
            );
            String productName = firstResult.getText();
            System.out.println("[iPhone Test] Product found: " + productName);
            firstResult.click();


            String originalWindow = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(originalWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            try {
                WebElement priceElement = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.cssSelector(".a-price-whole")
                        )
                );
                String price = priceElement.getText();
                System.out.println("========================================");
                System.out.println("[iPhone Test] PRODUCT: " + productName);
                System.out.println("[iPhone Test] PRICE: Rs. " + price);
                System.out.println("========================================");
            } catch (Exception e) {
                System.out.println("[iPhone Test] Skip");
            }

            try {
                WebElement addToCart = wait.until(
                        ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))
                );
                addToCart.click();
                System.out.println("[iPhone Test] Add to cart");
            } catch (Exception e) {
                System.out.println("[iPhone Test] Button not found: " + e.getMessage());
            }
        }
    }
