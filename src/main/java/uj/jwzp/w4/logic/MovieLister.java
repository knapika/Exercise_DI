package uj.jwzp.w4.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import uj.jwzp.w4.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieLister {

    @Autowired
    private MovieFinder finder;

    //public MovieLister() {
     //   this.finder = new CSVMovieFinder(environment.getProperty("fileName"));
    //}

    public List<Movie> moviesDirectedBy(String name) {
        List<Movie> allMovies = finder.findAll();
        return allMovies.stream()
                .filter(m -> m.getDirector().equals(name))
                .collect(Collectors.toList());
    }

}
