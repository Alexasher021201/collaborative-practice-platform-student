package team8.ad.project.mapper.question;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team8.ad.project.entity.entity.Question;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<Question> searchQuestions(@Param("keyword") String keyword, @Param("questionName") String questionName, @Param("offset") int offset, @Param("pageSize") int pageSize);
    int countQuestions(@Param("keyword") String keyword, @Param("questionName") String questionName);
}