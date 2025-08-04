package team8.ad.project.mapper.question;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team8.ad.project.entity.dto.QsInform;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<QsInform> viewQuestion(
        @Param("keyword") String keyword, 
        @Param("questionName") String questionName,
        @Param("grade") String grade,
        @Param("subject") String subject,
        @Param("topic") String topic,
        @Param("category") String category,
        @Param("offset") int offset,
        @Param("limit") int limit
    );

    int getTotalCount(
        @Param("keyword") String keyword,
        @Param("questionName") String questionName,
        @Param("grade") String grade,
        @Param("subject") String subject,
        @Param("topic") String topic,
        @Param("category") String category
    );
}