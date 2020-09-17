package me.whiteship.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void jsonMessage() throws Exception{
        Person person = new Person();
        person.setId(2020l);
        person.setName("seungjun");

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void hello() throws Exception {

        Person person = new Person();
        person.setName("seungjun");
        Person savedPerson = personRepository.save(person);

        this.mockMvc.perform(get("/hello")
                                .param("id", savedPerson.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello seungjun"));
    }

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL))
                .andExpect(content().string(Matchers.containsString("Hello Mobile!")));
    }

    @Test
    public void stringMessage() throws Exception{
        this.mockMvc.perform(get("/message")
                .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

}