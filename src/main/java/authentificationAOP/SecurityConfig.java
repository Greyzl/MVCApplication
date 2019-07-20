package authentificationAOP;

import org.springframework.context.annotation.*;

@Configuration
public class SecurityConfig {

    @Bean
    @Scope("prototype")
    @Lazy
    SecurityManager securityManager(){
        return new SecurityManager();
    }

    @Bean
    @Lazy
    SecureBean secureBean(){
        return new SecureBean();
    }

    @Bean
    @Lazy
    @DependsOn(value = "securityManager")
    SecurityAdvice securityAdvice(){
        return new SecurityAdvice();
    }
}
