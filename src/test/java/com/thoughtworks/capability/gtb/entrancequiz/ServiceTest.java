package com.thoughtworks.capability.gtb.entrancequiz;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.AllStudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentToGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private StudentToGroup studentToGroup;

    @BeforeEach
    void init(){
        studentToGroup = new StudentToGroup();
    }

    @Test
    void shouldInitStudent() {
        AllStudentDto allStudent = StudentToGroup.getAllStudent();
        assertEquals("廖浚斌",allStudent.getAllStudents().get(0).getName());
        assertEquals(37,allStudent.getAllStudents().size());
    }

    @Test
    void shouldAddStudent() {
        StudentDto newStudent = StudentDto.builder()
                                .name("何力")
                                .build();
        AllStudentDto allStudent = StudentToGroup.addOneStudent(newStudent);
        assertEquals("廖浚斌",allStudent.getAllStudents().get(0).getName());
        assertEquals(38,allStudent.getAllStudents().size());
    }
}
