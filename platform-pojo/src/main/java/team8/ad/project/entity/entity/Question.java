package team8.ad.project.entity.entity;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private byte[] image; // 或 String，如果存储路径
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