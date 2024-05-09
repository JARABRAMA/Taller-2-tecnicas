package culturemedia.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturetecaService;
import culturemedia.service.impl.CulturetecaServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {
    private static final Logger log = LogManager.getLogger();
    private final CulturetecaService cultureMediaService;


    public CultureMediaController() {
        this.cultureMediaService = new CulturetecaServiceImpl();
    }

    @GetMapping(value = "/video")
    public ResponseEntity<List<Video>> findAllVideos(){
        try {
            return ResponseEntity.ok().body(cultureMediaService.findAll());
        } catch (VideoNotFoundException e) {
            log.error("Any video not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Error-Message", e.getMessage()).body(Collections.emptyList());
        }
    }

    @PostMapping( value = "/video")
    public Video save(@RequestBody Video video){
        return cultureMediaService.add(video);
    }
}