package faithgreen.com.faithgreen.utils;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>
{
}
