package com.solvdLaba.airport.utils;

import com.solvdLaba.airport.utils.ConnectionPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableStagePractice {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executor = Executors.newFixedThreadPool(7);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Connection connection = connectionPool.getConnectionForCompletable().toCompletableFuture().join();
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " got connection: " + connection);
                    Thread.sleep(2000);
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " released connection: " + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            });
            futures.add(future);
        }
        for (int i = 0; i < 2; i++) {
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Connection connection = connectionPool.getConnectionForCompletable().toCompletableFuture().join();
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " got connection: " + connection);
                    Thread.sleep(2000);
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " released connection: " + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            });
            futures.add(future);
        }
        executor.shutdown();
    }
}