package service.impl;

import java.util.List;

import dao.BookDao;
import entity.Book;
import service.BookService;

public class BookServiceImpl implements BookService{
	private BookDao bookdao;

	public BookDao getBookdao() {
		return bookdao;
	}

	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	@Override
	public List<Book> getAllBooks(String username) {
		return bookdao.getAllBooks(username);
	}

	@Override
	public boolean addBook(Book book) {
		return bookdao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookdao.deleteBook(id);
	}

	@Override
	public List<Book> getMyBooks(String username) {
		return bookdao.getMyBooks(username);
	}

	@Override
	public Book getBookById(int id) {
		return bookdao.getBookById(id);
	}

	@Override
	public void updateBook(int id, Book up) {
		bookdao.updateBook(id, up);
	}

	@Override
	public void updateBook2(int id, Book up) {
		bookdao.updateBook2(id, up);
		
	}
	

}
