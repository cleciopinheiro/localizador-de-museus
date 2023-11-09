package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MuseumController.
 */
@Controller
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  /**
   * PostMapping
   * 
   * @param newMuseumDto do tipo MuseumCreationDto, vindo do corpo da requisição.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto newMuseumDto) {
    Museum newMuseum = ModelDtoConverter.dtoToModel(newMuseumDto);
    Museum museum = service.createMuseum(newMuseum);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(museum);
    return ResponseEntity.status(HttpStatus.CREATED).body(museumDto);
  }
}
