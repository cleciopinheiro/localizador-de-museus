package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Camada de Service para Museum.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private MuseumFakeDatabase database;

  @Autowired
  public MuseumService(MuseumFakeDatabase database) {
    this.database = database;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException();
    }

    Museum newMuseum = database.saveMuseum(museum);
    return newMuseum;
  }

  @Override
  public Museum getMuseum(Long id) {
    Optional<Museum> museum = database.getMuseum(id);

    if (museum.isEmpty()) {
      throw new MuseumNotFoundException();
    }

    return museum.get();
  }
}