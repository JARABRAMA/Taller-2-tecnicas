package culturemedia.controller;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturetecaService;
import culturemedia.service.impl.CulturetecaServiceImpl;

public class CultureMediaController {

    private final CulturetecaService cultureMediaService;

    public CultureMediaController(CulturetecaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public List<Video> findAllVideos() throws VideoNotFoundException {
        return cultureMediaService.findAll();
    }
}