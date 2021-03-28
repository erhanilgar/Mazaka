package com.mazaka.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {
    public static void hover(WebElement element) {
        Actions actions = new Actions(com.mazaka.utilities.Driver.get());
        actions.moveToElement(element).perform();
    }
}
