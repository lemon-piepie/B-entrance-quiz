package com.thoughtworks.capability.gtb.entrancequiz.Api;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.AllStudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentToGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentToGroupService {
    private final StudentToGroup studentToGroup;

    public StudentToGroupService(StudentToGroup studentToGroup){
        this.studentToGroup = studentToGroup;
    }

    @GetMapping("/group")
    public AllStudentDto getAllStudent(){
        return studentToGroup.getAllStudent();
    }
}