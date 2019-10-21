package faithgreen.com.faithgreen.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask
{
    @Async
    public Future<String> doTask11() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println("task11 cost: "+(System.currentTimeMillis()-start));
        return new AsyncResult<>("1000");
    }

    @Async
    public Future<String> doTask22() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        System.out.println("task11 cost: "+(System.currentTimeMillis()-start));
        return new AsyncResult<>("500");
    }

    @Async
    public Future<String> doTask33() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(400);
        System.out.println("task11 cost: "+(System.currentTimeMillis()-start));
        return new AsyncResult<>("400");
    }
}
