package spriteCloud.step_definitions;


import io.cucumber.java.en.*;
import org.junit.Assert;
import spriteCloud.pages.ProgressBarPage;
import spriteCloud.utilities.Driver;


public class ProgressBar_StepDefs {

    ProgressBarPage progressBarPage = new ProgressBarPage();
    String expectedPercentage = "";

    @Given("user on the progress bar page")
    public void user_on_the_progress_bar_page() {
        Driver.getDriver().get("http://www.uitestingplayground.com/progressbar");
    }
    @When("user click on the start button")
    public void user_click_on_the_start_button() {
        progressBarPage.startButton.click();
    }
    @Then("user click on the stop button when percentage reached to {string}")
    public void user_click_on_the_stop_button_when_percentage_reached_to(String percentage) {
        String actualValue = progressBarPage.progressBar.getAttribute("aria-valuenow");


        expectedPercentage = percentage;
        System.out.println("actualValue = " + actualValue);
        while (!percentage.contains(actualValue)) {
            System.out.println("actualValue = " + actualValue);
            actualValue = progressBarPage.progressBar.getText();

            if (percentage.contains(actualValue)) {
                progressBarPage.stopButton.click();
                break;
            }
        }


    }

    @Then("user sees progress bar stopped exactly where user wants")
    public void user_sees_progress_bar_stopped_exactly_where_user_wants() {
        String actualPercentage = progressBarPage.progressBar.getText();
        Assert.assertEquals(expectedPercentage,actualPercentage);
    }


}
