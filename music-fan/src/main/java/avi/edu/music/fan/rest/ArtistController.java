package avi.edu.music.fan.rest;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.artist.ArtistView;
import avi.edu.music.fan.rest.exception.ArtistNotFoundException;
import avi.edu.music.fan.service.ArtistService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return artistService.sayHello();
    }

    @RequestMapping("/{id}")
    @JsonView(ArtistView.class)
    public Artist getById(@PathVariable("id") String id) {
        return Optional.ofNullable(artistService.getById(id))
                .orElseThrow(() -> new ArtistNotFoundException("for id: " + id));
    }
}
