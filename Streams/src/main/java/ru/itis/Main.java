package ru.itis;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(final String[] args) {
        List<Artist> artists = Arrays.asList(
                new Artist("British", "Ricky Martin"),
                new Artist("Germany", "Til Linderman"),
                new Artist("Russia", "Gagarina"),
                new Artist("British", "Placebo"),
                new Artist("British", "Beatles"),
                new Artist("Russia", "Shnur"),
                new Artist("British", "Depeche Mode"),
                new Artist("Russia", "Ranetki"));


        long count = artists.stream()
                .filter(artist -> {
                    boolean result = artist.isFrom("British");
                    System.out.println("Hello");
                    return result;
                }).count();

        List<Artist> collected = artists.stream()
                .filter(artist -> artist.isFrom("British"))
                .map(artist -> new Artist(artist.getName(), artist.getFrom()))
                .collect(toList());

        System.out.println(collected);

        Artist minNameArtist =
                artists.stream()
                .min(comparing(artist -> artist.getName().length()))
                .get();

        int sumLength = Stream.of("Marsel", "Vika", "Denis", "Ayaz", "Marat",
        "Artur", "Ayvar", "Robert")
                .mapToInt(String::length)
                .reduce(0, (accumulator, element) -> accumulator + element);
        System.out.println(sumLength);
        /*
        for (Artist artist : artists) {
            if (artist.isFrom("British")) {
                count++;
            }
        }

        Iterator<Artist> iterator = artists.iterator();
        while (iterator.hasNext()) {
            Artist currentArtist = iterator.next();
            if (currentArtist.isFrom("British")) {
                count++;
            }
        }
        */



    }
}
