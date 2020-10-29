package com.peto.canopy.rxjava.rx2;

import io.reactivex.Maybe;
import io.reactivex.Observable;

import org.apache.commons.lang3.tuple.Pair;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class PlayGround {
    public static void main(String[] args) {
        testConversation();
    }

    public static void testDelayWithTimer() {
        Observable.just("Mango", "Banana", "Strawberry", "Coconut", "Date", "Peach")
                .delay(word -> Observable.timer(word.length(), TimeUnit.SECONDS))
                .subscribe(System.out::println, Throwable::printStackTrace);

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testTimerWithFlatMap() {
        Observable.just("Mango", "Banana", "Strawberry", "Coconut", "Date", "Peach")
                .flatMap(word -> Observable.timer(word.length(), TimeUnit.SECONDS).map(x -> word))
                .subscribe(System.out::println, Throwable::printStackTrace);

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testDayOfWeek() {
        Observable.just(DayOfWeek.SUNDAY, DayOfWeek.MONDAY)
//                .flatMap(PlayGround::loadRecordsFor) // order of upstream is preserved in downstream
                .concatMap(PlayGround::loadRecordsFor) // order of upstream doesn't match downstream
                .subscribe(System.out::println);

        try {
            MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Observable<String> loadRecordsFor(DayOfWeek dow) {
        switch (dow) {
            case SUNDAY:
                return Observable
                        .interval(90, MILLISECONDS)
                        .take(5)
                        .map(x -> "Sun-" + x);
            case MONDAY:
                return Observable
                        .interval(65, MILLISECONDS)
                        .take(5)
                        .map(x -> "Mon-" + x);
            default:
                return Observable.empty();
        }
    }

    public static void findCartesianProductChess() {
        Observable<Integer> oneToEight = Observable.range(1, 8);
        Observable<String> ranks = oneToEight
                .map(Object::toString);
        Observable<String> files = oneToEight
                .map(x -> 'a' + x - 1)
                .map(ascii -> (char) ascii.intValue())
                .map(ch -> Character.toString(ch));
        Observable<String> squares = files
                .flatMap(file -> ranks.map(rank -> file + rank));
        squares.subscribe(System.out::println);
    }

    public static void testCombineLatest() {
        Observable.combineLatest(
                Observable.interval(17, MILLISECONDS).map(x -> "S" + x),
                Observable.interval(10, MILLISECONDS).map(x -> "F" + x),
                (s, f) -> f + ":" + s
        ).forEach(System.out::println);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testScan() {
        Observable.range(1, 10)
                .scan(Integer::sum)
                .forEach(System.out::println);
    }

    public static void testReduce() {
        Observable.range(1, 10)
                .reduce(Integer::sum)
                .subscribe(System.out::println);
    }

    public static void testCollect() {
        Observable.range(1, 10)
                // some Observables by definition must emit exactly one value, user filter(x -> x > 10) to validate
                .collect(ArrayList::new, ArrayList::add)
                .subscribe(System.out::println);

    }

    public static void testDistinct() {
        Observable.fromArray(1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9)
                .distinct()
                .take(5)
                .forEach(System.out::println);
    }

    public static void testTakeUntilWhile() {
        Observable.range(1, 10)
                .takeUntil(x -> x == 5)
                .forEach(System.out::println);

        Observable.range(1, 10)
                .takeWhile(x -> x != 5)
                .forEach(System.out::println);
    }

    public static void testAmb() {
        Observable<Object> question = Observable.fromArray("Hello", "How", "Are", "You");
        Observable<String> answer = Observable.fromArray("I", "Am", "Fine", "You");

        Observable.ambArray(question, answer)
                .forEach(System.out::println);
    }

    public static void testConcat() {
        Observable<String> question = Observable.fromArray("Hello", "How", "Are", "You");
        Observable<String> answer = Observable.fromArray("I", "Am", "Fine", "You");

        Maybe<String> stringMaybe = Observable.concat(question, answer)
                .firstElement();

        stringMaybe.subscribe(System.out::println);
    }


    public static void testConversation() {
        Observable<String> alice = speak(
                "To be, or not to be: that is the question", 110);
        Observable<String> bob = speak(
                "Though this be madness, yet there is method in't", 90);
        Observable<String> jane = speak("There are more things in Heaven and Earth, " +
                "Horatio, than are dreamt of in your philosophy", 100);

        Observable
                .concat(
                        alice.map(w -> "Alice: " + w),
                        bob.map(w -> "Bob: " + w),
                        jane.map(w -> "Jane: " + w)
                )
                .subscribe(System.out::println);

        try {
            TimeUnit.SECONDS.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Observable<String> speak(String quote, long millisPerChar) {
        String[] tokens = quote.replaceAll("[:,]", "").split(" ");
        Observable<String> words = Observable.fromArray(tokens);
        Observable<Long> absoluteDelay = words.map(String::length)
                .map(len -> len * millisPerChar)
                .scan(Long::sum);

        return words.zipWith(absoluteDelay, Pair::of)
                .flatMap(pair -> Observable.just(pair.getLeft())
                        .delay(pair.getRight(), MILLISECONDS));

    }
}
