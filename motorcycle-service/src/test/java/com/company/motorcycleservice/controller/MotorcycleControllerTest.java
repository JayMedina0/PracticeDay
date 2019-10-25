package com.company.motorcycleservice.controller;

import com.company.motorcycleservice.model.Motorcycle;
import com.company.motorcycleservice.repository.MotorcycleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class MotorcycleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MotorcycleRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void addMotorcycle() throws Exception {
        Motorcycle input = new Motorcycle();

        input.setMake("make");
        input.setModel("model");
        input.setYear("199");
        input.setVin("vinnyvin");
        input.setColor("color");
        input.setPrice(BigDecimal.valueOf(199.99));
        String inputJson = mapper.writeValueAsString(input);

        Motorcycle output = new Motorcycle();
        output.setId(1);
        output.setMake("make");
        output.setModel("model");
        output.setYear("1999");
        output.setVin("vinnyvin");
        output.setColor("color");
        output.setPrice(BigDecimal.valueOf(199.99));
        String outputJson = mapper.writeValueAsString(output);

        when(repo.save(input)).thenReturn(output);

        this.mockMvc.perform(post("/motorcycle")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }




    @Test
    public void getMotorcycle() {
    }

    @Test
    public void getAllMotorcycle() {
    }

    @Test
    public void updateMotorcycle() {
    }

    @Test
    public void deleteMotorcycle() {
    }
}