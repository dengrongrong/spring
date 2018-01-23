package mybatis.spring.main.app.service;

import mybatis.spring.main.app.entity.Human;
import mybatis.spring.main.app.mapper.HumanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Component
public class HumanService {

    @Autowired(required = false)
    HumanMapper humanMapper;

    public Human getHumanById(Integer id){

        Human human=humanMapper.selectHumanById(id);
        return human;
    }

}
