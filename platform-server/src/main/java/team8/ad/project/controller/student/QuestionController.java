package team8.ad.project.controller.student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team8.ad.project.service.question.QuestionService;
import team8.ad.project.entity.entity.Question;
import team8.ad.project.result.QsResult;

@RestController
@RequestMapping("/student/question")
@Api(tags = "题目相关接口")
@Slf4j
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/search")
    @ApiOperation("搜索题目（支持关键词和题目名称）")
    public QsResult<Question> searchQuestions(
            @ApiParam(value = "搜索关键词", required = false) @RequestParam(required = false, defaultValue = "") String keyword,
            @ApiParam(value = "题目名称", required = false) @RequestParam(required = false, defaultValue = "") String questionName,
            @ApiParam(value = "当前页码", required = true) @RequestParam(defaultValue = "1") int page,
            @ApiParam(value = "每页大小", required = true) @RequestParam(defaultValue = "10") int pageSize) {
        log.info("搜索题目: keyword={}, questionName={}, page={}, pageSize={}", keyword, questionName, page, pageSize);
        return questionService.searchQuestions(keyword, questionName, page, pageSize);
    }
}