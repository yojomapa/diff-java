package com.yojomapa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yojomapa.data.TextRepository;
import com.yojomapa.model.DiffText;
import com.yojomapa.utils.TextUtils;

/**
 * Class that provides the business logic for the Text processing
 *
 * Created by yojomapa on 22/03/17.
 */
@Service
public class TextService {

  public static final String LEFT_KEY_TEMPLATE = "%s:left";
  public static final String RIGHT_KEY_TEMPLATE = "%s:right";
  public static final String EQUAL = "equal";
  public static final String NOT_OF_EQUAL_SIZE = "not of equal size";
  public static final String SAME_SIZE_WITH_DIFFERENCES = "same size with differences";

  @Autowired
  private TextRepository textRepository;

  public void saveLeft(String id, String base64Text) {
    String leftKey = String.format(LEFT_KEY_TEMPLATE, id);
    textRepository.add(leftKey, base64Text);
  }

  public void saveRight(String id, String base64Text) {
    String rightKey = String.format(RIGHT_KEY_TEMPLATE, id);
    textRepository.add(rightKey, base64Text);
  }

  public String getDifferences(String id) {
    String leftKey = String.format(LEFT_KEY_TEMPLATE, id);
    String rightKey = String.format(RIGHT_KEY_TEMPLATE, id);
    List<String> values = textRepository.getValues(Arrays.asList(leftKey, rightKey));

    DiffText diffText = checkDifferences(values.get(0), values.get(1));
    return String.join(",", diffText.getDifferences());
  }

  private DiffText checkDifferences(String left, String right) {

    DiffText diffText = new DiffText(left, right);

    if (!StringUtils.isEmpty(left) && !StringUtils.isEmpty(right)) {
      if (left.equals(right)) {
        diffText.getDifferences().add(EQUAL);
      } else if (left.length() != right.length()) {
        diffText.getDifferences().add(NOT_OF_EQUAL_SIZE);
      } else {
        diffText.getDifferences().add(SAME_SIZE_WITH_DIFFERENCES);
        diffText.getDifferences().addAll(TextUtils.getDiffOffSets(left, right));
      }
    }

    return diffText;
  }
}
