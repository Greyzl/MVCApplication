package dynamicInjection;


import org.springframework.stereotype.Component;

@Component
public class Guitar {
    public void sing(){
        System.out.println("Cm ЕЬ Fm АЬ ВЬ");
    }
}
