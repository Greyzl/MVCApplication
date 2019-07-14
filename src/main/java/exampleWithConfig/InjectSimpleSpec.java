package exampleWithConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpec")
public class InjectSimpleSpec {


    @Value("#{injectSimpleConfig.name}")
    private String name;
    @Value("#{injectSimpleConfig.age}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;

    @Override
    public String toString() {
        return "Name: "
                + name + "\n"
                + "Age: " + age + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctxt = new GenericXmlApplicationContext("app-context-annotation.xml");

        InjectSimpleSpec simpleSpec = (InjectSimpleSpec)ctxt.getBean("injectSimpleSpec");
        System.out.println(simpleSpec);
    }
}
