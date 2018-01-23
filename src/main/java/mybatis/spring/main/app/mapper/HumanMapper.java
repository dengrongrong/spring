package mybatis.spring.main.app.mapper;

import mybatis.spring.main.app.entity.Human;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface HumanMapper {

    public Human selectHumanById(Integer id);
}
