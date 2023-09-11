package com.betrybe.museumfinder.solution;

import static org.mockito.ArgumentMatchers.any;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CollectionTypeServiceTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private CollectionTypeService service;
  @MockBean
  MuseumFakeDatabase database;

  @Test
  public void testCollectionTypeControllerReturnsOk()  {
//    Mockito
//        .when(service.countByCollectionTypes("historia"));
//
//    ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/count/historia"));
//
//    result.andExpect(MockMvcResultMatchers.status().isOk());
//
//    Mockito.verify(service).countByCollectionTypes("historia");
    Mockito.when(database.countByCollectionType(any())).thenReturn(10L);

    assert(service.countByCollectionTypes("hist").count() == 10L);
  }

  @Test
  public void testCollectionTypeServiceReturnsNotFound() {

    Mockito.when(database.countByCollectionType(any())).thenReturn(0L);

    assert(service.countByCollectionTypes("hist,imag").count() == 0L);
  }

  @Test
  public void testCollectionTypeServiceReturnsOkWithTwoCollections() {

    Mockito.when(database.countByCollectionType(any())).thenReturn(20L);

    assert(service.countByCollectionTypes("hist,imag").count() == 40L);
  }
}
