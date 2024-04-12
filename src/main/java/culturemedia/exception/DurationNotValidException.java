package culturemedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturetecaException{
    public DurationNotValidException(String title, double duration) {
        super(MessageFormat.format("the title {0} with duratio {1} was not found", title, duration));
    }
}
