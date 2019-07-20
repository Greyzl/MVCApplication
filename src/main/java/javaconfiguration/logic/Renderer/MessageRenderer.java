package javaconfiguration.logic.Renderer;

import javaconfiguration.logic.Provider.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
