package authentificationAOP;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    @Autowired
    private SecurityManager securityManager;

    public SecurityAdvice(){
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedOnUser();

        if (userInfo == null){
            System.out.println("No user authenticated");
            throw new SecurityException("You need to login");
        }else if("John".equals(userInfo.getUserName())){
            System.out.println(userInfo.getUserName() + " have access");
        } else {
            throw new SecurityException("You are not allowed");
        }
    }
}
