import java.util.Date;

public class TFactory {
	static final long day = 24 * 60 * 60 * 1000; //kolejne iteracje

	public TTitle_book create_title_book(String data[]) { //1-a iteracja
		TTitle_book title_book = null;
		switch (Integer.parseInt(data[0])) //what_title_book_type
		{
			case 0:
				title_book = new TTitle_book(); //TTitle_book object for searching
				title_book.setISBN(data[1]);
				break;
			case 1:
				title_book = new TTitle_book(); //TTitle_book object for persisting
				title_book.setAuthor(data[1]);
				title_book.setTitle(data[2]);
				title_book.setISBN(data[3]);
				title_book.setPublisher(data[4]);
				break;
		}
		return title_book;
	}

	public TBook create_book(String data[]) { //2-a iteracja
		TBook book = null;
		switch (Integer.parseInt(data[0])) //what_book_type
		{
			case 0:
				book = new TBook();//TBook object for persisting
				book.setNumber(Integer.parseInt(data[1]));
				break;
		}
		return book;
	}

	static public Date mdays(String data) { //kolejne iteracje
		throw new UnsupportedOperationException("Not supported yet.");
	}
}