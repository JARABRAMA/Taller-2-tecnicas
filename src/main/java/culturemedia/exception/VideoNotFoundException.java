package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CulturetecaException{
    public VideoNotFoundException(String title) {
        super(MessageFormat.format("Video not found: {0}", title));
    }
    public VideoNotFoundException() {
        super("any video not found");
    }
}
