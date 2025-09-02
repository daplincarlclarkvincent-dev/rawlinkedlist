/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TestJave;

import java.util.Scanner;

public class TestJave {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NumberManager manager = new NumberManager();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Peek");
            System.out.println("4. Clear");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                scan.nextLine(); // clear invalid input
                continue;
            }

            int input = scan.nextInt();
            scan.nextLine(); // consume newline

            switch (input) {
                case 1:
                    System.out.print("Enter number to add: ");
                    try {
                        int numToAdd = Integer.parseInt(scan.nextLine());
                        manager.add(numToAdd);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                    break;

                case 2:
                    System.out.print("Enter number to delete: ");
                    try {
                        int numToDelete = Integer.parseInt(scan.nextLine());
                        if (manager.delete(numToDelete)) {
                            System.out.println(numToDelete + " deleted.");
                        } else {
                            System.out.println(numToDelete + " not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                    break;

                case 3:
                    if (manager.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        System.out.println("First number (peek): " + manager.peek());
                    }
                    break;

                case 4:
                    manager.clear();
                    break;

                case 5:
                    manager.display();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 6.");
            }
        }
    }
}
