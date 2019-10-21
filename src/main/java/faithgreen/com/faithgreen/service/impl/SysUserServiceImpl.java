package faithgreen.com.faithgreen.service.impl;

import com.github.pagehelper.PageHelper;
import faithgreen.com.faithgreen.mapper.SysUserMapper;
import faithgreen.com.faithgreen.mapper.SysUserMapperCustomer;
import faithgreen.com.faithgreen.pojo.SysUser;
import faithgreen.com.faithgreen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service public class SysUserServiceImpl implements IUserService
{
    @Autowired private SysUserMapper mapper;

    @Autowired private SysUserMapperCustomer userMapperCustom;

    @Override public void saveUser(SysUser user) throws Exception
    {
        mapper.insert(user);
    }

    @Override public void updateUser(SysUser user) throws Exception
    {
        mapper.updateByPrimaryKeySelective(user);
    }

    @Override public void deleteUser(String userId) throws Exception
    {
        mapper.deleteByPrimaryKey(userId);
    }

    @Override public SysUser querySysUser(String userId)
    {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override public List<SysUser> queryUserList(SysUser user)
    {
        return mapper.select(user);
    }

    @Override public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize)
    {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(user.getNickname()))
        {
            criteria.andLike("nickName", "%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> userList = mapper.selectByExample(example);
        return userList;
    }

    @Override public SysUser queryUserSimplyInfoById(String userId)
    {
        List<SysUser> userList = userMapperCustom.queryUserSimplyInfoById(userId);
        if (userList != null && !userList.isEmpty())
        {
            return userList.get(0);
        }
        return null;
    }
}
