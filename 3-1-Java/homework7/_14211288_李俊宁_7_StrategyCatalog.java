
package homework7;

import java.util.HashMap;

public class _14211288_���_7_StrategyCatalog
{
	public static String[] typeStrings = new String[] {
		"����ֵ�Żݲ���", "�ٷֱ��ۿ۲���", "��ϲ���" };

	HashMap<Integer, _14211288_���_7_IPricingStrategy> strategies;

	public _14211288_���_7_StrategyCatalog ()
	{
		strategies = new HashMap<Integer, _14211288_���_7_IPricingStrategy> ();
	}

	public HashMap<Integer, _14211288_���_7_IPricingStrategy> getStrategies ()
	{
		return strategies;
	}

	public _14211288_���_7_IPricingStrategy getStrategy (int category)
	{
		return strategies.get (category);
	}

	public void setStrategy (
		int category,
		_14211288_���_7_IPricingStrategy strategy)
	{
		strategies.put (category, strategy);
	}

	public void removeStrategy (int category)
	{
		strategies.remove (category);
	}
}