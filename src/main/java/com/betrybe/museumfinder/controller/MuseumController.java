package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cria a controller da aplicação de museus.
 *
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface service;

  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  /**
   * PostMapping.
   *
   * @param newMuseumDto do tipo MuseumCreationDto, vindo da requisição.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto newMuseumDto) {
    Museum newMuseum = ModelDtoConverter.dtoToModel(newMuseumDto);
    Museum museum = service.createMuseum(newMuseum);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(museum);
    return ResponseEntity.status(HttpStatus.CREATED).body(museumDto);
  }

  /**
   * GetMapping.
   *
   * @param lat       double.
   * @param lng       double.
   * @param maxDistanceKm double.
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam double lat,
      @RequestParam double lng,
      @RequestParam("max_dist_km") double maxDistanceKm
  ) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum museum = service.getClosestMuseum(coordinate, maxDistanceKm);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(museum);
    return ResponseEntity.status(HttpStatus.OK).body(museumDto);
  }

  /**
   * GetMapping.
   *
   * @param id long.
   */
  @GetMapping("/{id}")
  public ResponseEntity<MuseumDto> getMuseumById(@PathVariable long id) {
    Museum museum = service.getMuseum(id);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(museum);
    return ResponseEntity.status(HttpStatus.OK).body(museumDto);
  }
}
