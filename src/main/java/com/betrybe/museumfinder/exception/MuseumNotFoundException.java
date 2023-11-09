package com.betrybe.museumfinder.exception;

/**
 * Exception for invalid coordinates.
 */
public class MuseumNotFoundException extends RuntimeException {
  public MuseumNotFoundException() {
    super("Museu não encontrado");
  }
}
