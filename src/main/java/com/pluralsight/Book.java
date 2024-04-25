package com.pluralsight;

public class Book {
     private int id;
     private String isbn;
     private String title;
     private boolean isCheckedOut;
     private String checkedOutTo;

     public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
          this.id = id;
          this.isbn = isbn;
          this.title = title;
          this.isCheckedOut = isCheckedOut;
          this.checkedOutTo = checkedOutTo;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getIsbn() {
          return isbn;
     }

     public void setIsbn(String isbn) {
          this.isbn = isbn;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public boolean isCheckedOut() {
          return isCheckedOut;
     }

     public void setCheckedOut(boolean checkedOut) {
          isCheckedOut = checkedOut;
     }

     public String getCheckedOutTo() {
          return checkedOutTo;
     }

     public void setCheckedOutTo(String checkedOutTo) {
          this.checkedOutTo = checkedOutTo;
     }


 public void checkOut(String name) {
      if (!isCheckedOut) {
           isCheckedOut = true;
           checkedOutTo = name;
           System.out.println(title + " has been checked out to " + name);
      } else {
           System.out.println(title + " is already checked out.");
      }
 }

 public void checkIn() {
               if (isCheckedOut) {
                    isCheckedOut = false;
                    checkedOutTo = "";
                    System.out.println(title + " has been checked in.");
               } else {
                    System.out.println(title + " is not checked out.");

               }


          }

 }



