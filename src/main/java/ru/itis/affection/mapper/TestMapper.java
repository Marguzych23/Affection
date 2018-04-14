package ru.itis.affection.mapper;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import ru.itis.affection.dto.TestQuestionDto;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestMapper {

    public String getTest(TestQuestionDto testQuestionDto) {

        Map<String, Object> map = new HashMap<>();

        if (testQuestionDto.getIsEnd()) {
            map.put("isEnd", true);
        } else {
            map.put("teacher", testQuestionDto.getTeacherImg());
            map.put("friend", testQuestionDto.getFriendImg());
            map.put("question", testQuestionDto.getQuestion());
            map.put("isEnd", false);
        }


        return new Gson().toJson(map);
    }
}
