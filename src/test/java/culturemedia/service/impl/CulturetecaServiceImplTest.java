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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CulturetecaServiceImplTest {
    CulturetecaService culturetecaService;
    VideoRepository videoRepository;
    ViewsRepository viewsRepository;
    Video video ;
    View view;

    @BeforeEach
    void setUp() {
        video = new Video("123", "title", "description", 2);
        view = new View("Jhon Doe", LocalDate.now().atStartOfDay(), 23, video);
        viewsRepository = new ViewsRepositoryImpl();
        videoRepository = new VideoRepositoryImpl();
        culturetecaService = new CulturetecaServiceImpl(videoRepository, viewsRepository);
    }

    @Test
    void fid_all_exception() {
        assertThrows(VideoNotFoundException.class, () -> {
            culturetecaService.findAll();
        });
    }

    @Test
    void find_all() throws VideoNotFoundException {
        List<Video> expected = new ArrayList<>();
        expected.add(video);
        culturetecaService.add(video);
        List<Video> videos = culturetecaService.findAll();
        assertEquals(expected, videos);
    }
}