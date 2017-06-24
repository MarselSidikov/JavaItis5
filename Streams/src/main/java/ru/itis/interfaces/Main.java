package ru.itis.interfaces;

import ru.itis.Artist;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Created by admin on 24.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        Function<Artist, Artist> replace = artist -> new Artist(artist.getName(), artist.getFrom());
        Artist ricky = new Artist("Puerto  Ricko", "Ricky Martin");
        Artist newRicky = replace.apply(ricky);

        Predicate<Artist> from = artist -> artist.isFrom("British");
        System.out.println(from.test(ricky));

        Consumer<Artist> printer = artist -> System.out.println(artist.getFrom());
        printer.accept(ricky);
    }
}
