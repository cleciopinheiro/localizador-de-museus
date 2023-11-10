package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.evaluation.utils.TestHelpers;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testa MuseumController")
public class MuseumControllerTest {

  @MockBean
  MuseumServiceInterface service;

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("Rota Get /museums/{id}")
  void testGetMuseum() throws Exception {
    Museum museum = TestHelpers.createMockMuseum(40L);
    Mockito.when(service.getMuseum(40L)).thenReturn(museum);

    MuseumDto museumDto = ModelDtoConverter.modelToDto(museum);

    mockMvc.perform(get("/museums/40")
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(40));

  }
}