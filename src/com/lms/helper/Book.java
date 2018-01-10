/**
 * 
 */
package com.lms.helper;

/**
 * @author Home
 *
 */
public class Book {

	private long id;
	private String title;
	private String author;
	private double bookPrice;

	public Book() {

	}

	public Book(long id, String title, String author, double bookPrice) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.bookPrice = bookPrice;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the bookName
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param bookName
	 *            the bookName to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the bookPrice
	 */
	public double getBookPrice() {
		return bookPrice;
	}

	/**
	 * @param bookPrice
	 *            the bookPrice to set
	 */
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

}
