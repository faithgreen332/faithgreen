package faithgreen.com.faithgreen.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorDisplay
{
    public void generator() throws Exception
    {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        System.out.println(
                this.getClass().getClassLoader().getResource("") + "generatorConfiguration.xml");
//        System.out.println(
//                "Thread.currentThread().getContextClassLoader().getResource(\"\").getPath()\n:  "
//                        + "                       +Thread.currentThread().getContextClassLoader().getResource(\"/\").getPath()\n");
//        System.out.println(this.getClass().getResource("/").getPath());
//        System.out.println(this.getClass().getResource("").getPath());
//        System.out.println(System.getProperty("java.class.path"));
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(new File("").getCanonicalPath());
        File configFile = new File("generatorConfiguration.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception
    {
        GeneratorDisplay generatorDisplay = new GeneratorDisplay();
        generatorDisplay.generator();
    }
}
