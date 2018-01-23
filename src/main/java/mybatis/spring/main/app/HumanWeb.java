package mybatis.spring.main.app;

import mybatis.spring.main.app.entity.Human;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/human")
public class HumanWeb {

    @RequestMapping("/create")
    @ResponseBody
    public List<Human> createHuman(@RequestBody Map<String,Integer> param){

        List<Human> list=new ArrayList<Human>();
        int number=param.get("num");
        Human h=null;
        for(int i=0;i<number;i++){
            h=new Human(i,"human_"+i,"170"+i);
            list.add(h);
        }
        for(Human hm:list){
            System.out.println(hm);
        }
        return list;
    }

    @RequestMapping("/createHuman")
    @ResponseBody
    public Human createHuman(){

        Human h=new Human();
        h.setId(1);h.setName("xy");h.setHeight("145");
        System.out.println(h);
        return h;
    }

    public static void main(String[] args) {
        Map<String,Integer> param=new HashMap<String, Integer>();
        param.put("num",10);
//        createHuman(param);
    }
}
