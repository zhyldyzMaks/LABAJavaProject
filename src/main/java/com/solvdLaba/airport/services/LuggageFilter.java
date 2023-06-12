package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.Luggage;

public interface LuggageFilter {

    boolean isOverweight(Luggage luggage);
}