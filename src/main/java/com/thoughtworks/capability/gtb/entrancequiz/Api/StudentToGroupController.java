package com.thoughtworks.capability.gtb.entrancequiz.Api;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.AllStudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentToGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentToGroupController {
    private final StudentToGroup studentToGroup;

    public StudentToGroupController(StudentToGroup studentToGroup){
        this.studentToGroup = studentToGroup;
    }

    @GetMapping("/group")
    public AllStudentDto getAllStudent(){
        return studentToGroup.getAllStudent();
    }

    @PostMapping("/new-student")
    public AllStudentDto addOneStudent(@RequestBody StudentDto newstudent){
        return studentToGroup.addOneStudent(newstudent);
    }
}