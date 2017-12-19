package nl.first8.hu.ticketsale.venue;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by danie on 19-12-2017.
 */

@Service
public class VenueService {


    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }


    public Optional<List<Concert>> getConcertByName(String nameArtist){

        return venueRepository.findConcertByName(nameArtist);
    }

    public Optional<List<Concert>> getConcertByGenre(String genre){
        return venueRepository.findConcertByGenre(genre);
    }

    public Optional<List<Concert>> getConcertByDate(Date date){
        return venueRepository.findConcertByDate(date);
    }

    public Optional<List<Concert>> getConcertByLocation(String location){

        Location location2 = venueRepository.findLocationByName(location);
        return venueRepository.findConcertByLocation(location2);
    }

}
