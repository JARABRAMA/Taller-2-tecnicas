package culturemedia.controller;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.impl.CulturetecaServiceImpl;

import java.util.List;

public class CulturemediaController {
    private final CulturetecaServiceImpl culturetecaService;
    public CulturemediaController(CulturetecaServiceImpl culturetecaService) {
        this.culturetecaService = culturetecaService;
    }
    public List<Video> findAllVideos() throws VideoNotFoundException {
        return culturetecaService.findAll();
    }
}
