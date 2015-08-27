package fibonacciobserver;

import java.util.ArrayList;
import java.util.List;

public class FibonacciTask implements Runnable {

    private long tal;
    private long n;
    List<FibonacciObserver> observers = new ArrayList();

    FibonacciTask() {
    }

    public void registerFibonacciObserver(FibonacciObserver o) {
        observers.add(o);
    }

    public void setN(long n) {
        this.n = n;
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public FibonacciTask(long n) {
        this.tal = n;
    }

    @Override
    public void run() {
        tal = fib(n);
        for (FibonacciObserver observer : observers) {
            observer.dataReady(tal);
        }
    }
}
