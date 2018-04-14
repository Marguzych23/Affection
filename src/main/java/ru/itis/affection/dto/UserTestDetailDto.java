package ru.itis.affection.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.affection.models.Test;

import java.util.Date;

@Data
@Builder
public class UserTestDetailDto {

    private Long userId;
    private TestDto testDto;
    private String teacherType;
    private String friendType;
    private Integer questionNumber;
    private Integer rightAnswerNumber;
    private Boolean lastAnswerIsRight;
}
