package com.Pluralsight;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership();

        System.out.println("Dealership: " + dealership.getName());
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle);
        }
    }
}