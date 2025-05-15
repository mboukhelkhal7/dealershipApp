package com.Pluralsight;

import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];
                dealership = new Dealership(name, address, phone);
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);


                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter("inventory.csv");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            // Write dealership info on the first line
            writer.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());
            writer.newLine(); // move to next line

            for (Vehicle v : dealership.getAllVehicles()) {
                String line = v.getVin() + "|" +
                        v.getYear() + "|" +
                        v.getMake() + "|" +
                        v.getModel() + "|" +
                        v.getVehicleType() + "|" +
                        v.getColor() + "|" +
                        v.getOdometer() + "|" +
                        v.getPrice();
                writer.write(line);
                writer.newLine(); // move to next line
            }
            writer.close();

            System.out.println("Inventory saved using BufferedWriter.");

        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }
}
