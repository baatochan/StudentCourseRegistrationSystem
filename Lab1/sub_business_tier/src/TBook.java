import java.util.Date;

public class TBook {
	private int number; //1-a iteracja
	private TTitle_book mTitle_book; //1-a iteracja

	public TBook() { //2-a iteracja
	}

	public int getNumber() { //2-a iteracja
		return number;
	}

	public void setNumber(int number) { //2-a iteracja
		this.number = number;
	}

	public TTitle_book getmTitle_book() { //2-a iteracja
		return mTitle_book;
	}

	public void setmTitle_book(TTitle_book mTitle_book) { //2-a iteracja
		this.mTitle_book = mTitle_book;
	}

	@Override
	public int hashCode() { //2-a iteracja
		int hash = 0;
		hash += (number != 0 ? number : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) { //2-a iteracja
		return number == ((TBook) obj).getNumber();
	}

	@Override
	public String toString() //2-a iteracja
	{
		String help = mTitle_book.toString();
		help += " Number: " + getNumber();
		return help;
	}

	public Date getPeriod() { //kolejne iteracje
		throw new UnsupportedOperationException("Not supported yet.");
	}
	public void setPeriod(Date period) { }
}