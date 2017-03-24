package com.yojomapa.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yojomapa on 22/03/17.
 */
public class DiffText {

  private String left;

  private String right;

  private boolean contentEquals;

  private List<String> differences;


  public DiffText(String left, String right) {
    this.left = left;
    this.right = right;
  }

  public DiffText(String left, String right, List<String> differences) {
    this.left = left;
    this.right = right;
    this.differences = differences;
  }

  public String getLeft() {
    return left;
  }

  public void setLeft(String left) {
    this.left = left;
  }

  public String getRight() {
    return right;
  }

  public void setRight(String right) {
    this.right = right;
  }

  public boolean isContentEquals() {
    return contentEquals;
  }

  public void setContentEquals(boolean contentEquals) {
    this.contentEquals = contentEquals;
  }

  public List<String> getDifferences() {
    if (differences == null) {
      differences = new ArrayList<>();
    }
    return differences;
  }

  public void setDifferences(List<String> differences) {
    this.differences = differences;
  }
}
