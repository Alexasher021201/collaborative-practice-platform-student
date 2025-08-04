package team8.ad.project.controller.student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team8.ad.project.entity.dto.QsInform;
import team8.ad.project.entity.dto.QsResultDTO;
import team8.ad.project.entity.dto.SelectQuestionDTO;
import team8.ad.project.result.Result;
import team8.ad.project.service.question.QuestionService;

@RestController
@RequestMapping("/student")
@Api(tags = "题目相关接口")
@Slf4j
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/viewQuestion")
    @ApiOperation("查看题目（支持关键词和题目名称，带分页，可选指定第几题）")
    public Result<QsResultDTO<QsInform>> viewQuestion(
            @ApiParam(value = "搜索关键词", required = false) @RequestParam(required = false, defaultValue = "") String keyword,
            @ApiParam(value = "题目名称", required = false) @RequestParam(required = false, defaultValue = "") String questionName,
            @ApiParam(value = "年级", required = false) @RequestParam(required = false, defaultValue = "") String grade,
            @ApiParam(value = "学科", required = false) @RequestParam(required = false, defaultValue = "") String subject,
            @ApiParam(value = "主题", required = false) @RequestParam(required = false, defaultValue = "") String topic,
            @ApiParam(value = "分类", required = false) @RequestParam(required = false, defaultValue = "") String category,
            @ApiParam(value = "页码", required = true, defaultValue = "1") @RequestParam int page,
            @ApiParam(value = "当前页第几题(从0开始,非必要，-1表示返回整页)", required = false, defaultValue = "-1") @RequestParam(defaultValue = "-1") int questionIndex) {
        log.info("查看题目: keyword={}, questionName={}, grade={}, subject={}, topic={}, category={}, page={}, questionIndex={}", 
                keyword, questionName, grade, subject, topic, category, page, questionIndex);
        
        QsResultDTO<QsInform> dto = questionService.viewQuestion(keyword, questionName, grade, subject, topic, category, page, questionIndex);
        if (dto.getErrorMessage() != null) {
            return Result.error(dto.getErrorMessage());
        }
        return Result.success(dto);
    }

    @GetMapping("/doquestion")
    @ApiOperation("查看具体题目并做题")
    public Result<SelectQuestionDTO> selectQuestion(@ApiParam(value = "题目序号", required = true, defaultValue = "1") @RequestParam int id) {
        log.info("查看具体题目: id={}", id);
        SelectQuestionDTO dto = questionService.getQuestionById(id);
        if (dto == null) {
            return Result.error("题目不存在");
        }
        return Result.success(dto);
    }
    
}