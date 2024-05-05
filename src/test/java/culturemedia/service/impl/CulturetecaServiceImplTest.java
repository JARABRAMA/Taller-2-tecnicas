package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturetecaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class CulturetecaServiceImplTest {
    VideoRepository videoRepository = Mockito.mock();
    ViewsRepository viewsRepository = Mockito.mock();
    CulturetecaService culturetecaService = new CulturetecaServiceImpl(videoRepository, viewsRepository);
    List<Video> videos = List.of(
            new Video("01", "video 1", "a video", 3.4),
            new Video("02", "video 2", "a video", 4.4),
            new Video("03", "short 3", "a video", 5.4),
            new Video("04", "short 4", "a video", 6.0),
            new Video("05", "video 5", "a video", 2.1)
    );

    @Test
    void fid_all_exception() {
        assertThrows(VideoNotFoundException.class, () -> culturetecaService.findAll());
    }

    @Test
    void find_all() throws VideoNotFoundException {
        doReturn(videos).when(videoRepository).findAll();
        var target = videos.containsAll(culturetecaService.findAll());
        assertTrue(target);
    }

    @Test
    void find_by_title_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> culturetecaService.find("title"));
    }

    @Test
    void find_by_duration_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> culturetecaService.find(0.0, 5.0));
    }

    @Test
    void find_by_title_video() throws VideoNotFoundException {
        var parameter = "video";
        var expected = videos.stream().filter(p -> p.title().contains(parameter)).toList();
        doReturn(expected).when(videoRepository).find(parameter);
        var result = culturetecaService.find(parameter).containsAll(expected);
        assertTrue(result);
    }

    @Test
    void find_by_duration_video() throws VideoNotFoundException {
        var expected = videos.stream().filter(p -> p.duration() <= 5.0 && p.duration() >= 3.0).toList();
        doReturn(expected).when(videoRepository).find(3.0, 5.0);
        var target = culturetecaService.find(3.0, 5.0).containsAll(expected);
        assertTrue(target);
    }
}