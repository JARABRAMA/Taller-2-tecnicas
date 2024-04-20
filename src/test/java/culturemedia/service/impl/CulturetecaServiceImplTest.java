package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CulturetecaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CulturetecaServiceImplTest {
    CulturetecaService culturetecaService;
    VideoRepository videoRepository;
    ViewsRepository viewsRepository;
    Video video ;
    List<Video> videos = List.of(
            new Video("01", "video 1", "a video", 3.4),
            new Video("02", "video 2", "a video", 4.4),
            new Video("03", "short 3", "a video", 5.4),
            new Video("04", "short 4", "a video", 6.0),
            new Video("05", "video 5", "a video", 2.1)
        );
    View view;

    @BeforeEach
    void setUp() {
        viewsRepository = new ViewsRepositoryImpl();
        videoRepository = new VideoRepositoryImpl();
        culturetecaService = new CulturetecaServiceImpl(videoRepository, viewsRepository);
    }

    private void fillVideos(){
        videos.stream().forEach(video -> culturetecaService.add(video));
    }

    @Test
    void fid_all_exception() {
        assertThrows(VideoNotFoundException.class, () -> {
            culturetecaService.findAll();
        });
    }

    @Test
    void find_all() throws VideoNotFoundException {
        fillVideos();
        boolean target = culturetecaService.findAll().containsAll(videos); 
        assertTrue(target);
    }

    @Test
    void find_by_title_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> {culturetecaService.find("title");});
    }

    @Test
    void find_by_duration_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> {culturetecaService.find(0.0, 5.0);});
    }

    @Test
    void find_by_title_video() throws VideoNotFoundException {
        fillVideos();
        List<Video> expected = videos.stream().filter(video -> video.title().contains("video")).toList();
        boolean target = culturetecaService.find("video").containsAll(expected); 
        assertTrue(target);
    }

    @Test
    void find_by_duration_video() throws VideoNotFoundException {
        fillVideos();
        List<Video> expected = videos.stream().filter(p -> p.duration() <= 5.0 && p.duration() >= 3.0).toList(); 
        boolean target = culturetecaService.find(3.0, 5.0).containsAll(expected);
        assertTrue(target);
    }
}