package org.example;

import org.example.thread.ThreadStoreSupplier;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Supplier<String> a = new ThreadStoreSupplier<>("Teste 1");

            System.out.println(a.get());
            System.out.println(Thread.currentThread().getId());
        });

        Thread thread2 = new Thread(() -> {
            Supplier<String> a = new ThreadStoreSupplier<>("Teste 2");

            System.out.println(a.get());
            System.out.println(Thread.currentThread().getId());
        });

        Thread thread3 = new Thread(() -> {
            Supplier<String> a = new ThreadStoreSupplier<>("Teste 3");

            System.out.println(a.get());
            System.out.println(Thread.currentThread().getId());
        });

        thread2.start();
        thread.start();
        thread3.start();
    }
}