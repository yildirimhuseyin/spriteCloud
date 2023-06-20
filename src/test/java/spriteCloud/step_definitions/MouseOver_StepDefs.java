package spriteCloud.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import spriteCloud.pages.MouseOverPage;
import spriteCloud.utilities.Driver;


public class MouseOver_StepDefs {


    MouseOverPage mouseOverPage = new MouseOverPage();


    @Given("user on the mouse over page")
    public void user_on_the_mouse_over_page() {
        Driver.getDriver().get("http://www.uitestingplayground.com/mouseover");

    }
    @When("user hover over on click me text")
    public void user_hover_over_on_click_me_text() {
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(mouseOverPage.clickMeText).perform();
        Assert.assertEquals("Active Link", mouseOverPage.clickMeText.getAttribute("title"));


    }
    @Then("user user click on the click me text")
    public void user_user_click_on_the_click_me_text() {

        Assert.assertEquals("0", mouseOverPage.clickCounter.getText());
        for (int i = 0; i < 10; i++) {
            mouseOverPage.clickMeText.click();
        }
    }
    @Then("user see correct click count on the screen")
    public void user_see_correct_click_count_on_the_screen() {
        Assert.assertEquals("10", mouseOverPage.clickCounter.getText());
    }



}
