
package homework7;

public class _14211288_���_7_PricingStrategyFactory
{
	private	_14211288_���_7_StrategyCatalog catalog;
	private static _14211288_���_7_PricingStrategyFactory instance;

	private _14211288_���_7_PricingStrategyFactory () {}

	public static _14211288_���_7_PricingStrategyFactory getInstance ()
	{
		if (instance == null)
			instance = new _14211288_���_7_PricingStrategyFactory ();
		return instance;
	}

	public void setCatalog (_14211288_���_7_StrategyCatalog _catalog)
	{
		catalog = _catalog;
	}

	public _14211288_���_7_IPricingStrategy getPricingStrategy (int category) throws Exception
	{
		if (catalog == null)
			throw new Exception ("Invalid Catalog");

		_14211288_���_7_IPricingStrategy ret = catalog.getStrategy (category);
		if (ret == null)
			return new _14211288_���_7_NoDiscountStrategy();
		return ret;
	}
}