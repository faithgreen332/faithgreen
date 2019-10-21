package faithgreen.com.faithgreen.mapper;

import faithgreen.com.faithgreen.pojo.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component public interface SysUserMapperCustomer
{
    List<SysUser> queryUserSimplyInfoById(String id);
}
