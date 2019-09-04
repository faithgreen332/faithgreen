package faithgreen.com.faithgreen.controler;

import faithgreen.com.faithgreen.pojo.FaithJsonResult;
import faithgreen.com.faithgreen.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler
{
    @Autowired
    private Resource resource;
    @RequestMapping("/hello")
    public Object hello(){
        return "Hello faithgreen!";
    }

    @RequestMapping(value = "/getResource",produces = "application/json;charset=utf-8")
    public FaithJsonResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return FaithJsonResult.ok(bean);
    }
}
