import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
public class TTitle_book {
	private String publisher; //1-a iteracja
	private String ISBN; //1-a iteracja
	private String title; //1-a iteracja
	private String author; //1-a iteracja
	List<TBook> mBooks; //1-a iteracja

	public TTitle_book() {
		mBooks = new ArrayList(); //1-a iteracja
	}

	public String getPublisher() { //1-a iteracja
		return publisher;
	}

	public void setPublisher(String publisher) { //1-a iteracja
		this.publisher = publisher;
	}

	public String getISBN() { //1-a iteracja
		return ISBN;
	}

	public void setISBN(String ISBN) { //1-a iteracja
		this.ISBN = ISBN;
	}

	public String getTitle() { //1-a iteracja
		return title;
	}

	public void setTitle(String title) { //1-a iteracja
		this.title = title;
	}

	public String getAuthor() { //1-a iteracja
		return author;
	}

	public void setAuthor(String author) { //1-a iteracja
		this.author = author;
	}

	public List<TBook> getmBooks() { //1-a iteracja
		return mBooks;
	}

	public void setmBooks(List<TBook> mBooks) { //1-a iteracja
		this.mBooks = mBooks;
	}

	@Override
	public int hashCode() { //1-a iteracja
		int hash = 5;
		hash = 53 * hash + Objects.hashCode(this.ISBN);
		return hash;
	}

	@Override
	public boolean equals(Object obj) { //1-a iteracja
		boolean result = false;
		if (getISBN().equals(((TTitle_book) obj).getISBN()))
			result = true;
		return result;
	}

	@Override
	public String toString() { //1-a iteracja
		String help = "\nTitle: " + getTitle();
		help += " Author: " + getAuthor();
		help += " ISBN: " + getISBN();
		help += " Publisher: " + getPublisher();
		return help;
	}

	public ArrayList<String> add_book(String data[]) { //2-a iteracja
		TFactory factory = new TFactory();
		TBook newbook;
		newbook = factory.create_book(data);
		if (search_book(newbook) == null) {
			mBooks.add(newbook);
			newbook.setmTitle_book(this);
			return getbooks();
		}
		return null;
	}

	public TBook search_book(TBook book) { //2-a iteracja
		int idx;
		if ((idx = mBooks.indexOf(book)) != -1) {
			book = (TBook) mBooks.get(idx);
			return book;
		}
		return null;
	}

	public ArrayList<String> getbooks() { //2-a iteracja
		ArrayList<String> title_books = new ArrayList<>();
		Iterator<TBook> help = mBooks.iterator();
		while (help.hasNext()) {
			TBook next = help.next();
			title_books.add(next.toString());
		}
		return title_books;
	}

	public String[] toString_() {
		throw new UnsupportedOperationException("Not supported yet.");
	} //kolejne iteracje

	public String search_accessible_book(Object data) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public String getActor() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void setActor(String val) { }
}