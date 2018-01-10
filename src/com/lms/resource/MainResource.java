package com.lms.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.lms.helper.Book;
import com.lms.helper.Lending;
import com.lms.helper.User;

public class MainResource {

	private static List<User> usersList = new ArrayList<User>();
	private static List<Book> booksList = new ArrayList<Book>();
	private static Map<Long, Lending> mapResult = new HashMap<>();

	public MainResource() {
	}

	// 1. Ability to add books to the system.
	private static void addBook(long id, String title, String author, double bookPrice) {
		booksList.add(new Book(id, title, author, bookPrice));
	}

	// 2. Ability to add users to the system.
	private static void addUser(long userId, String userName) {
		usersList.add(new User(userId, userName));
	}

	// 3. Ability to lend books to users.
	private static void lendBooksToUser() {
		List<Book> lendingBooksByUser1 = new ArrayList<>();
		lendingBooksByUser1.add(booksList.get(0));
		// lendingBooksByUser1.add(booksList.get(1));
		lendingBooksByUser1.add(booksList.get(2));
		Lending lending1 = new Lending();
		lending1.setUserId(new Long(usersList.get(0).getId()));
		lending1.setBooks(lendingBooksByUser1);
		lending1.setNoOfBookBorrowedByUser(lendingBooksByUser1.size());
		mapResult.put(usersList.get(0).getId(), lending1);

		List<Book> lendingBooksByUser2 = new ArrayList<>();
		lendingBooksByUser2.add(booksList.get(1));
		lendingBooksByUser2.add(booksList.get(3));
		Lending lending2 = new Lending();
		lending2.setUserId(new Long(usersList.get(1).getId()));
		lending2.setBooks(lendingBooksByUser2);
		lending2.setNoOfBookBorrowedByUser(lendingBooksByUser2.size());
		mapResult.put(usersList.get(1).getId(), lending2);
	}

	// 4. Ability to return books to the library.
	private static void returnBook(long userId, String bookName) {
		Set<Entry<Long, Lending>> entrySet = mapResult.entrySet();
		Iterator<Entry<Long, Lending>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<Long, Lending> entry = it.next();
			long userId1 = entry.getKey();
			Lending lending = entry.getValue();
			if (userId1 == userId) {
				List<Book> lendedBookList = lending.getBooks();
				for (int i = 0; i < lendedBookList.size(); i++) {
					Book book = (Book) lendedBookList.get(i);
					if (book.getTitle().equalsIgnoreCase(bookName)) {
						lendedBookList.remove(i);
					}
				} // for
				lending.setNoOfBookBorrowedByUser(lendedBookList.size());
				usersList.forEach(user -> {
					if (user.getId() == lending.getUserId()) {
						System.out.println(lending.getNoOfBookBorrowedByUser() + " Book/s remained" + " by User "
								+ user.getName());
					}

				});
			} // if
		} // while
	}

	// 5. Ability to limit the number of books borrowed by user.
	private static boolean addBooksRestrictionToUser(long userId) {
		boolean returnValue = false;

		Set<Entry<Long, Lending>> entrySet = mapResult.entrySet();
		Iterator<Entry<Long, Lending>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<Long, Lending> entry = it.next();
			long userId1 = entry.getKey();
			Lending lending = entry.getValue();
			if (userId1 == userId) {
				if (lending.getNoOfBookBorrowedByUser() < 2) {
					List<Book> lendingBooksByUser2 = new ArrayList<>();
					lendingBooksByUser2.add(booksList.get(0));

					Lending lending2 = new Lending();
					lending2.setUserId(new Long(usersList.get(1).getId()));
					lending2.setBooks(lendingBooksByUser2);
					lending2.setNoOfBookBorrowedByUser(lendingBooksByUser2.size());
					mapResult.put(usersList.get(1).getId(), lending2);
					returnValue = true;
				} else {
					returnValue = false;
				}
			}
		} // while
		return returnValue;
	}

	// 6. Ability to search a book by title, author.
	private static List<User> searchByTitleAuthor(String title, String author) {
		List<User> userList = new ArrayList<>();
		Set<Entry<Long, Lending>> entrySet = mapResult.entrySet();
		Iterator<Entry<Long, Lending>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<Long, Lending> entry = it.next();
			Lending lending = entry.getValue();

			List<Book> userBorrowedBooks = lending.getBooks();
			userBorrowedBooks.forEach(book -> {
				if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
					long userBookId = lending.getUserId();
					for (User user : usersList) {
						if (userBookId == user.getId()) {
							userList.add(user);
						}
					}
				} // if
			});
		} // while
		return userList;
	}

	// 7. Ability to search a user by name
	private static User searchByUserName(String userName) {
		for (User user : usersList) {
			if (userName.equalsIgnoreCase(user.getName())) {
				return user;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		new MainResource();

		addUser(1L, "Hari");
		addUser(2L, "Kiran");

		addBook(1L, "XML Developer's Guide", "Gambardella, Matthew", 44.95);
		addBook(2L, "Midnight Rain", "Ralls, Kim", 5.95);
		addBook(3L, "Maeve Ascendant", "Corets, Eva", 5.95);
		addBook(4L, "Oberon's Legacy", "Corets, Eva", 5.95);

		lendBooksToUser();

		returnBook(1L, "XML Developer's Guide");

		List<User> searchResult = searchByTitleAuthor("Midnight Rain", "Ralls, Kim");
		searchResult.forEach(user -> {
			System.out.println(" User Id : " + user.getId() + " User Name: " + user.getName());
		});

		User searchUserObj = searchByUserName("kiran");
		System.out.println(" Search User Id : " + searchUserObj.getId());

		boolean bookRetriction = addBooksRestrictionToUser(1L);
		if (bookRetriction) {
			System.out.println("Success Borrowed !!!");
		} else {
			System.out.println(" No. Of Book Lended is more than/equal to 2, so you are unable to add");
		}
	}// main

}// class
