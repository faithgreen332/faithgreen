package faithgreen.com.faithgreen.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController @RequestMapping("async") public class DoAsync
{
    @Autowired private AsyncTask asyncTask;

    @RequestMapping("/async") public String async() throws Exception
    {
        long start = System.currentTimeMillis();
        Future<String> future11 = asyncTask.doTask11();
        Future<String> future22 = asyncTask.doTask22();
        Future<String> future33 = asyncTask.doTask33();
        while (!future11.isDone() || !future22.isDone() || !future33.isDone())
        {
            if (future11.isDone() && future22.isDone() && future33.isDone())
            {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String costTime = "task finished, cost: " + (end - start) + "ms";
        System.out.println(costTime);
        return costTime;
    }
}
