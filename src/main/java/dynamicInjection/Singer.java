package dynamicInjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {
    private String lyric = "I played а quick game of chess \n"
            + "with the salt and pepper shaker\n";
    public void sing(){

    }
}
