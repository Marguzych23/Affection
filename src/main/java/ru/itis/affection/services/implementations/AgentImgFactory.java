package ru.itis.affection.services.implementations;

public class AgentImgFactory {

    public static String getFriendImg(String friendType, boolean isRightAnswer) {
        String emotion = isRightAnswer ? "pleasant" : "unpleasant";
        return "img/" + friendType + "/" + emotion + ".jpg";
    }

    public static String getTeacherImg(String teacherType, boolean isRightAnswer) {
        String emotion;
        if (teacherType.equalsIgnoreCase("none")) {
            emotion = isRightAnswer ? "kind" : "evil";
        } else {
            emotion = teacherType;
        }
        return "img/" + emotion + ".jpg";
    }
}
