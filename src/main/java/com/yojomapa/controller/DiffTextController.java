package com.yojomapa.controller;

import com.yojomapa.service.TextService;
import com.yojomapa.utils.Base64TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yojomapa on 21/03/17.
 */
@RequestMapping("/v1/diff")
@RestController
public class DiffTextController {

  @Autowired
  TextService textService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
  public ResponseEntity<String> applyDiff(@PathVariable String id) {
    return new ResponseEntity<>(textService.getDifferences(id), HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}/left", method = RequestMethod.PUT,
          consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.TEXT_HTML_VALUE)
  public ResponseEntity<String> addLeftText(@RequestBody String[] base64Encoded, @PathVariable String id) {
    String jsonPayload = base64Encoded != null? base64Encoded[0] : "";
    textService.saveLeft(id, Base64TextUtils.transformToString(jsonPayload));
    return new ResponseEntity<>("Left Text Added with id: " + id, HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/{id}/right", method = RequestMethod.PUT,
          consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.TEXT_HTML_VALUE)
  public ResponseEntity<String> addRightText(@RequestBody String[] base64Encoded, @PathVariable String id) {
    String jsonPayload = base64Encoded != null? base64Encoded[0] : "";
    textService.saveRight(id, Base64TextUtils.transformToString(jsonPayload));
    return new ResponseEntity<>("Right Text Added with id: " + id, HttpStatus.ACCEPTED);
  }
}
