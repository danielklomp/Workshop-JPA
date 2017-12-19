package nl.first8.hu.ticketsale.venue;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by danie on 19-12-2017.
 */

@RestController
@RequestMapping("/venue")
@Transactional
public class VenueResource {
    private final VenueService venueService;

    public VenueResource(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping(path = "/artistname/{artistname}")
    public Optional<List<Concert>> findConcertByArtistName(@PathVariable("artistName") final String artistName){
        return venueService.getConcertByName(artistName);
    }

    @GetMapping(path = "/genre/{genre}")
    public Optional<List<Concert>> findConcertByGenre(@PathVariable("genre") final String genre){
        return venueService.getConcertByGenre(genre);
    }

    @GetMapping(path = "/date/{date}")
    public Optional<List<Concert>> findConcertByDate(@PathVariable("date") final Date date){
        return venueService.getConcertByDate(date);
    }

    @GetMapping(path = "/location/{location}")
    public Optional<List<Concert>> findConcertByLocation(@PathVariable("location") final String location){
        return venueService.getConcertByLocation(location);
    }
}
