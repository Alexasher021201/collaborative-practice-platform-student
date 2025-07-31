package team8.ad.project.service.teacher.impl;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team8.ad.project.entity.dto.ClassDTO;
import team8.ad.project.mapper.teacher.ClassMapper;
import team8.ad.project.service.teacher.ClassService;
import team8.ad.project.entity.entity.Class;

@Service
public class ClassServiceImpl implements ClassService {


    @Autowired
    ClassMapper classMapper;

    /**
     *Create a new Class
     * @param classDTO
     */
    @Override
    public void createClass(ClassDTO classDTO) {

        Class myClass = new Class();
        BeanUtils.copyProperties(classDTO, myClass);
        classMapper.insert(myClass);

    }
}
