package faithgreen.com.faithgreen.controler;

import faithgreen.com.faithgreen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller public class ThymeleafController
{
    @RequestMapping("index") public String index(ModelMap map)
    {
        map.addAttribute("name", "faithgreen221");
        return "thymeleaf/index";
    }

    @RequestMapping("center") public String center()
    {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test") public String test(ModelMap map)
    {
        User u = new User();
        u.setName("faithJF");
        u.setAge(18);
        u.setPassword("faith");
        u.setBirthday(new Date());
        u.setDesc("<font color='green'><b>hello</b></font>");
        map.addAttribute("user", u);
        return "thymeleaf/center/test";
    }

    @PostMapping("postform") public String postform(User u){
        System.out.println(u.getName());
        return "redirect:test";
    }
}
