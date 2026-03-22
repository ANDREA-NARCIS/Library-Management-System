package com.library.main;

import com.library.entity.*;
import com.library.service.LibraryService;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("0. Add Member");
            System.out.println("1. Add Author & Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. View Books by Author");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    sc.nextLine();
                    System.out.print("Member Name: ");
                    String mName = sc.nextLine();

                    service.addMember(mName);
                    break;

                case 1:
                    sc.nextLine();
                    System.out.print("Author Name: ");
                    String aName = sc.nextLine();

                    System.out.print("Book Title: ");
                    String bTitle = sc.nextLine();

                    Author author = new Author();
                    author.setName(aName);

                    Book book = new Book();
                    book.setTitle(bTitle);

                    service.addAuthorWithBook(author, book);
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    int mId = sc.nextInt();

                    System.out.print("Book ID: ");
                    int bId = sc.nextInt();

                    service.issueBook(mId, bId);
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    int rmId = sc.nextInt();

                    System.out.print("Book ID: ");
                    int rbId = sc.nextInt();

                    service.returnBook(rmId, rbId);
                    break;

                case 4:
                    service.viewAllBooks();
                    break;

                case 5:
                    System.out.print("Author ID: ");
                    int aId = sc.nextInt();

                    service.viewBooksByAuthor(aId);
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}