package faithgreen.com.faithgreen.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component public class TestTask
{
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000) public void reportCurrentTime()
    {
        System.out.println("time is :" + dataFormat.format(new Date()));
    }
}
