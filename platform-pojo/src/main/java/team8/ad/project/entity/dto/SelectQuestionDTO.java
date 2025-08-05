package team8.ad.project.entity.dto;
import lombok.Data;

@Data
public class SelectQuestionDTO {
    private Integer id;
    private byte[] image; // 或 String，如果存储路径
    private String question;
    private String choices; // JSON 字符串
    private Integer answer;
}
