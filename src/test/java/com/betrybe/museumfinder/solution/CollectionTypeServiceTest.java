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
@DisplayName("Testes da CollectionTypeService")
public class CollectionTypeServiceTest {

  @MockBean
  MuseumFakeDatabase museumFakeDatabase;

  @Autowired
  CollectionTypeService service;

  @Test
  @DisplayName("Testa countByCollectionTypes")
  void testCountByCollectionTypes() {
    Mockito.when(museumFakeDatabase.countByCollectionType("história"))
        .thenReturn(300L);
    String[] type = new String[]{"história"};
    CollectionTypeCount collectionTypeCount = new CollectionTypeCount(type, 300L);

    Assertions.assertEquals(collectionTypeCount.count(),
        service.countByCollectionTypes("história").count());
    Assertions.assertEquals(collectionTypeCount.collectionTypes()[0],
        service.countByCollectionTypes("história").collectionTypes()[0]);
  }

}