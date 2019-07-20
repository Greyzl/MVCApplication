package javaconfiguration.logic.Renderer;

import javaconfiguration.logic.Provider.MessageProvider;

public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider provider;

    public StandardOutMessageRenderer(){
        System.out.println("--> StandardOutMessageRenderer:\n" +
                "constructor called");
    }

    @Override
    public void render() {
        if (provider == null){
            throw new RuntimeException("You must set the \"\n" +
                    "+ \"property messageProvider of class:\"\n" + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(provider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        System.out.println(" --> StandardOutMessageRenderer: setting the provider");
        this.provider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return provider;
    }
}
