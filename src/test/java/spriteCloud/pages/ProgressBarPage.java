package spriteCloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage extends TestBase {


    @FindBy(id = "startButton")
    public WebElement startButton;

    @FindBy(id = "stopButton")
    public WebElement stopButton;

    @FindBy(id = "progressBar")
    public WebElement progressBar;



}
