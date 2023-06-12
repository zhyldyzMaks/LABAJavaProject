package com.solvdLaba.airport.utils;

import java.sql.*;
import java.util.concurrent.*;

public class ConnectionPool {

    private static ConnectionPool instance;
    private BlockingQueue<Connection> pool;
    private boolean initialized;

    private ConnectionPool() {
        pool = new LinkedBlockingQueue<>(5);
        initialized = false;
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    private void initializePool() {
        for (int i = 0; i < 5; i++) {
            pool.offer(new MockedConnection(""));
        }
        initialized = true;
    }

    public Connection getConnection() throws InterruptedException {
        return pool.poll(3000, TimeUnit.MILLISECONDS);
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    public CompletionStage<Connection> getConnectionForCompletable() {
        if (!initialized) {
            initializePool();
        }
        CompletableFuture<Connection> future = new CompletableFuture<>();
        try {
            Connection connection = pool.poll();
            if (connection != null) {
                future.complete(connection);
            } else {
                future = CompletableFuture.supplyAsync(() -> {
                    try {
                        return pool.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }
}