package team8.ad.project.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team8.ad.project.mapper.question.QuestionMapper;
import team8.ad.project.entity.entity.Question;
import team8.ad.project.result.QsResult;

import java.util.List;

import javax.naming.directory.SearchResult;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public QsResult<Question> searchQuestions(String keyword, String questionName, int page, int pageSize) {
        QsResult<Question> result = new QsResult<>();
        try {
            int offset = (page - 1) * pageSize;
            List<Question> items = questionMapper.searchQuestions(keyword, questionName, offset, pageSize);
            int totalCount = questionMapper.countQuestions(keyword, questionName);
            result.setItems(items);
            result.setTotalCount(totalCount);
            result.setPage(page);
            result.setPageSize(pageSize);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }
}