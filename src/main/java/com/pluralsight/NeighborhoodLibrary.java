package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;


public class NeighborhoodLibrary {

   private static Book[] books = new Book[] {
            new Book(1, "978-0-547-92821-0", "The Lord of the Rings: The Fellowship of the Ring by J.R.R Tolkien", false, ""),
            new Book(2, "978-0-7679-3061-1", "Breathers: A Zombie's Lament by S. G. Browne", false, ""),
            new Book(3,"978-0-099-58772-9", "The New Hunger by Isaac Marion", false, ""),
            new Book(4, "978-1-4767-1746-3", "Warm Bodies by Isaac Marion", false, ""),
            new Book(5, "978-0-307-34661-2", "World War Z: An Oral History of the Zombie War by Max Brooks", false, ""),
            new Book(6, "978-0-756-40675-2", "My Life as a White Trash Zombie by Diana Rowland", false, ""),
            new Book(7,"978-1-7365009-8-9", "The Little Mushroom: Judgment Day by Shi Si", false, ""),
            new Book(8, "978-10956609-99-8", "The Little Mushroom: Revelations by Shi Si", false, ""),
            new Book(9,"979-8-88843-261-7", "The Disabled Tyrant's Beloved Pet Fish by Xue Shan Fei Yu", false, ""),
            new Book(10,"978-1-64827-917-1", "Heaven Official's Blessing: Book 1 by Mo Xiang Tong Xu", false, ""),
            new Book(11, "978-0-39472-274-0", "Son of the Revolution by Liang Heng", false, ""),
            new Book(12, "978-0-19581-139-1", "Treasure Island by Robert Louis Stevenson", false, ""),
            new Book(13, "978-1984801258", "Untamed by Glennon Doyle", false, "")

    };


    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        storeHomeScreen(myScanner);
        myScanner.close();
    }

    private static void storeHomeScreen(Scanner myScanner) {
        System.out.println("Welcome to our Neighborhood Library!");
        System.out.println("Please select an option from our menu: ");
        System.out.println("    1. Show available books: ");
        System.out.println("    2. Show checked out books: ");
        System.out.println("    3. Exit");

        System.out.print("> ");

        int userChoice = myScanner.nextInt();
        if (userChoice == 1) {
            // shows available books
            showAvailableBooks(myScanner);
        } else if (userChoice == 2) {
            // shows checked out books
            showCheckedOutBooks(myScanner);
        } else if (userChoice == 3) {
            // exit
            System.exit(0);
            //the parameter is the "0" - this would make it successful, only a "0" would work
        } else {
            System.out.println("Please select 1, 2, or 3.");
        }
    }

    private static void showAvailableBooks(Scanner myScanner) {
        System.out.println("List of available books: ");
        for (int i = 0; i < books.length; i++){
            //this is what takes array and loops it, i stands for index
            Book book = books[i];
            if (!book.isCheckedOut()) {
                //this gets the first book and then continues
                System.out.println("    " + book.getId() + "." + " [ "+  book.getIsbn() + " ] " + book.getTitle());
            }
        }

        System.out.println("Choose a book to check out or press 0 to return to home: ");
        int userChoice = myScanner.nextInt();
        myScanner.nextLine();
        if (userChoice == 0) {
            storeHomeScreen(myScanner);
            return;
            //this will exit out of the function
        }

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getId() == userChoice) {
                System.out.print("Please enter you name: ");
                //this is cause if they enter a choice that is not listed it will not show name q
                String userName = myScanner.nextLine();
                book.checkOut(userName);
                storeHomeScreen(myScanner);
                return;
                //closes the loop to stop it
            }

        }

        System.out.println("Invalid choice, please try again.");
        storeHomeScreen(myScanner);
    }

    private static void showCheckedOutBooks(Scanner myScanner) {
        System.out.println("List of checked out books: ");
        for (int i = 0; i < books.length; i++) {
            //this is what takes array and loops it, i stands for index
            Book book = books[i];
            if (book.isCheckedOut()) {
                //this gets the first book and then continues
                System.out.println("    " + book.getId() + "." + " [ " + book.getIsbn() + " ] " + book.getTitle() + " (checked out to by: " + book.getCheckedOutTo() + ")\n");
            }
        }

        promptForCheckin(myScanner);

    }

    private static void promptForCheckin(Scanner myScanner) {
        System.out.println("Press C to check in a book; or press X to go back to the home screen.");

        myScanner.nextLine();
        String userChoice = myScanner.nextLine();
        if (userChoice.equalsIgnoreCase("C")) {
            checkInABook(myScanner);
        } else if (userChoice.equalsIgnoreCase("X")) {
            storeHomeScreen(myScanner);
        } else {
            System.out.println("Please enter a valid option.");
            promptForCheckin(myScanner);
        }
    }


    private static void checkInABook(Scanner myScanner) {
        System.out.println("Please enter the ID number of the book you would like to return: ");
        int userInput = myScanner.nextInt();
        myScanner.nextLine();

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getId() == userInput){
                book.checkIn();
                storeHomeScreen(myScanner);
                return;
            }

        }

    }

}
