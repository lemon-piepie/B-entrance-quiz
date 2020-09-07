package com.thoughtworks.capability.gtb.entrancequiz.Service;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.AllStudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.Dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentToGroup {
    private int initId = 1;
    private String[] students = {
            "廖浚斌","沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇", "杨思雨",
            "江雨舟", "廖燊", "胡晓", "但杰", "盖迈达", "肖美琦",
            "黄云洁", "齐瑾浩", "刘亮亮", "肖逸凡", "王作文", "郭瑞凌",
            "李明豪", "党泽", "肖伊佐", "贠晨曦", "李康宁", "童世祁",
            "马庆", "商婕", "余榕", "谌哲", "董翔锐", "陈泰宇",
            "赵允齐", "张柯", "廖文强", "刘轲","岳港" ,"凌凤仪"};
    private List<String> initStudents = Arrays.asList(students);
    private static List<StudentDto> studentList = new ArrayList<>();

    public StudentToGroup(){
        initStudents();
    }

    private void initStudents(){
        studentList.clear();
        for (String initStudent : initStudents) {
            studentList.add(createAStudent(initStudent));
        }
    }

    private StudentDto createAStudent(String studentName){
        StudentDto theStudent = StudentDto.builder()
                                .id(initId++)
                                .name(studentName)
                                .build();
        return theStudent;
    }

    public static List<StudentDto> getAllStudent(){
        AllStudentDto allStudent = AllStudentDto.builder()
                                    .AllStudents(studentList)
                                    .build();
        return allStudent.getAllStudents();
    }

    public static List<StudentDto> addOneStudent(StudentDto newStudent){
        studentList.add(newStudent);
        return getAllStudent();
    }
}
