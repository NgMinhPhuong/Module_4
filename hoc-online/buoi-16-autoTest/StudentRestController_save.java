package com.codegym.demo_springboot;

import com.codegym.demo_springboot.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_save {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /*
    HaiTT
    check successful

     */
    @Test
    void save_1() throws Exception {
        Student student = new Student();
        student.setNameStudent("HaiTT");
        student.setPoint(5.0);
        student.setGender(1);
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/student")
                        .content(this.objectMapper.writeValueAsString(student))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void save_2() throws Exception {
        Student student = new Student();
        student.setNameStudent("");
        student.setPoint(5.0);
        student.setGender(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/student")
                                .content(this.objectMapper.writeValueAsString(student))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
