package com.yojomapa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yojomapa on 21/03/17.
 */
@RequestMapping("/v1/diff")
@RestController
public class DiffTextController {

  @RequestMapping(value = "/{id}")
  public ResponseEntity<String> applyDiff(@PathVariable String id) {
    return new ResponseEntity<>("Equals: " + id, HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}/left", method = RequestMethod.PUT)
  public ResponseEntity<String> addLeftText(@PathVariable String id) {
    return new ResponseEntity<>("Left Text Added: " + id, HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/{id}/right", method = RequestMethod.PUT)
  public ResponseEntity<String> addRightText(@PathVariable String id) {
    return new ResponseEntity<>("Right Text Added: " + id, HttpStatus.ACCEPTED);
  }
}
