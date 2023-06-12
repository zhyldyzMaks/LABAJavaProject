package com.solvdLaba.airport.utils;

import com.solvdLaba.airport.utils.ConnectionPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturePractice<S> {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executor = Executors.newFixedThreadPool(7);
        List<java.util.concurrent.Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            java.util.concurrent.Future<String> future = (Future<String>) executor.submit(() -> {
                try {
                    Connection connection = connectionPool.getConnection();
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " got connection: " + connection);
                    Thread.sleep(2000);
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " released connection: " + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            futures.add(future);
        }
        for (int i = 0; i < 2; i++) {
            java.util.concurrent.Future<String> future = (Future<String>) executor.submit(() -> {
                try {
                    Connection connection = connectionPool.getConnection();
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " got connection: " + connection);
                    Thread.sleep(2000);
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " released connection: " + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            futures.add(future);
        }

        executor.shutdown();

        try {
            for (java.util.concurrent.Future<String> future : futures) {
                String result = future.get();
                if (result != null) {
                    System.out.println(result);
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}