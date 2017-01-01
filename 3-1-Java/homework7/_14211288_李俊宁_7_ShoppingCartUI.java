
package homework7;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class _14211288_���_7_ShoppingCartUI extends JFrame implements _14211288_���_7_Observer
{
	private _14211288_���_7_Sale sale;
	private JScrollPane spane;

	public _14211288_���_7_ShoppingCartUI (_14211288_���_7_Sale _sale)
	{
		sale = _sale;
		initUI ();
	}

	private void initUI ()
	{
		update ();
		
		// Misc
		setTitle ("���ﳵ");
		setLocationRelativeTo (null);
		setDefaultCloseOperation (HIDE_ON_CLOSE);
	}

    @Override
	public void update ()
	{
		ArrayList<_14211288_���_7_SaleLineItem> items =  sale.getItems ();
		double total = sale.getTotal ();

		// Clear previous canvas
		if (spane != null)
			this.remove (spane);

		JPanel panel = new JPanel ();
		panel.setLayout (new GridLayout (items.size () + 2, 4));

		// Header
		panel.add (new JLabel ("����"));
		panel.add (new JLabel ("����"));
		panel.add (new JLabel ("ԭ��"));
		panel.add (new JLabel ("�ּ�"));

		// List
		for (_14211288_���_7_SaleLineItem item : items)
		{
			panel.add (new JLabel (item.getTitle ()));
			panel.add (new JLabel ("" + item.getCopies ()));
			panel.add (new JLabel ("" + item.getPreTotal ()));
			panel.add (new JLabel ("" + item.getSubTotal ()));
		}

		// Total Price
		panel.add (new JLabel (""));
		panel.add (new JLabel (""));
		panel.add (new JLabel ("�ܼ�"));
		panel.add (new JLabel ("" + total));
		
		// Add Panel
		spane = new JScrollPane (panel);
		this.add (spane);
		this.pack ();
	}
}