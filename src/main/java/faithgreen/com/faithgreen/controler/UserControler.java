package faithgreen.com.faithgreen.controler;

import faithgreen.com.faithgreen.pojo.FaithJsonResult;
import faithgreen.com.faithgreen.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserControler
{
    @RequestMapping("/getUser") public User getUser()
    {
        User u = new User();
        u.setAge(18);
        u.setBirthday(new Date());
        u.setDesc("user user");
        return u;
    }

    @RequestMapping("/getUserByJson") public FaithJsonResult getUserByJson()
    {
        User u = new User();
        u.setName("lijinfe");
        u.setPassword("faith123");
        u.setAge(18);
        u.setBirthday(new Date());
//        u.setDesc("user user");

        return FaithJsonResult.ok(u);
    }
}
