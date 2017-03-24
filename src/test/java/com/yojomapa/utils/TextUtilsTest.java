package com.yojomapa.utils;

import com.yojomapa.utils.TextUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

/**
 * Created by yojomapa on 24/03/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TextUtilsTest {

  @Test
  public void testDiffOffSets() {
    String left =  "RequestMappingHandlerMappin";
    String right = "RequestMapingpHanderlMappin";

    List<String> diffs = TextUtils.getDiffOffSets(left, right);

    System.out.println(diffs);

    assertThat("Should have 7 differences", diffs.size(), is(7));
  }

  @Test
  public void testDiffOffSetsNoDiff() {
    String left =  "RequestMappingHandlerMappin";
    String right = "RequestMappingHandlerMappin";

    List<String> diffs = TextUtils.getDiffOffSets(left, right);

    System.out.println(diffs);

    assertThat("Should have 0 differences", diffs.size(), is(0));
  }
  @Test
  public void testDiffOffSetsDifferentSize() {
    String left =  "RequestMappingHandlerMappin";
    String right = "RequestMappingHandlerMappingggg";

    List<String> diffs = TextUtils.getDiffOffSets(left, right);

    System.out.println(diffs);

    assertThat("Should have 0 differences", diffs.size(), is(0));
  }
}
