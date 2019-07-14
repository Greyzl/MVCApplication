package dynamicInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation.xml");
        ctx.refresh();
        DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);

        displayInfo("abstractLookupBean",abstractBean);
        displayInfo("standardLookupBean",standardBean);
    }
    public static void displayInfo(String beanName, DemoBean bean){
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();

        System.out.println(""+ beanName + ": "
        + "Singer instances the same? "+
                (singer1 == singer2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int х = 0; х < 100000; х++) {
            Singer singer = bean.getMySinger();
            singer.sing();
        }
        stopWatch.stop();
        System.out.println("lOOOOO gets took "
                + stopWatch.getTotalTimeMillis() + "ms");
    }
}
