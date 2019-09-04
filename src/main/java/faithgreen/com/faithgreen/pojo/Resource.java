package faithgreen.com.faithgreen.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "com.faithgreen.resource")
@PropertySource(value = "classpath:resource.properties")
public class Resource
{
    @JsonProperty()
    private String name;
    private String love;
    private String language;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLove()
    {
        return love;
    }

    public void setLove(String love)
    {
        this.love = love;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
}
