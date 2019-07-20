package authentificationAOP;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SecurityClass {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SecurityConfig.class);
        SecurityManager securityManager = (SecurityManager)ctx.getBean("securityManager");
        SecureBean secureBean = getSecureBean(ctx);
        securityManager.login("John","psv");
        secureBean.writeSecureMessage();
        securityManager.logout();
    }

    private static SecureBean getSecureBean(ApplicationContext applicationContext){
        SecureBean target = (SecureBean)applicationContext.getBean("secureBean");
        SecurityAdvice securityAdvice = (SecurityAdvice)applicationContext.getBean("securityAdvice");
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(securityAdvice);

        SecureBean proxy = (SecureBean)proxyFactory.getProxy();
        return proxy;
    }

}
