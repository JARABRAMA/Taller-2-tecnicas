package culturemedia.controller;

import java.util.Collections;
import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturetecaService;
import culturemedia.service.impl.CulturetecaServiceImpl;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/videos")
public class CultureMediaController {
    private static final Logger log = LogManager.getLogger();
    private final CulturetecaService cultureMediaService;


    public CultureMediaController() {
        this.cultureMediaService = new CulturetecaServiceImpl();
    }

    @GetMapping
    public ResponseEntity<List<Video>> findAllVideos(){
        try {
            return ResponseEntity.ok().body(cultureMediaService.findAll());
        } catch (VideoNotFoundException e) {
            log.error("Any video not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Error-Message", e.getMessage()).body(Collections.emptyList());
        }
    }

    @PostMapping
    public ResponseEntity<Video> save(@RequestBody @Valid Video video) {
        var result = cultureMediaService.add(video);
        log.info("input class: {}", video.toString());
        if (result == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(result);
    }
}