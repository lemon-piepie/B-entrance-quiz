package com.thoughtworks.capability.gtb.entrancequiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.Dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentToGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentToGroup studentToGroup;

    @BeforeEach
    void init(){
        studentToGroup = new StudentToGroup();
    }

    @Test
    void shouldInitStudent() {
        List<StudentDto> allStudent = StudentToGroup.getAllStudent();
        assertEquals("廖浚斌",allStudent.get(0).getName());
        assertEquals(37,allStudent.size());
    }

    @Test
    void shouldAddStudent() {
        StudentDto newStudent = StudentDto.builder()
                                .name("何力")
                                .build();
        List<StudentDto> allStudent = StudentToGroup.addOneStudent(newStudent);
        assertEquals("廖浚斌",allStudent.get(0).getName());
        assertEquals(38,allStudent.size());
    }

    @Test
    void shouldGetInitStudent() throws Exception {
        mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(37)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].name",is("廖浚斌")));
    }

    @Test
    void shouldAddThenGetNewStudent() throws Exception {
        StudentDto newStudent =new StudentDto(38,"何力");
        ObjectMapper objectMapper = new ObjectMapper();
        String postUserEventJson = objectMapper.writeValueAsString(newStudent);

        mockMvc.perform(post("/new-student").content(postUserEventJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(38)))
                .andExpect(jsonPath("$[37].id",is(38)))
                .andExpect(jsonPath("$[37].name",is("何力")));
    }
}
