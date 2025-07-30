package team8.ad.project.mapper.teacher;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team8.ad.project.entity.entity.Class;
import java.util.List;

@Mapper
public interface ClassMapper {


    /**
     * Create class
     * @param newClass
     */
    void insert(Class newClass);


    /**
     * Query all class
     * @return
     */
    @Select("select * from class")
    List<Class> selectAll();

}
