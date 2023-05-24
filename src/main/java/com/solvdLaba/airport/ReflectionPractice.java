package com.solvdLaba.airport;

import java.lang.reflect.*;
import java.util.Date;

public class ReflectionPractice {
    public static void main(String[] args) {
        Class<Flight> flightClass = Flight.class;

        String methodName = null;
        Class<Object> returnType = null;

        Field[] fields = flightClass.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            String modifierString = Modifier.toString(modifiers);
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();
            System.out.println(modifierString + " " + fieldType.getSimpleName() + " " + fieldName);
        }
        System.out.println("--------------------------------------------------------------");

        Method[] methods = flightClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            String modifierString = Modifier.toString(modifiers);
            methodName = method.getName();
            returnType = (Class<Object>) method.getReturnType();
            Parameter[] parameters = method.getParameters();

            System.out.print(modifierString + " " + returnType.getSimpleName() + " " + methodName + "(");
            for (int i = 0; i < parameters.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                Parameter parameter = parameters[i];
                System.out.print(parameter.getType().getSimpleName() + " " + parameter.getName());
            }
            System.out.println(")");
        }
        System.out.println("--------------------------------------------------------------");

        try {
            Constructor<Flight> flightConstructor = flightClass.getDeclaredConstructor(
                    String.class, Airport.class, Airport.class, int.class, Date.class, String.class, Terminal.class, Terminal.class);
            Object departureAirport = null;
            Object arrivalAirport = null;
            Object date = null;
            Object depTerminal = null;
            Object arrTerminal = null;
            Flight flight = flightConstructor.newInstance("FL123", departureAirport, arrivalAirport,
                    100, date, "2 hours", depTerminal, arrTerminal);

            Method getFlightNumberMethod = flightClass.getDeclaredMethod("getFlightNumber");
            Object result = getFlightNumberMethod.invoke(flight);
            System.out.println("Flight Number: " + result);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
