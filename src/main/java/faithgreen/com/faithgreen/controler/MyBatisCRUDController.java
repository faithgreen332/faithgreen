package faithgreen.com.faithgreen.controler;

import faithgreen.com.faithgreen.pojo.FaithJsonResult;
import faithgreen.com.faithgreen.pojo.SysUser;
import faithgreen.com.faithgreen.service.IUserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController @RequestMapping("mybatis") public class MyBatisCRUDController
{
    @Autowired private IUserService userService;

    @Autowired private Sid sid;

    @RequestMapping("/saveUser") @Transactional(propagation = Propagation.REQUIRED)
    public FaithJsonResult saveUser() throws Exception
    {
        String userId = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("faithgreen" + new Date());
        user.setNickname("faith" + new Date());
        user.setPassword("123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.saveUser(user);
        return FaithJsonResult.ok("save user ok");
    }

    @RequestMapping("/deleteUserById") @Transactional(propagation = Propagation.REQUIRED)
    public FaithJsonResult deleteUser() throws Exception
    {
        userService.deleteUser("1001");
        return FaithJsonResult.ok("delete user by Id 1001 ok");
    }

    @RequestMapping("/updateUser") @Transactional(propagation = Propagation.REQUIRED)
    public FaithJsonResult updateUser() throws Exception
    {
        SysUser user = new SysUser();
        user.setId("1001");
        user.setUsername("kawakaminanami");
        user.setNickname("asukakirara");
        user.setPassword("aaasss");
        userService.updateUser(user);
        return FaithJsonResult.ok("update user ok");
    }

    @RequestMapping("/queryUserPaged") @Transactional(propagation = Propagation.REQUIRED)
    public FaithJsonResult queryUserPaged(Integer page, Integer pageSize)
    {
        if (page == null)
        {
            page = 1;
        }
        SysUser user = new SysUser();
        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
        return FaithJsonResult.ok(userList);
    }

    @RequestMapping("/queryUserById") @Transactional(propagation = Propagation.REQUIRED)
    public FaithJsonResult queryUserSimplyInfoById(String userId)
    {
        SysUser user = userService.queryUserSimplyInfoById(userId);
        return FaithJsonResult.ok(user);
    }
}
