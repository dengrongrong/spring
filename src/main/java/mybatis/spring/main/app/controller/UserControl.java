package mybatis.spring.main.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserControl {

    @RequestMapping(value="index",method= RequestMethod.GET)
    public ModelAndView visitIndex(){
        ModelAndView view=new ModelAndView("index");
        return view;
    }

    @RequestMapping(value="dataSource",method= RequestMethod.GET)
    public ModelAndView getDataSource(){
        ModelAndView view=new ModelAndView("dataSource_props");
        view.addObject("name","666");
        return view;
    }
}
