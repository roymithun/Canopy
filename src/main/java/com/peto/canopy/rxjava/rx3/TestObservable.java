package com.peto.canopy.rxjava.rx3;

public class TestObservable {
    public static void main(String[] args) {
        /*Observable.fromArray(1, 2, 3, 4, 5, 6)
                .map(x -> x * 10)
                .filter(x -> x > 30).subscribe(System.out::println);*/


        /*Observable.range(5, 10)
                .map(x -> {
                    double d = Math.pow(x, 2);
                    return d / (100 - d);
                })
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe disposable -> " + disposable);
                    }

                    @Override
                    public void onNext(Double x) {
                        System.out.println("onNext -> " + x);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError -> " + throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });*/

        // low level
        /*ArrayList<Integer> result = new ArrayList<>();
        Observable.create((ObservableEmitter<Integer> observableEmitter) -> {
            System.out.println("create");
            observableEmitter.onNext(5);
            observableEmitter.onNext(6);
            observableEmitter.onNext(7);
            observableEmitter.onComplete();
            System.out.println("complete");
        }).subscribe(result::add);

        System.out.println(result);*/

        /*Observable<BigInteger> observable = Observable.create(subscriber -> {
            Runnable r = () -> {
                BigInteger i = BigInteger.ZERO;
                while (!subscriber.isDisposed()) {
                    subscriber.onNext(i);
                    i = i.add(BigInteger.ONE);
                }
            };
            new Thread(r).start();
        });
        Disposable disposable = observable.subscribe(System.out::println);
        try {
            Thread.sleep(5000);
            disposable.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
