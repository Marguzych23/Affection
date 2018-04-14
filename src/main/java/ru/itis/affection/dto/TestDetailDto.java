package ru.itis.affection.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDetailDto {

    private String question;
    private String answer;
}
