package com.example.hibernatecasacde.controller;

import com.example.hibernatecasacde.dto.CreateAuthorPersistDto;
import com.example.hibernatecasacde.model.Author;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/createTestDB.sql")
@Sql("/addTestData.sql")
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createAuthorTestPositive() throws Exception {
        CreateAuthorPersistDto dto = new CreateAuthorPersistDto();
        dto.setName("TEST_NAME");
        dto.setTitle("TEST_TITLE");

        String capDTO = objectMapper.writeValueAsString(dto);

        System.out.println("**********************************************");
        System.out.println("**********************************************");
        System.out.println("**********************************************");


        System.out.println("CAPDTO: " + capDTO);


        System.out.println("**********************************************");
        System.out.println("**********************************************");
        System.out.println("**********************************************");

        MvcResult createAuthorResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/con/persist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(capDTO))
                .andReturn();

        String authorResultJSON = createAuthorResult.getResponse().getContentAsString();
        Author authorResult = objectMapper.readValue(authorResultJSON, Author.class);

        Assertions.assertEquals(201, createAuthorResult.getResponse().getStatus());
        Assertions.assertEquals(dto.getName(), authorResult.getName());
    }

//    @Test
//    void createAuthorTestWithAuthorAlreadyExistException() throws Exception {
//        CreateAuthorPersistDto dto = new CreateAuthorPersistDto();
//        dto.setName("Leo");
//        dto.setTitle(null);
//
//        String capDTO = objectMapper.writeValueAsString(dto);
//
//        System.out.println("**********************************************");
//        System.out.println("**********************************************");
//        System.out.println("**********************************************");
//
//
//        System.out.println("CAPDTO: " + capDTO);
//
//
//        System.out.println("**********************************************");
//        System.out.println("**********************************************");
//        System.out.println("**********************************************");
//
//        MvcResult createAuthorResult = mockMvc
//                .perform(MockMvcRequestBuilders.post("/con/persist")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(capDTO))
//                .andReturn();
//
//        String authorResultJSON = createAuthorResult.getResponse().getContentAsString();
//        Author authorResult = objectMapper.readValue(authorResultJSON, Author.class);
//
//        Assertions.assertEquals(201, createAuthorResult.getResponse().getStatus());
//        Assertions.assertEquals(dto.getName(), authorResult.getName());
//    }
}