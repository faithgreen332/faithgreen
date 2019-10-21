package faithgreen.com.faithgreen.controler;

import faithgreen.com.faithgreen.pojo.FaithJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("redis") public class RedisController
{
    @Autowired private StringRedisTemplate strRedis;

    @RequestMapping("/test") public FaithJsonResult test()
    {
        strRedis.opsForValue().set("faith-cache", "hello faith---");
        return FaithJsonResult.ok(strRedis.opsForValue().get("faith-cache"));
    }
}
