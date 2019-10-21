package faithgreen.com.faithgreen.controler;

import faithgreen.com.faithgreen.pojo.FaithJsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller @RequestMapping("/error") public class ErrorControler
{
    @RequestMapping("mathError") public Object mathError()
    {
        int a = 1 / 0;
        return a;
    }

    @RequestMapping("getAjaxError") @ResponseBody public FaithJsonResult getAjaxError()
    {
        int a = 1 / 0;
        return FaithJsonResult.ok();
    }

    @RequestMapping("ajaxError") public String ajaxError()
    {
        return "thymeleaf/ajaxError";
    }
}
