/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds_project;
/**
 *
 * @author Rafiq
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        InsertContact C1 = new InsertContact();
        Scanner sc = new Scanner(System.in);
        String PN, FN, LN;
        String userChoice;

        // Load existing contacts from file when the program starts
        loadContactsFromFile(C1);

        // Open file to append new contact data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Rafiq\\Documents\\DS_PROG\\Ds_project\\contacts.txt", true))) {
            do {
                // Prompt user for contact details
                System.out.println("Enter the Number:");
                PN = sc.nextLine();

                System.out.println("Enter First Name:");
                FN = sc.nextLine();

                System.out.println("Enter Last Name:");
                LN = sc.nextLine();

                // Add contact to the linked list
                C1.addContact(PN, FN, LN);

                // Print all contacts
                System.out.println("\nCurrent Contact List:");
                C1.printContacts();

                // Write the contact data to the file
                writer.write(PN + "," + FN + "," + LN);  // Store in CSV format
                writer.newLine();  // Move to the next line after each entry

                // Ask user if they want to add another contact
                System.out.println("Do you want to add another contact? (yes/no): ");
                userChoice = sc.nextLine().toLowerCase();
            } while (userChoice.equals("yes")); // Loop continues as long as user inputs "yes"

            System.out.println("Data saved to contacts.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            // Close scanner
            sc.close();
        }
    }

    // Method to load contacts from file and add them to the linked list
    private static void loadContactsFromFile(InsertContact C1) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Rafiq\\Documents\\DS_PROG\\Ds_project\\contacts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into contact details (phone number, first name, last name)
                String[] contactDetails = line.split(",");
                if (contactDetails.length == 3) {
                    String PN = contactDetails[0];
                    String FN = contactDetails[1];
                    String LN = contactDetails[2];

                    // Add the contact to the linked list
                    C1.addContact(PN, FN, LN);
                }
            }
            System.out.println("Existing contacts loaded from file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }
}
