package javaconfiguration.config;

import javaconfiguration.logic.Provider.MessageProvider;
import javaconfiguration.logic.Renderer.MessageRenderer;
import javaconfiguration.logic.Renderer.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "/javaconfiguration")
@PropertySource(value = "classpath:messages.properties")
public class AppConfigTwo {

    @Autowired
    Environment environment;

    @Autowired
    MessageProvider messageProvider;


    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        return messageRenderer;

    }
}
