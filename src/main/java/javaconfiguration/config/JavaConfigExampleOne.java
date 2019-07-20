package javaconfiguration.config;

import javaconfiguration.logic.Provider.MessageProvider;
import javaconfiguration.logic.Renderer.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleOne {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigOne.class);

        MessageRenderer messageRenderer = (MessageRenderer)ctx.getBean("messageRenderer");
        messageRenderer.render();
    }
}
