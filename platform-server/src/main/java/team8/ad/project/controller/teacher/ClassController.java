package team8.ad.project.controller.teacher;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team8.ad.project.entity.dto.ClassDTO;
import team8.ad.project.result.Result;
import team8.ad.project.serivice.teacher.ClassService;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "Class-related interfaces")
@Slf4j
public class ClassController {

    @Autowired
    private ClassService classService;


    /**
     * Create a new class
     * @param classDTO
     * @return
     */
    @PostMapping
    @ApiOperation("Create Class")
    public Result createClass(@RequestBody ClassDTO classDTO){
        log.info("Create Class:{}", classDTO);
        classService.createClass(classDTO);
        return Result.success();
    }
}
