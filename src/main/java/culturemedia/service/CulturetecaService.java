package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturetecaService {
    List<Video> findAll();
    Video add(Video video);
    View add(View view);
}
