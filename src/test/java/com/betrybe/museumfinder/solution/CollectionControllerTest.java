package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes da CollectionController")
public class CollectionControllerTest {

  @MockBean
  CollectionTypeService collectionTypeService;

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("Rota GET /collection/count/{typeList} implementada")
  void testGetCollectionTypesCount() throws Exception {
    String[] collectionTypes = new String[]{"história"};
    CollectionTypeCount collectionTypeCount = new CollectionTypeCount(collectionTypes, 300);
    Mockito.when(collectionTypeService.countByCollectionTypes("história"))
        .thenReturn(collectionTypeCount);

    mockMvc.perform(get("/collections/count/história"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.count").value(300))
        .andExpect(jsonPath("$.collectionTypes").value(collectionTypes[0]));

  }

}