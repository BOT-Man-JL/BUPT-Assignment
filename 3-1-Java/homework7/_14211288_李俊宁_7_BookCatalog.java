
package homework7;

import java.util.ArrayList;

public class _14211288_���_7_BookCatalog
{
	public static String[] categoryStrings = new String[] {
		"�ǽ̲�������ͼ��", "�̲���ͼ��",
		"��������ͼ��", "������ͼ��", "����" };

	private ArrayList<_14211288_���_7_BookSpecification> books;

	public _14211288_���_7_BookCatalog ()
	{
		books = new ArrayList<_14211288_���_7_BookSpecification> ();
	}

	public ArrayList<_14211288_���_7_BookSpecification> getBooks ()
	{
		return books;
	}

	public void addBook (_14211288_���_7_BookSpecification newBook) throws Exception
	{
		if (newBook.getCategory () > categoryStrings.length || newBook.getCategory () < 1)
			throw new Exception ("�鱾���� �Ƿ�");

		for (_14211288_���_7_BookSpecification book : books)
			if (book.getISBN ().equals (newBook.getISBN ()))
				throw new Exception ("ISBN ��ͻ");
		books.add (newBook);
	}

	public _14211288_���_7_BookSpecification getBook (String isbn) throws Exception
	{
		for (_14211288_���_7_BookSpecification book : books)
			if (book.getISBN ().equals (isbn))
				return book;
		throw new Exception ("ISBN �Ƿ�");
	}
}