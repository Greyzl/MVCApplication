package com.flippedMadTracker.Task;

public class StandardOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProvider;
    @Override
    public void render() {
        if (messageProvider == null){
            throw new RuntimeException("You must set the \"\n" +
                    "+ \"property messageProvider of class:\"\n" +
                    "+ StandardOutMessageRenderer.class.getName() ");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
