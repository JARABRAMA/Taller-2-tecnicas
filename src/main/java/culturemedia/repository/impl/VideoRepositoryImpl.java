package culturemedia.repository.impl;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;

public class VideoRepositoryImpl implements VideoRepository {
    private static final List<Video> videos = new ArrayList<>();

    @Override
    public List<Video> findAll() {
        return videos;
    }

    @Override
    public Video add(Video video) {
        if(videos.add(video)){
            return video;
        }
        return null;
    }

    @Override
    public List<Video> find(String title) {
        return findAll().stream().filter(video -> video.title().contains(title)).toList();
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        return findAll().stream().filter(video -> video.duration() >= fromDuration && video.duration() <= toDuration).toList();
    }
}
