package com.solvdLaba.airport;

public class Luggage {
    private int weight; // in kilograms
    private String type; // carry-on or checked-in

    public Luggage(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String toString(){
        return "Baggage Details: \n Weight: "+weight+" kg"+"\n Type: "+type;
    }
    //  public void printDetails() {
//        System.out.println("Baggage details:");
//        System.out.println("  Weight: " + weight + " kg");
//        System.out.println("  Type: " + type);
//        System.out.println("  Owner: " + owner);
//    }


}
