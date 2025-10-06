package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class UITestUtil {


    public static boolean checkVisibility(WebElement element)
    {
        boolean result = false;
        try {
            result = element.isDisplayed();
        } catch (Exception e) {

        }
        return result;
    }

    public static boolean checkEnability(WebElement element)
    {
        boolean result = false;
        try {
            result = element.isEnabled();
        } catch (Exception e) {

        }
        return result;
    }


    public static String checkSpelling(WebElement element)
    {
        String result = "";
        try {
            result = element.getText();
        } catch (Exception e) {

        }
        return result;
    }

    public static String checkPlaceholder(WebElement element)
    {
        String result = "";
        try {
            result = element.getAttribute("placeholder");
        } catch (Exception e) {

        }
        return result;
    }

    public static String checkCssValue(WebElement element,String propertyName)
    {
        String result = "";
        try {
            result = element.getCssValue(propertyName);
        } catch (Exception e) {

        }
        return result;
    }

    public static String checkColor(WebElement element,String colorPropertyName)
    {
        String colorRGB = checkCssValue(element, colorPropertyName);

        return  Color.fromString(colorRGB).asHex();

    }

}
