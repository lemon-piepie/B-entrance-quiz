package com.thoughtworks.capability.gtb.entrancequiz.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllStudentDto {
    List<StudentDto> AllStudents;
}
