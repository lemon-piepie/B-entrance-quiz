package com.thoughtworks.capability.gtb.entrancequiz.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String name;
}
