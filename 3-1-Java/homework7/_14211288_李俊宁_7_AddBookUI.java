
package homework7;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class _14211288_���_7_AddBookUI extends JFrame
{
	private _14211288_���_7_Controller controller;
	private JPanel panel;

	public _14211288_���_7_AddBookUI (_14211288_���_7_Controller _controller)
	{
		controller = _controller;
		initUI ();
	}

	private void initUI ()
	{
		update ();

		// Misc
		setTitle ("ͼ��Ŀ¼�����ģ��");
		setLocationRelativeTo (null);
		setDefaultCloseOperation (DISPOSE_ON_CLOSE);
	}

	private void update ()
	{
		ArrayList<_14211288_���_7_BookSpecification> books =
			controller.getBooks ();
		String[] categoryStrings = controller.getCategoryStrings ();
		
		// Clear previous canvas
		if (panel != null)
			this.remove (panel);

		panel = new JPanel ();
		panel.setLayout (new BoxLayout (panel, BoxLayout.Y_AXIS));

		// Scroll Pane
		JPanel spanel = new JPanel ();
		spanel.setLayout (new GridLayout (books.size () + 1, 4));
		spanel.add (new JLabel ("ISBN"));
		spanel.add (new JLabel ("����"));
		spanel.add (new JLabel ("����"));
		spanel.add (new JLabel ("����"));
		for (_14211288_���_7_BookSpecification book : books)
		{
			spanel.add (new JLabel (book.getISBN ()));
			spanel.add (new JLabel (book.getTitle ()));
			spanel.add (new JLabel ("" + book.getPrice ()));
			spanel.add (new JLabel (categoryStrings[book.getCategory () - 1]));
		}
		panel.add (new JScrollPane (spanel));
		
		// Footer
		JPanel fpanel = new JPanel ();

		// ISBN
		fpanel.add (new JLabel ("ISBN"));
		JTextField tISBN = new JTextField (10);
		fpanel.add (tISBN);

		// Name
		fpanel.add (new JLabel ("����"));
		JTextField tName = new JTextField (10);
		fpanel.add (tName);

		// Price
		fpanel.add (new JLabel ("����"));
		JTextField tPrice = new JTextField (10);
		fpanel.add (tPrice);

		// Category
		fpanel.add (new JLabel ("����"));
		JComboBox<String> cCategory =
			new JComboBox<String> (categoryStrings);
		fpanel.add (cCategory);

		// Buttons
		JButton bAdd = new JButton("���");
		bAdd.addActionListener ((e) ->
		{
			try
			{
				controller.addBook (
					new _14211288_���_7_BookSpecification (
						tISBN.getText (),
						tName.getText (),
						Double.parseDouble (tPrice.getText ()),
						cCategory.getSelectedIndex () + 1
					)
				);
				update ();
			}
			catch (NumberFormatException ex)
			{
				System.out.println ("�۸� �Ƿ�����");
			}
			catch (Exception ex)
			{
				System.out.println (ex.getMessage ());
			}
		});
		JButton bCancel = new JButton("ȡ��");
		bCancel.addActionListener ((e) ->
		{
			this.dispose();
		});
		fpanel.add (bAdd);
		fpanel.add (bCancel);
		
		panel.add (fpanel);
		
		// Add Panel
		this.add (panel);
		this.pack ();
	}
}