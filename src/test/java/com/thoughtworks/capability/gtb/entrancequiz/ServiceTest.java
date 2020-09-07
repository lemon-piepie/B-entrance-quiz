package com.thoughtworks.capability.gtb.entrancequiz;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.AllStudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentToGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private StudentToGroup studentToGroup;

    @Test
    void shouldInitStudent() {
        AllStudentDto allStudent = StudentToGroup.getAllStudent();
        assertEquals("廖浚斌",allStudent.getAllStudents().get(0).getName());
        assertEquals(37,allStudent.getAllStudents().size());
    }
}
