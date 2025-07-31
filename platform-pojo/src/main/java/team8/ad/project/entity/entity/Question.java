// src/main/java/team8/ad/project/vo/Question.java
package team8.ad.project.entity.entity;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private byte[] image; // 可能需要修改
    private String question;
    private String choices; // JSON 字符串
    private Integer answer;
    private String hint;
    private String task;
    private String grade;
    private String subject;
    private String topic;
    private String category;
    private String skill;
    private String lecture;
    private String solution;
}