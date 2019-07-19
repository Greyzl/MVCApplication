package dynamicInjection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Singer implements ApplicationContextAware {
    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private String lyric = "I played а quick game of chess \n"
            + "with the salt and pepper shaker\n";
    private Guitar guitar;
    public void sing(){
        guitar = applicationContext.getBean("guitar",Guitar.class);
        guitar.sing();
    }
}
