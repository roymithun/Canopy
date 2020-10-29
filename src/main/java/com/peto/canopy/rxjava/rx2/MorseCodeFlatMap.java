package com.peto.canopy.rxjava.rx2;

import io.reactivex.Observable;

import static io.reactivex.Observable.empty;
import static io.reactivex.Observable.just;

public class MorseCodeFlatMap {
    public static void main(String[] args) {
        just('P', 'r', 'i', 'Y', 'a', 'n', 'k', 'a')
                .map(Character::toLowerCase)
                .flatMap(MorseCodeFlatMap::toMorseCode)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }

    // https://en.wikipedia.org/wiki/Morse_code
    static Observable<Sound> toMorseCode(char ch) {
        switch (ch) {
            case 'a':
                return just(Sound.DI, Sound.DAH);
            case 'b':
                return just(Sound.DAH, Sound.DI, Sound.DI, Sound.DI);
            case 'c':
                return just(Sound.DAH, Sound.DI, Sound.DAH, Sound.DI);
            case 'd':
                return just(Sound.DAH, Sound.DI, Sound.DI);
            case 'e':
                return just(Sound.DI);
            case 'f':
                return just(Sound.DI, Sound.DI, Sound.DAH, Sound.DI);
            case 'g':
                return just(Sound.DAH, Sound.DAH, Sound.DI);
            case 'h':
                return just(Sound.DI, Sound.DI, Sound.DI, Sound.DI);
            case 'i':
                return just(Sound.DI, Sound.DI);
            case 'j':
                return just(Sound.DI, Sound.DAH, Sound.DAH, Sound.DAH);
            case 'k':
                return just(Sound.DI, Sound.DAH, Sound.DI);
            case 'l':
                return just(Sound.DI, Sound.DAH, Sound.DI, Sound.DI);
            case 'm':
                return just(Sound.DAH, Sound.DAH);
            case 'n':
                return just(Sound.DAH, Sound.DI);
            case 'o':
                return just(Sound.DAH, Sound.DAH, Sound.DAH);
            case 'p':
                return just(Sound.DI, Sound.DAH, Sound.DAH, Sound.DI);
            case 'q':
                return just(Sound.DAH, Sound.DAH, Sound.DI, Sound.DAH);
            case 'r':
                return just(Sound.DI, Sound.DAH, Sound.DI);
            case 's':
                return just(Sound.DI, Sound.DI, Sound.DI);
            case 't':
                return just(Sound.DAH);
            case 'u':
                return just(Sound.DI, Sound.DI, Sound.DAH);
            case 'v':
                return just(Sound.DI, Sound.DI, Sound.DI, Sound.DAH);
            case 'w':
                return just(Sound.DI, Sound.DAH, Sound.DAH);
            case 'x':
                return just(Sound.DAH, Sound.DI, Sound.DI, Sound.DAH);
            case 'y':
                return just(Sound.DAH, Sound.DI, Sound.DAH, Sound.DAH);
            case 'z':
                return just(Sound.DAH, Sound.DAH, Sound.DI, Sound.DI);
            default:
                return empty();
        }
    }

    public enum Sound {
        DI, DAH
    }
}
