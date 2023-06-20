package spriteCloud.pages;

import org.openqa.selenium.support.PageFactory;
import spriteCloud.utilities.Driver;

public class TestBase {

    public TestBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
