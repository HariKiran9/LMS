/**
 * 
 */
package com.lms.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Home
 *
 */
public class Lending {

	private long userId;
	private List<Book> books = new ArrayList<>();
	private int noOfBookBorrowedByUser;

	public Lending() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books
	 *            the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * @return the noOfBookBorrowedByUser
	 */
	public int getNoOfBookBorrowedByUser() {
		return noOfBookBorrowedByUser;
	}

	/**
	 * @param noOfBookBorrowedByUser the noOfBookBorrowedByUser to set
	 */
	public void setNoOfBookBorrowedByUser(int noOfBookBorrowedByUser) {
		this.noOfBookBorrowedByUser = noOfBookBorrowedByUser;
	}

}
