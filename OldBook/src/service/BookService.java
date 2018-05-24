package service;

import java.util.List;

import entity.Book;

public interface BookService {
	public List<Book> getAllBooks(String username);
	public List<Book> getMyBooks(String username);
	public boolean addBook(Book book);
	public void deleteBook(int id);
	public Book getBookById(int id);
	public void updateBook(int id,Book up);
	public void updateBook2(int id,Book up);
}
