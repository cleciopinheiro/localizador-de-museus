package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("Testes da CollectionService")
public class CollectionServiceTest {
  @MockBean
  MuseumFakeDatabase museumFakeDatabase;

  @Autowired
  CollectionTypeService service;

  @Test
  @DisplayName("Testa se o método countByCollectionTypes retorna o resultado correto")
  void testCountByCollectionTypes() {
    Mockito.when(museumFakeDatabase.countByCollectionType("história"))
        .thenReturn(300L);
    String[] collectionTypes = new String[]{"história"};
    CollectionTypeCount collectionTypeCount = new CollectionTypeCount(collectionTypes, 300L);

    Assertions.assertEquals(collectionTypeCount.count(),
        service.countByCollectionTypes("história").count());

    Assertions.assertEquals(collectionTypeCount.collectionTypes()[0],
        service.countByCollectionTypes("história").collectionTypes()[0]);
  }
}
