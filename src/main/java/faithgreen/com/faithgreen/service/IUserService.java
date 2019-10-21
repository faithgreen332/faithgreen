package faithgreen.com.faithgreen.service;

import faithgreen.com.faithgreen.pojo.SysUser;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService
{
    void saveUser(SysUser user) throws Exception;

    void updateUser(SysUser user) throws Exception;

    void deleteUser(String userId) throws Exception;

    SysUser querySysUser(String userId);

    List<SysUser> queryUserList(SysUser user);

    @Transactional(propagation = Propagation.SUPPORTS) List<SysUser> queryUserListPaged(
            SysUser user, Integer page, Integer pageSize);

    SysUser queryUserSimplyInfoById(String userId);
}
