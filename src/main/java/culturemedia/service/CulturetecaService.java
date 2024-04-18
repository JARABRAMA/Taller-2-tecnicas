package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturetecaService {
    List<Video> findAll() throws VideoNotFoundException;
    Video add(Video video);
    View add(View view);
}
