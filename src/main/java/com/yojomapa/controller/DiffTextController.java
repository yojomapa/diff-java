package com.yojomapa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @RequestMapping(value = "/{id}/left", method = RequestMethod.PUT,
          consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<String> addLeftText(@RequestBody String base64Encoded, @PathVariable String id) {

    System.out.println("base64Encoded = [" + base64Encoded + "], id = [" + id + "]");

    return new ResponseEntity<>("Left Text Added: " + id + ": " + base64Encoded, HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/{id}/right", method = RequestMethod.PUT,
          consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<String> addRightText(@RequestBody String base64Encoded, @PathVariable String id) {

    System.out.println("base64Encoded = [" + base64Encoded + "], id = [" + id + "]");

    return new ResponseEntity<>("Right Text Added: " + id + ": " + base64Encoded, HttpStatus.ACCEPTED);
  }
}
