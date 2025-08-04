package team8.ad.project.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team8.ad.project.entity.dto.QsResultDTO;
import team8.ad.project.entity.dto.QsInform;
import team8.ad.project.entity.entity.Question;
import team8.ad.project.mapper.question.QuestionMapper;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    private static final int PAGE_SIZE = 10; // 每页10个题目

    public QsResultDTO<QsInform> viewQuestion(String keyword, String questionName, String grade, String subject, String topic, String category, int page, int questionIndex) {
        QsResultDTO<QsInform> result = new QsResultDTO<>();
        try {
            // 计算偏移量，page 从 1 开始
            int offset = (page - 1) * PAGE_SIZE;
            // 获取分页数据
            List<QsInform> items = questionMapper.viewQuestion(keyword, questionName, grade, subject, topic, category, offset, PAGE_SIZE);
            int totalCount = questionMapper.getTotalCount(keyword, questionName, grade, subject, topic, category);

            // 根据 questionIndex 决定返回数据
            if (questionIndex == -1) {
                result.setItems(items); // 返回整页数据
            } else if (questionIndex >= 0 && questionIndex < items.size()) {
                result.setItems(List.of(items.get(questionIndex))); // 只返回指定题
            } else {
                result.setItems(List.of()); // 无效索引返回空列表
                result.setErrorMessage("无效的 questionIndex，超出当前页范围");
                return result;
            }

            result.setTotalCount(totalCount);
            result.setPage(page);
            result.setPageSize(PAGE_SIZE);
        } catch (Exception e) {
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }
}