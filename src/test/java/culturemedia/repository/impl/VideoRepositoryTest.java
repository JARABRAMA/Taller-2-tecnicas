package culturemedia.repository.impl;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoRepositoryTest {
    private VideoRepository videoRepository;

    @BeforeEach
    void setUp() {
        videoRepository = new VideoRepositoryImpl();
    }

    @Test
    void getAllVideos() {
        List<Video> videos = videoRepository.findAll();
        List<Video> expectedVideos = new ArrayList<>();
        assertEquals(expectedVideos, videos);
    }

    @Test
    void add() {
        Video video = new Video("1234", "title", "description", 2.5);
        Video result = videoRepository.add(video);
        assertEquals(video, result);
    }



    @Test
    void searchByDuration() {
        List<Video> videos = videoRepository.find(1.0, 3.0);
        List<Video> expectedVideos = new ArrayList<>(); // at this moment the expected list will be void
        assertEquals(expectedVideos, videos);
    }
}