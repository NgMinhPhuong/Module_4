package com.codegym.demo_springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ListStudentController_getList {
    @Autowired
    private MockMvc mockMvc;

    /*
    * HaiTT
    * Check successful
    * @throws Exception
     */
    @Test
    void getAllStudent_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/student?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("list"));
    }

    /*
     * HaiTT
     * Check no content
     * @throws Exception
     */
    @Test
    void getAllStudent_2() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/student?page=500"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(view().name("404"));
    }

    /*
     * HaiTT
     * page < 0
     * @throws Exception
     */
    @Test
    void getAllStudent_3() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/student?page=-1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(view().name("400"));
    }


}
