package com.Pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public void display() {

        init();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Car Dealership Menu ===");
            System.out.println("1. View All Vehicles");
            System.out.println("99. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Show all vehicles directly
                    List<Vehicle> vehicles = dealership.getAllVehicles();

                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles found in inventory.");
                    } else {
                        System.out.println("\n=== Vehicle Inventory ===");
                        for (Vehicle v : vehicles) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 99:
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }
        scanner.close();
    }
    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }


}



