
package homework7;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class _14211288_���_7_MainUI extends JFrame
{
	private _14211288_���_7_Controller controller;

	public _14211288_���_7_MainUI (_14211288_���_7_Controller _controller)
	{
		controller = _controller;
		initUI ();
	}

	private void initUI ()
	{
		JPanel panel = new JPanel ();

		// AddBook
		JButton bAddBook = new JButton("ͼ��Ŀ¼�����ģ��");
		bAddBook.addActionListener ((e) ->
		{
			_14211288_���_7_AddBookUI addBookUI =
				new _14211288_���_7_AddBookUI (controller);
			addBookUI.setVisible (true);
		});
		panel.add (bAddBook);

		// Strategies
		JButton bStrategies = new JButton("���۲���ά��ģ��");
		bStrategies.addActionListener ((e) ->
		{
			_14211288_���_7_StrategiesUI strategiesUI =
				new _14211288_���_7_StrategiesUI (controller);
			strategiesUI.setVisible (true);
		});
		panel.add (bStrategies);
		
		// Buy
		JButton bBuy = new JButton("����ģ��");
		bBuy.addActionListener ((e) ->
		{
			_14211288_���_7_BuyUI buyUI =
				new _14211288_���_7_BuyUI (controller);
			buyUI.setVisible (true);
		});
		panel.add (bBuy);
		
		// Add Panel
		this.add (panel);
		this.pack ();

		// Misc
		setTitle ("����������վ�Ĺ��ﳵϵͳ");
		setLocationRelativeTo (null);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
	}
	
	private static void seedBook (
		_14211288_���_7_Controller controller) throws Exception
	{
		ArrayList<_14211288_���_7_BookSpecification> books =
			new ArrayList<_14211288_���_7_BookSpecification> ();
		books.add (new _14211288_���_7_BookSpecification (
				"978-7-302-2", "UML ��ģʽӦ��", 18, 2));
		books.add (new _14211288_���_7_BookSpecification (
				"978-7-312-3", "Java ��ģʽ", 34, 1));
		books.add (new _14211288_���_7_BookSpecification (
				"968-6-302-1", "HeadFirst ���ģʽ", 58, 1));
		books.add (new _14211288_���_7_BookSpecification (
				"958-1-302-2", "����˿���ռ�", 30, 3));
		books.add (new _14211288_���_7_BookSpecification (
				"900-7-392-2", "������ȫ", 20, 4));
		books.add (new _14211288_���_7_BookSpecification (
				"N/A", "���������鼮", 100, 5));

		for (_14211288_���_7_BookSpecification book : books)
			controller.addBook (book);
	}

	private static void seedStrategy (
		_14211288_���_7_Controller controller) throws Exception
	{
		_14211288_���_7_IPricingStrategy d1 =
			new _14211288_���_7_FlatRateStrategy (
				"Discount001", "����ֵ�Żݲ��� 1", 1);
		_14211288_���_7_IPricingStrategy d2 =
			new _14211288_���_7_PercentageStrategy (
				"Discount002", "�ٷֱ��ۿ۲��� 1", 7);
		_14211288_���_7_IPricingStrategy d3 =
			new _14211288_���_7_PercentageStrategy (
				"Discount003", "�ٷֱ��ۿ۲��� 2", 3);
		_14211288_���_7_CompositeStrategy d4 =
			new _14211288_���_7_CompositeStrategy (
				"Discount004", "�˿����Ų��� 1");
		d4.add (d1);
		d4.add (d3);

		controller.setStrategy (1, d3);
		controller.setStrategy (2, d1);
		controller.setStrategy (3, d2);
		controller.setStrategy (4, d4);
	}

	private static void seedSale (
		_14211288_���_7_Controller controller) throws Exception
	{
		controller.buyBook ("978-7-302-2", 2);
		controller.buyBook ("978-7-312-3", 2);
		controller.buyBook ("968-6-302-1", 1);
		controller.buyBook ("958-1-302-2", 3);
		controller.buyBook ("900-7-392-2", 3);
	}

	public static void main (String[] args)
	{
		// Shared Object
		_14211288_���_7_Controller controller =
			new _14211288_���_7_Controller ();

		// Seed Data if args.length > 0
		try
		{
			if (args.length > 0)
			{
				seedBook (controller);
				seedStrategy (controller);
				seedSale (controller);
			}
		}
		catch (Exception ex)
		{
			System.out.println (ex.getMessage ());
		}

		System.out.println ("Hint: Use any Argument to Start to Init data :-)");

		// Start
		EventQueue.invokeLater (() ->
		{
			_14211288_���_7_MainUI gui =
				new _14211288_���_7_MainUI (controller);
			gui.setVisible (true);
		});
	}
}