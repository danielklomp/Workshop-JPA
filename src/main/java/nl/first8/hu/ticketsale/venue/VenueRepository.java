package nl.first8.hu.ticketsale.venue;

import nl.first8.hu.ticketsale.sales.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

    private final EntityManager entityManager;

    @Autowired
    public VenueRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Concert> findConcertById(Long concertId) {
        return Optional.ofNullable(entityManager.find(Concert.class, concertId));
    }

    public Optional<List<Concert>> findConcertByName(String nameArtist){
        try {
            return Optional.of(entityManager.createQuery("SELECT s FROM Concert s WHERE s.artist =:nameArtist", Concert.class)
                    .setParameter("artist", nameArtist).getResultList());
        } catch (NoResultException ex) {
            return Optional.empty();
        }

    }

    public Optional<List<Concert>> findConcertByGenre(String genre){
        try {
            return Optional.of(entityManager.createQuery("SELECT s FROM Concert s WHERE s.genre =:genre", Concert.class)
                    .setParameter("genre", genre).getResultList());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    public Optional<List<Concert>> findConcertByDate(Date date){
        try {
            return Optional.of(entityManager.createQuery("SELECT s FROM Concert s WHERE s.date =:date", Concert.class)
                    .setParameter("date", date)
                    .getResultList());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    public Location findLocationByName(String name){

        return entityManager.createQuery("SELECT s FROM Location s WHERE s.name =:name", Location.class)
                .setParameter("name", name)
                .getSingleResult();

    }

    public Optional<List<Concert>> findConcertByLocation(Location location){

        try {
            return Optional.of(entityManager.createQuery("SELECT s FROM Concert s WHERE s.location =:location", Concert.class)
                    .setParameter("location", location)
                    .getResultList());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

}
