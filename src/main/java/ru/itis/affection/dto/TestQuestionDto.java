package ru.itis.affection.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestQuestionDto {
    private String question;
    private String friendImg;
    private String teacherImg;
    private Boolean isEnd;
}
