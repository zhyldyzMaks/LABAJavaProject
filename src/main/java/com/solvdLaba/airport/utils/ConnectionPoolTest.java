package com.solvdLaba.airport.utils;

import com.solvdLaba.airport.utils.ConnectionPool;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolTest {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executor = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
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
        }

        for (int i = 0; i < 2; i++) {
            executor.execute(() -> {
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
        }
        executor.shutdown();
    }
}