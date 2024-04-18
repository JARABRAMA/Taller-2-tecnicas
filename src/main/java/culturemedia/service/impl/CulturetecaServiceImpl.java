package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturetecaService;

import java.util.List;

public class CulturetecaServiceImpl implements CulturetecaService {
    private final VideoRepository videorepository;
    private final ViewsRepository viewsrepository;

    public CulturetecaServiceImpl(VideoRepository videorepository, ViewsRepository viewsrepository) {
        this.videorepository = videorepository;
        this.viewsrepository = viewsrepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videorepository.findAll();
        if (videorepository.findAll().isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public Video add(Video video) {
        return videorepository.add(video);
    }

    @Override
    public View add(View view) {
        return viewsrepository.add(view);
    }
}
