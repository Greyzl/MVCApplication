package javaconfiguration.logic.Provider;

import javaconfiguration.logic.Provider.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "default message";

    public ConfigurableMessageProvider(){

    }

    public ConfigurableMessageProvider(@Value("Jopa")String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
