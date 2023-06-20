package spriteCloud.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import spriteCloud.utilities.BrowserUtils;
import spriteCloud.utilities.Driver;

public class Hooks {




    @After(value = "@ui")
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

         BrowserUtils.sleep(2);
         Driver.closeDriver();

    }

}
