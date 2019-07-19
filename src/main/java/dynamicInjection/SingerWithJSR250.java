package dynamicInjection;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("singerOne")
public class SingerWithJSR250 {
    private static final String DEFAULT_NAME = "John Mayer";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init() throws Exception{
        System.out.println("Initializing bean");

        if(name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("11 You must set 11\n" +
                    "+ 11 the age property of any beans of type 11 + SingerWithJSR250.class");
        }
    }

    @Override
    public String toString(){
        return "\tName: " + name + " \n\tAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation.xml");
        ctx.refresh();

        getBean("singerOne",ctx);
        ctx.close();

    }

    public static SingerWithJSR250 getBean(String beanName, ApplicationContext applicationContext){
        try {
            SingerWithJSR250 bean = (SingerWithJSR250)applicationContext.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e){
            System.out.println("Error while creating bean");
            return null;
        }
    }
}
