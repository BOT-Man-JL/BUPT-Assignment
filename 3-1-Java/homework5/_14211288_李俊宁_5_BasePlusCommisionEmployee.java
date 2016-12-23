
package homework5;

public class _14211288_���_5_BasePlusCommisionEmployee extends _14211288_���_5_CommisionEmployee
{
	private int baseSalary;

	public _14211288_���_5_BasePlusCommisionEmployee (
		String _firstName, String _lastName, String _sSN,
		int _grossSales, double _commissionRate, int _baseSalary)
	{
		super(_firstName, _lastName, _sSN, _grossSales, _commissionRate);
		baseSalary = _baseSalary;
	}
	
	public int GetBaseSalary ()
	{
		return baseSalary;
	}
	public void SetBaseSalary (int _baseSalary)
	{
		baseSalary = _baseSalary;
	}
	
	@Override
	public int earning()
	{
		return super.earning () + baseSalary;
	}

	@Override
	public String toString ()
	{
		return
			"Base Plus Commision Employee:" +
			"\nFirst Name: " + GetFirstName () +
			"\nLast Name: " + GetLastName () +
			"\nSocial Security Number: " + getSocialSecurityNumber () +
			"\nBase Salary: " + GetBaseSalary () +
			"\nEarning: " + earning ();
	}
}
