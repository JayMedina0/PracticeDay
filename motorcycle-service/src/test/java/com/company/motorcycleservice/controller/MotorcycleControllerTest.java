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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    public void getMotorcycle() throws Exception {
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

        when(repo.getOne(1)).thenReturn(output);

        this.mockMvc.perform(get("/motorcycle/1")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void getAllMotorcycle() throws Exception {
        Motorcycle output = new Motorcycle();
        output.setId(1);
        output.setMake("make");
        output.setModel("model");
        output.setYear("1999");
        output.setVin("vinnyvin");
        output.setColor("color");
        output.setPrice(BigDecimal.valueOf(199.99));


        List<Motorcycle> list = new ArrayList<>();
        list.add(output);
        when(repo.findAll()).thenReturn(list);

        String outputJson = mapper.writeValueAsString(list);

        this.mockMvc.perform(get("/motorcycle"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }



    @Test
    public void updateMotorcycle() throws Exception {
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


        this.mockMvc.perform(put("/motorycle")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteMotorcycle() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/motorcycle/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}