import java.util.ArrayList;
import java.util.List;

public class TFacade {
	List<TTitle_book> mTitle_books;

	public TFacade() { //1-a iteracja
		mTitle_books = new ArrayList<>();
	}

	public List<TTitle_book> getmTitle_books() { //1-a iteracja
		return mTitle_books;
	}

	void setmTitle_books(List<TTitle_book> title_books) { //1-a iteracja
		mTitle_books = title_books;
	}

	public TTitle_book search_title_book(TTitle_book title_book) { //1-a iteracja
		int idx;
		if ((idx = mTitle_books.indexOf(title_book)) != -1) {
			title_book = mTitle_books.get(idx);
			return title_book;
		}
		return null;
	}

	public String add_title_book(String data[]) { //1-a iteracja
		TFactory factory = new TFactory();
		TTitle_book title_book = factory.create_title_book(data);
		if (search_title_book(title_book) == null) {
			mTitle_books.add(title_book);
			return title_book.toString();
		}
		return null;
	}

	public ArrayList<String> add_book(String data1[], String data2[]) { //2-a iteracja
		TTitle_book help1, title_exist;
		TFactory fabryka = new TFactory();
		help1 = fabryka.create_title_book(data1);
		if ((title_exist = search_title_book(help1)) != null) {
			return title_exist.add_book(data2);
		}
		return null;
	}

	public ArrayList<String> gettitle_books() { //kolejne iteracje
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public TTitle_book Search_title_book(String[] data) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public TBook Search_accessible_book(String[] data1, Object data2) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void Print_books() {	}

	public void Print_title_books() { }

	public static void main(String t[]) {
		TFacade ap = new TFacade();
		String t1[] = {"1", "Author1", "Title1", "ISBN1", "Publisher1"}; //1-a iteracja
		String t2[] = {"1", "Author2", "Title2", "ISBN2", "Publisher2"}; //1-a iteracja
		String t3[] = {"1", "Author3", "Title3", "ISBN3", "Publisher3"}; //1-a iteracja
		ap.add_title_book(t1); //1-a iteracja
		ap.add_title_book(t2); //1-a iteracja
		ap.add_title_book(t2); //1-a iteracja
		ap.add_title_book(t3); //1-a iteracja
		String lan = ap.getmTitle_books().toString(); //1-a iteracja
		System.out.println(lan); //1-a iteracja
		String d1[] = {"0", "ISBN1"}; //2-a iteracja
		String d2[] = {"0", "ISBN2"}; //2-a iteracja
		String d3[] = {"0", "ISBN5"}; //2-a iteracja
		String tr1[] = {"0", "1"}; //2-a iteracja
		String tr2[] = {"0", "2"}; //2-a iteracja
		ArrayList<String> pom = ap.add_book(d1, tr1); //2-a iteracja
		if (pom != null) { //2-a iteracja
			System.out.print(pom); } //2-a iteracja
		pom = ap.add_book(d2, tr1); //2-a iteracja
		if (pom != null) { //2-a iteracja
			System.out.print(pom); } //2-a iteracja
		pom = ap.add_book(d2, tr1); //2-a iteracja
		if (pom != null) { //2-a iteracja
			System.out.print(pom);} //2-a iteracja
		pom = ap.add_book(d2, tr2); //2-a iteracja
		if (pom != null) { //2-a iteracja
			System.out.print(pom);} //2-a iteracja
		pom = ap.add_book(d3, tr2); //2-a iteracja
		if (pom != null) { //2-a iteracja
			System.out.print(pom);} //2-a iteracja
		System.out.println(); //2-a iteracja
	} //1-a iteracja
}