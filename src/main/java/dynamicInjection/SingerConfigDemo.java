package dynamicInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class SingerConfigDemo {

    @Configuration
    static class SingerConfig{

        @Lazy
        @Bean(initMethod = "init")
        SingerWithJSR250 singerOne(){
            SingerWithJSR250 singer = new SingerWithJSR250();
            singer.setAge(29);
            singer.setName("John Mayes");
            return singer;
        }
        @Lazy
        @Bean(initMethod = "init")
        SingerWithJSR250 singerTwo(){
            SingerWithJSR250 singer = new SingerWithJSR250();
            singer.setAge(50);
            return singer;
        }
        @Lazy
        @Bean(initMethod = "init")
        SingerWithJSR250 singerThree(){
            SingerWithJSR250 singer = new SingerWithJSR250();

            return singer;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);
        SingerWithJSR250.getBean("singerOne",ctx);
        SingerWithJSR250.getBean("singerTwo",ctx);
        SingerWithJSR250.getBean("singerThree",ctx);
    }
}
