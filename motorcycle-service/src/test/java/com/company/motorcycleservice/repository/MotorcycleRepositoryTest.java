package com.company.motorcycleservice.repository;

import com.company.motorcycleservice.model.Motorcycle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MotorcycleRepositoryTest {


    @Autowired
    MotorcycleRepository repository;

    @MockBean
    EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void AddMotorcycle() {
        Motorcycle input = new Motorcycle();

        input.setMake("make");
        input.setModel("model");
        input.setYear("199");
        input.setVin("vinnyvin");
        input.setColor("color");
        input.setPrice(BigDecimal.valueOf(199.99));
        Motorcycle test = input;
        repository.save(input);

        assertEquals(test, input);

    }

    @Test
    public void getMotorcycle(){
        Motorcycle input = new Motorcycle();

        input.setMake("make");
        input.setModel("model");
        input.setYear("199");
        input.setVin("vinnyvin");
        input.setColor("color");
        input.setPrice(BigDecimal.valueOf(199.99));
        repository.save(input);

       Motorcycle actual = repository.getOne(input.getId());

       assertEquals(actual,input);

    }



    @Test
    public void getAllMotorcycle(){

        List<Motorcycle>


    }


    @Test
    public void updateMotorcycle(){
        Motorcycle input = new Motorcycle();

        input.setMake("make");
        input.setModel("model");
        input.setYear("199");
        input.setVin("vinnyvin");
        input.setColor("color");
        input.setPrice(BigDecimal.valueOf(199.99));
        Motorcycle test = input;
        repository.save(input);
        input.setPrice(BigDecimal.valueOf(299.99));
        repository.save(input);

        assertEquals(299.99, input.getPrice());
    }


    @Test
    public void deleteMotorcycle(){
        Motorcycle input = new Motorcycle();

        input.setMake("make");
        input.setModel("model");
        input.setYear("199");
        input.setVin("vinnyvin");
        input.setColor("color");
        input.setPrice(BigDecimal.valueOf(199.99));
        Motorcycle test = input;
        repository.save(input);

        assertNull(repository.getOne(input.getId()));
    }
}
