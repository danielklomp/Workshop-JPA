package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by danie on 13-12-2017.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "artist_name")
    private String name;

    @Column(name = "Genre")
    private Genre genre;

    @OneToMany(mappedBy = "artist")
    private List<Concert> concert;

    public Artist(String name, Genre genre){
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
}

