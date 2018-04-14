package ru.itis.affection.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestDto {
    private String name;
    private String status;
    private List<TestDetailDto> testDetailsDto;
}
