
package homework5;

import java.util.Scanner;

public class _14211288_���_5_Test
{
	static public void main (String[] args)
	{
		_14211288_���_5_Factory factory = new _14211288_���_5_Factory ();
		factory.initEmployees ();

		System.out.println ("�˵����£������� 1~5 ������Ҫִ�еĲ�����\n" +
							"1. ����Ҫ��ѯ��Ա����ᱣ�պţ����Ա����Ϣ��\n" +
							"2. �����Ѿ�������Ա���б��е�һ��Ա�������������Ϣ�������б��е�Ա������\n" +
							"3. �����Ѿ�������Ա���б��е�һ��Ա���������HashMap��ɾ����\n" +
							"4. ��ӡȫ��Ա������Ϣ��\n" +
							"5. �˳�����");

		Scanner scanner = new Scanner (System.in);
		Boolean isQuit = false;
		while (!isQuit)
		{
			System.out.print ("���������Ĳ���: ");
			try
			{
				switch (Integer.parseInt (scanner.next ().trim ()))
				{
					case 1:
					{
						System.out.print ("����Ҫ��ѯ��Ա����ᱣ�պţ�");
						_14211288_���_5_Employee stu =
							factory.getEmployee (scanner.next ().trim ());

						if (stu != null)
						{
							System.out.println ("��ѯ��Ա����Ϣ��");
							System.out.println (stu.toString ());
						}
						else
							System.out.println ("�޴�Ա��");
						break;
					}
					case 2:
					{
						System.out.print ("����Ҫ���µ�Ա����ᱣ�պţ�");
						String ssn = scanner.next ().trim ();

						System.out.print ("����Ա������");
						String firstName = scanner.next ().trim ();

						System.out.print ("����Ա���գ�");
						String lastName = scanner.next ().trim ();
						
						System.out.print ("������Ա�����\n" +
										  "0 - SalaridEmployee\n" +
										  "1 - HourlyEmployee\n" +
										  "2 - CommisionEmployee\n" +
										  "3 - BasePlusCommisionEmployee\n");
						int type = Integer.parseInt (scanner.next ().trim ());

						_14211288_���_5_Employee stu;

						switch (type)
						{
						case 0:
						{
							System.out.print ("����weeklySalary��");
							int weeklySalary = Integer.parseInt (scanner.next ().trim ());

							stu = factory.updateEmployee (ssn,
								new _14211288_���_5_SalaridEmployee(
									firstName, lastName, ssn,
									weeklySalary
								));
							break;
						}
						case 1:
						{
							System.out.print ("����wage��");
							int wage = Integer.parseInt (scanner.next ().trim ());

							System.out.print ("����hours��");
							int hours = Integer.parseInt (scanner.next ().trim ());

							stu = factory.updateEmployee (ssn,
								new _14211288_���_5_HourlyEmployee(
									firstName, lastName, ssn,
									wage, hours
								));
							break;
						}
						case 2:
						{
							System.out.print ("����grossSales��");
							int grossSales = Integer.parseInt (scanner.next ().trim ());

							System.out.print ("����commissionRate��");
							double commissionRate = Double.parseDouble (scanner.next ().trim ());

							stu = factory.updateEmployee (ssn,
								new _14211288_���_5_CommisionEmployee(
									firstName, lastName, ssn,
									grossSales, commissionRate
								));
							break;
						}
						case 3:
						{
							System.out.print ("����grossSales��");
							int grossSales = Integer.parseInt (scanner.next ().trim ());

							System.out.print ("����commissionRate��");
							double commissionRate = Double.parseDouble (scanner.next ().trim ());

							System.out.print ("����baseSalary��");
							int baseSalary = Integer.parseInt (scanner.next ().trim ());

							stu = factory.updateEmployee (ssn,
								new _14211288_���_5_BasePlusCommisionEmployee(
									firstName, lastName, ssn,
									grossSales, commissionRate, baseSalary
								));
							break;
						}
						default:
							throw new Exception ();
						}

						if (stu != null)
						{
							System.out.println ("���µ�Ա����Ϣ��");
							System.out.println (stu.toString ());
						}
						else
							System.out.println ("�޴�Ա��");
						break;
					}
					case 3:
					{
						System.out.print ("����Ҫɾ����Ա����ᱣ�պţ�");
						_14211288_���_5_Employee stu =
							factory.deleteEmployee(scanner.next().trim());

						if (stu != null)
						{
							System.out.println ("ɾ����Ա����Ϣ��");
							System.out.println (stu.toString ());
						}
						else
							System.out.println ("�޴�Ա��");
						break;
					}
					case 4:
					{
						System.out.println ("��ӡȫ��Ա������Ϣ��");
						factory.printEmployees ();
						break;
					}
					case 5:
					{
						isQuit = true;
						System.out.println ("�˳�����");
						break;
					}
					default:
					{
						throw new Exception ();
					}
				}
			}
			catch (Exception e)
			{
				System.out.println ("�Ƿ�����");
			}
		}
	}
}
