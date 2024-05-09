package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CulturetecaService;

import java.util.List;

public class CulturetecaServiceImpl implements CulturetecaService {
    private final VideoRepository videorepository;
    private final ViewsRepository viewsrepository;

    public CulturetecaServiceImpl(VideoRepository videorepository, ViewsRepository viewsrepository) {
        this.videorepository = videorepository;
        this.viewsrepository = viewsrepository;
    }
    public CulturetecaServiceImpl(){
        this.videorepository = new VideoRepositoryImpl();
        this.viewsrepository = new ViewsRepositoryImpl();
    }

    public List<Video> find(String title) throws VideoNotFoundException {
        if (videorepository.find(title).isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videorepository.find(title);
    }

    public List<Video> find(Double from, Double to) throws VideoNotFoundException {
        if (videorepository.find(from, to).isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videorepository.find(from, to);
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
