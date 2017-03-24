package com.yojomapa.steps;

import com.yojomapa.data.TextRepository;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.yojomapa.bootstrap.Application;

import cucumber.api.java8.En;

import java.util.Arrays;

/**
 * Created by yojomapa on 23/03/17.
 */
@ActiveProfiles("test")
@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiffTextSteps implements En {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Autowired
  private TextRepository textRepository;

  private String id;

  private String left;

  private String right;

  private String result;

  public DiffTextSteps() {

    Given("^the id value is \"([^\"]*)\"$", (String id) -> {
      this.id = id;
    });

    Given("^the left text is$", (String base64) -> {
      this.left = base64;
    });

    Given("^the right text is$", (String base64) -> {
      this.right = base64;
    });

    When("^left rest endpoint is called with the given id and the corresponding text$", () -> {
      testRestTemplate.put("/v1/diff/{id}/left", this.left, this.id);
    });

    When("^right rest endpoint is called with the given id and the corresponding text$", () -> {
      testRestTemplate.put("/v1/diff/{id}/right", this.right, this.id);
    });

    When("^diff rest endpoint is called with the given id$", () -> {
      Mockito.when(textRepository.getValues(Mockito.anyCollection()))
          .thenReturn(Arrays.asList(this.left, this.right));
      ResponseEntity<String> httpResponse = testRestTemplate.getForEntity("/v1/diff/{id}", String.class, this.id);
      result = httpResponse.getBody();
      Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
    });

    Then("^the result should be \"([^\"]*)\"$", (String text) -> {

      if (this.result == null) {
        Assert.fail();
      }

      Assert.assertEquals(text, this.result);
    });

    Then("^the result should contains \"([^\"]*)\"$", (String text) -> {
      if (this.result == null) {
        Assert.fail();
      }

      Assert.assertTrue(this.result.contains(text));
    });
  }
}
