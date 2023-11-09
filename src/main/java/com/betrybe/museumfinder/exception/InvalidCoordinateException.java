package com.betrybe.museumfinder.exception;

/**
 * Exception for invalid coordinates.
 */
public class InvalidCoordinateException extends RuntimeException {
  public InvalidCoordinateException() {
    super("Coordenada inválida");
  }
}
