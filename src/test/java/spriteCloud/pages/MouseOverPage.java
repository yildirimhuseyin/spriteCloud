package spriteCloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MouseOverPage extends TestBase{


    @FindBy (xpath = "//a[.='Click me']")
    public WebElement clickMeText;

    @FindBy (id = "clickCount")
    public WebElement clickCounter;

}
