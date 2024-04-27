import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.*;

import Plan.MuscleGainPlan;
import Plan.WeightLossPlan;

public class FitnessApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input user details
        System.out.println("Welcome to FitnessApp!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        char gender;
        do{
            System.out.print("Enter your gender (M/F): ");
         gender = scanner.next().toUpperCase().charAt(0);
            if(gender != 'M' && gender != 'F') {
                System.out.println("Please enter M or F.");
            }
        }while(gender != 'M' && gender != 'F');
        

        double  weight=0;
        boolean Weightreal = false;
        while (!Weightreal) {
            try {
                System.out.print("Enter your weight (kg): ");
                weight = scanner.nextDouble();
                if (weight > 0) {
                    Weightreal = true; 
                } else {
                    System.out.println("Weight must be a positive number. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        double height=0;
        boolean heightreal = false;
        while (!heightreal){
            try{
                System.out.print("Enter your height (cm): ");
                height = scanner.nextDouble();
                if(height > 0){
                    heightreal = true;
                }else {
                    System.out.println("Height must be a positive number. Please try again.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        int age = 0;
        boolean agereal = false;
        while (!agereal){
            try{
                System.out.print("Enter your age (year): ");
                age = scanner.nextInt();
                if(age > 0){
                    agereal = true;
                }else {
                    System.out.println("Age must be a positive number. Please try again.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        // Calculate BMI
        double bmi = calculateBMI(weight, height);
        System.out.println("Your BMI is: " + bmi);

        // Calculate body fat percentage
        double bodyFat = calculateBodyFatPercentage(weight, height, gender,bmi,age);
        System.out.println("Your body fat percentage is: " + bodyFat);


        int exercisePerWeek =0;
        // Ask user for exercise preference
        do {
            System.out.print("How many times do you want to exercise per week? ");
            exercisePerWeek = scanner.nextInt();
            if (exercisePerWeek < 1 || exercisePerWeek > 7) {
                System.out.println("Please enter a number between 1 and 7.");
            }
        } while (exercisePerWeek < 1 || exercisePerWeek > 7);
        System.out.println("You will exercise " + exercisePerWeek + " times per week.");

        // Ask user for their goal
        int choice;

        do {
            System.out.println("What is your goal?");
            System.out.println("1. Weight Loss");
            System.out.println("2. Muscle Gain");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter either 1 or 2.");
                System.out.print("Enter your choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid input. Please enter either 1 or 2.");
            }
        } while (choice != 1 && choice != 2);

        System.out.println("You chose: " + (choice == 1 ? "Weight Loss" : "Muscle Gain"));

        MuscleGainPlan newMusclePlan = new MuscleGainPlan();
        WeightLossPlan newWeightPlan = new WeightLossPlan();

        // Display workout plan
        if (choice == 1) {
            newWeightPlan.displayPlan(exercisePerWeek);
        } else if ( choice == 2){
            newMusclePlan.displayPlan(exercisePerWeek);;
        } else {
            System.out.println("Please input only 1 - 2 ");

        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = now.format(formatter); //Use different timestamp formats (yyyyMMdd_HHmmss, yyyy-MM-dd_HH-mm-ss, etc.).
        String filename =  name +"_Data_"+ timestamp + ".txt"; // Example: output_20220425_134500.txt


        // Save workout plan to the file
        try (BufferedWriter filewrite = new BufferedWriter(new FileWriter(filename))){
            filewrite.write("Name : "+ name);
            filewrite.newLine();
            filewrite.write("Gender : " + gender);
            filewrite.newLine();
            filewrite.write("Age : " + age);
            filewrite.newLine();
            filewrite.write("BMI : " + bmi);
            filewrite.newLine();
            filewrite.write("Body fat percentage : " + bodyFat);
            filewrite.close();

            System.out.println("Info saved to file: " + name +"_Data_"+ timestamp + ".txt");
        } catch (IOException e) {
            System.err.println("Error writing Info to file: " + e.getMessage());
        }


        try (BufferedReader fileread = new BufferedReader(new FileReader(filename))){
            String line = null;
            while((line = fileread.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error Reading workout plan to file: " + e.getMessage());
        }
        scanner.close();

    }

    public static double calculateBMI(double weight, double height) {
        
        return Math.round((weight / ((height / 100) * (height / 100)))*100.0)/100.0;
    }

    public static double calculateBodyFatPercentage(double weight, double height, char gender, double bmi, int age) {
        // Body fat calculation logic can be implemented here
        // For simplicity, let's assume a basic formula for demonstration purposes
        if (gender == 'M') {
            return (Math.round(((1.2 * bmi) + (0.23 * age) - 16.2)* 100.0) / 100.0); // Example calculation for males
        } else {
            return (Math.round(((1.2 * bmi) + (0.23 * age) - 5.4)* 100.0) / 100.0); // Example calculation for females
        }
    }
    
}
