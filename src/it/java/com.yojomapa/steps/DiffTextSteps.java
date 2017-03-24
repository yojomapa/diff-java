package com.yojomapa.steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by yojomapa on 23/03/17.
 */
public class DiffTextSteps implements En {

  public DiffTextSteps() {

    Given("^the id value is \"([^\"]*)\"$", (String arg1) -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });

    Given("^the left text is$", (String base64) -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });

    Given("^the right text is$", (String base64) -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });

    When("^left and right rest endpoints are called with the corresponding text$", () -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });

    Then("^the call to the diff endpoint should return \"([^\"]*)\"$", (String arg1) -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });
  }
}
