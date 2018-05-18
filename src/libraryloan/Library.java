/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryloan;

import java.util.List;

/**
 *
 * @author Kamil
 */
public class Library {  //model
    
    private BookDAO bookDAO;
    
    public Library(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    public void addNewBook(String name, String authors, int year){
        Book book = new Book();
        book.setAvailable(true);
        book.setName(name);
        book.setAuthors(authors);
        book.setPublishedYear(year);
        
        bookDAO.insertBook(book);
    }
    
    public void loanBook(long uniqueID){        // missing Exceptions
        List<Book> books = bookDAO.findBookByProperty(BookSearchType.ID, uniqueID);
        if(books.size() > 0) {
            books.get(0).setAvailable(false);
            bookDAO.updateBook(books.get(0));
        }
    }
    
    public void returnBook(long uniqueID){      // missing Exceptions
        List<Book> books = bookDAO.findBookByProperty(BookSearchType.ID, uniqueID);
        if(books.size() > 0) {
            books.get(0).setAvailable(true);
            bookDAO.updateBook(books.get(0));
        }
    }
    
}
