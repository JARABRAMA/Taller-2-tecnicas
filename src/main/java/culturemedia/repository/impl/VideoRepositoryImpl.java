package culturemedia.repository.impl;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;

import java.util.List;

public class VideoRepositoryImpl implements VideoRepository {
    @Override
    public List<Video> findAll() {
        return List.of();
    }

    @Override
    public Video add(Video video) {
        return null;
    }

    @Override
    public List<Video> find(String title) {
        return List.of();
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        return List.of();
    }
}
