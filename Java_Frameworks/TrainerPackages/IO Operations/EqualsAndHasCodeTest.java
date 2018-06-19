package trng.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This program demonstrates the following.
 * toString() method
 * hasCode() and equals() methods contract.
 * 
 * @author Manohar
 *
 */
public class EqualsAndHasCodeTest {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Book b1 = new Book(101, "Java", "Bala Guru", 100.5f);
		Book b2 = new Book(103, "C", "Bala Guru", 102.5f);
		Book b3 = new Book(102, "C++", "Bala Guru", 150.5f);
		Book b4 = new Book(101, "Java", "Bala Guru", 100.5f);
		

		System.out.println(b1);
		System.out.println(b1.toString());
		System.out.println(b1.hashCode());
		System.out.println(b4.hashCode());
		
		System.out.println("b1 and b4 has same hasCode value? " + (b1.hashCode() == b4.hashCode()));
		System.out.println("b1 equals student2 ? " + b1.equals(b4));
		


		List<Book> books = new ArrayList<Book>();

		books.add(b1);
		books.add(b2);
		books.add(b3);
		System.out.println("Before update , the list value: ");
		for (Book book : books) {
			book.display();
		}

		System.out.println("After update , the list value: ");
		b2.setAuthor("Manohar");
		
		for (Book book : books) {
			book.display();
		}
		
		Collections.sort(books);
		
		for (Book book : books) {
			book.display();
		}
		
		System.out.println(books.contains(b2));
		
		Map<Long, Book> bookMap = getBookMap(books);
		

		System.out.println("Enter  bookId to search");
		long bookId = scanner.nextLong();
		Book requiredBook = bookMap.get(bookId);
		requiredBook.display();
		

	}



	static Map<Long, Book> getBookMap(List<Book> books) {
		Map<Long, Book> bookMap = new HashMap<Long, Book>();
		for (Book book : books) {
			bookMap.put(book.bookId, book);
		}

		return bookMap;
	}

	static class Book implements Comparable<Book> {
		protected long bookId;
		protected String booName;
		protected String author;
		protected float price;

		public Book(long bookId, String booName, String author, float price) {
			super();
			this.bookId = bookId;
			this.booName = booName;
			this.author = author;
			this.price = price;
		}

		public Book() {
		}

		void display() {
			System.out.println(bookId + "  " + booName + "  " + author + "  "
					+ price);
		}

		Book comparePrice(Book other) {
			if (price > other.price) {
				return this;
			} else {
				return other;
			}
		}

		void setAuthor(String author) {
			this.author = author;
		}
		
		@Override
		public int compareTo(Book other) {
			if (bookId >= other.bookId) {
				return 0;
			} else if (bookId == other.bookId) {
				return 1;
			} else {
				return -1;
			}
		}

		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((author == null) ? 0 : author.hashCode());
			result = prime * result + ((booName == null) ? 0 : booName.hashCode());
			result = prime * result + (int) (bookId ^ (bookId >>> 32));
			result = prime * result + Float.floatToIntBits(price);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (author == null) {
				if (other.author != null)
					return false;
			} else if (!author.equals(other.author))
				return false;
			if (booName == null) {
				if (other.booName != null)
					return false;
			} else if (!booName.equals(other.booName))
				return false;
			if (bookId != other.bookId)
				return false;
			if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
				return false;
			return true;
		}

	}
}
