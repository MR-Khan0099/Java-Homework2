package Homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Car {
	//id, Make, Model, Year of manufacture, Color, Price, Registration number
	int Id;
	String Make;
	String Model;
	int YearOfManufacture;
	String Color;
	double Price;
	String RegistrationNumber;
	
	//Constructor
	//can work without writing public before car
	public Car(int Id,String Make,String Model,
			int YearOfManufacture,String Color,
			double Price,String RegistrationNumber){
		this.Id = Id;
		this.Make = Make;
		this.Model = Model;
		this.YearOfManufacture =YearOfManufacture;
		this.Color = Color;
		this.Price = Price;
		this.RegistrationNumber = RegistrationNumber;
		
	}
	//getter and setter method 
	public int getId() {
		return Id;
	}
	public String getMake() {
		return Make;
	}
	public String getModel() {
		return Model;
	}
	public int getYearOfManufacture() {
		return YearOfManufacture;
	}
	public String getColor() {
		return Color;
	}
	public double getPrice() {
		return Price;
	}
	public String getRegistrationNumber() {
		return RegistrationNumber;
	}

	public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry", 2020, "Blue", 25000.0, "ABC123"));
        cars.add(new Car(2, "Honda", "Civic", 2019, "Red", 22000.0, "XYZ456"));
        cars.add(new Car(3, "Ford", "Mustang", 2018, "Black", 35000.0, "DEF789"));
        cars.add(new Car(4, "Maruti", "Alto", 2018, "Black", 13000.0, "DAF789"));
        cars.add(new Car(5, "Ferrari", "Enzo", 2018, "Black", 89000.0, "DAF709"));
        cars.add(new Car(6, "Toyota", "Corolla", 2015, "Silver", 18000.0, "GHI789"));
        cars.add(new Car(7, "Ford", "F-150", 2017, "White", 30000.0, "JKL123"));

        // Please put your filters in the following variables
        String brandToFilter = "Toyota";
        String modelToFilter = "Camry";
        int yearsInUse = 2;
        int yearOfManufacture = 2018;
        double minPrice = 14000.0;

        // Filter and save cars to different files based on the criteria
        filterAndSaveCarsByBrand(cars, brandToFilter, "brand_filtered_cars.txt");
        filterAndSaveCarsByModelAndYearsInUse(cars, modelToFilter, yearsInUse, "model_years_filtered_cars.txt");
        filterAndSaveCarsByYearAndPrice(cars, yearOfManufacture, minPrice, "year_price_filtered_cars.txt");
    }

    // Function to filter and save cars of a given brand to a file
    public static void filterAndSaveCarsByBrand(List<Car> cars, String brand, String fileName) {
        List<Car> filteredCars = new ArrayList<>();
        boolean matchFound = false;

        for (Car car : cars) {
            if (car.getMake().equals(brand)) {
                filteredCars.add(car);
                matchFound = true;
            }
        }

        if (matchFound) {
            saveCarsToFile(filteredCars, fileName);
        } else {
            writeNoMatchToFileAndConsole(fileName);
        }
    }

    // Function to filter and save cars of a given model that have been in use for more than n years to a file
    public static void filterAndSaveCarsByModelAndYearsInUse(List<Car> cars, String model, int yearsInUse, String fileName) {
        List<Car> filteredCars = new ArrayList<>();
        boolean matchFound = false;
        int currentYear = 2023; // Assuming the current year is 2023

        for (Car car : cars) {
            if (car.getModel().equals(model) && (currentYear - car.getYearOfManufacture()) > yearsInUse) {
                filteredCars.add(car);
                matchFound = true;
            }
        }

        if (matchFound) {
            saveCarsToFile(filteredCars, fileName);
        } else {
            writeNoMatchToFileAndConsole(fileName);
        }
    }

    // Function to filter and save cars of a given year of manufacture with a price higher than the specified one to a file
    public static void filterAndSaveCarsByYearAndPrice(List<Car> cars, int yearOfManufacture, double minPrice, String fileName) {
        List<Car> filteredCars = new ArrayList<>();
        boolean matchFound = false;

        for (Car car : cars) {
            if (car.getYearOfManufacture() == yearOfManufacture && car.getPrice() > minPrice) {
                filteredCars.add(car);
                matchFound = true;
            }
        }

        if (matchFound) {
            saveCarsToFile(filteredCars, fileName);
        } else {
            writeNoMatchToFileAndConsole(fileName);
        }
    }

    // Function to save cars to a file
    public static void saveCarsToFile(List<Car> cars, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Car car : cars) {
                writer.write("ID: " + car.getId() + "\n");
                writer.write("Make: " + car.getMake() + "\n");
                writer.write("Model: " + car.getModel() + "\n");
                writer.write("Year: " + car.getYearOfManufacture() + "\n");
                writer.write("Color: " + car.getColor() + "\n");
                writer.write("Price: " + car.getPrice() + "\n");
                writer.write("Registration Number: " + car.getRegistrationNumber() + "\n\n");
            }
            System.out.println("Filtered cars saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving cars to file: " + e.getMessage());
        }
    }

    // Function to write "No match found" to both file and console
    public static void writeNoMatchToFileAndConsole(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("No match found.");
            System.out.println("No match found.");
        } catch (IOException e) {
            System.err.println("Error writing 'No match found' to file: " + e.getMessage());
        }
    }


	}








