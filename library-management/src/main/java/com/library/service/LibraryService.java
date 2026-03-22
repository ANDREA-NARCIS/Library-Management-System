package com.library.service;

import com.library.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LibraryService {

    // ✅ Add Author + Book
    public void addAuthorWithBook(Author author, Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        book.setAuthors(List.of(author));
        author.setBooks(List.of(book));

        em.persist(author);
        em.persist(book);

        tx.commit();
        em.close();
    }
    

    public void addMember(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = new Member();
        member.setName(name);

        em.persist(member);

        tx.commit();
        em.close();

        System.out.println("Member Added!");
    
    }

    // ✅ Issue Book
    public void issueBook(int memberId, int bookId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = em.find(Member.class, memberId);
        Book book = em.find(Book.class, bookId);

        member.getIssuedBooks().add(book);

        tx.commit();
        em.close();

        System.out.println("Book Issued!");
    }

    // ✅ Return Book
    public void returnBook(int memberId, int bookId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = em.find(Member.class, memberId);
        Book book = em.find(Book.class, bookId);

        member.getIssuedBooks().remove(book);

        tx.commit();
        em.close();

        System.out.println("Book Returned!");
    }

    // ✅ View All Books
    public void viewAllBooks() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Book> books = em.createQuery("from Book", Book.class).getResultList();

        for (Book b : books) {
            System.out.println("Book: " + b.getTitle());
        }

        em.close();
    }

    // ✅ View Books by Author
    public void viewBooksByAuthor(int authorId) {
        EntityManager em = JPAUtil.getEntityManager();

        Author author = em.find(Author.class, authorId);

        for (Book b : author.getBooks()) {
            System.out.println("Book: " + b.getTitle());
        }

        em.close();
    }
}