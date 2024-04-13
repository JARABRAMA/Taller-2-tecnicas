package culturemedia.service.impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturetecaService;

import java.util.List;

public class CulturetecaServiceImpl implements CulturetecaService {
    private VideoRepository videorepository;
    private ViewsRepository viewsrepository;

    @Override
    public List<Video> findAll() {
        return videorepository.findAll();
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
