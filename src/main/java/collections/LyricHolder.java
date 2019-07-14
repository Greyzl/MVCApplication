package collections;

import org.springframework.stereotype.Service;

@Service("lyricHolder")
public class LyricHolder implements ContentHolder {
    private String value = "You Ье the DJ, I'll Ье the driver";

    @Override
    public String toString() {
        return "LyricHolder: { " + value + "} ";
    }
}
