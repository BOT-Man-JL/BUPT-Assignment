
package homework7;

import java.util.ArrayList;

public class _14211288_���_7_Sale implements _14211288_���_7_Subject
{
	private ArrayList<_14211288_���_7_Observer> observers;
	private ArrayList<_14211288_���_7_SaleLineItem> items;

	public _14211288_���_7_Sale ()
	{
		observers = new ArrayList<_14211288_���_7_Observer> ();
		items = new ArrayList<_14211288_���_7_SaleLineItem> ();
	}

	public void addItem (_14211288_���_7_SaleLineItem item)
	{
		items.add (item);
	}

	public ArrayList<_14211288_���_7_SaleLineItem> getItems ()
	{
		return items;
	}

	public double getTotal ()
	{
		double ret = 0;
		for (_14211288_���_7_SaleLineItem item : items)
			ret += item.getSubTotal ();
		return ret; 
	}

	@Override
	public void removeObserver (_14211288_���_7_Observer observer)
	{
		observers.remove (observer);
	}

	@Override
	public void registerObserver (_14211288_���_7_Observer observer)
	{
		observers.add (observer);
	}
	
	@Override
	public void notifyObservers ()
	{
		for (_14211288_���_7_Observer observer : observers)
			observer.update ();
	}
}