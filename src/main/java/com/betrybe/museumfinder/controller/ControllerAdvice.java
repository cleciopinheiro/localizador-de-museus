package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import java.sql.PreparedStatement;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller Adive.
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
  
  @ExceptionHandler({InvalidCoordinateException.class})
  public ResponseEntity<String> handleInvalidCoordinateException(InvalidCoordinateException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }

  @ExceptionHandler({MuseumNotFoundException.class})
  public ResponseEntity<String> handleMuseumNotFoundException(MuseumNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<String> handleException(Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}
