import java.util.Scanner;

public class _14211288_���_1_StudentList
{
    private _14211288_���_1_Student[] list;
    private int total;

    public _14211288_���_1_StudentList(int length)
	{
        total = 0;
        list = new _14211288_���_1_Student[length];
    }

    public boolean add(_14211288_���_1_Student stu)
	{
        if (total == list.length)
            return false;
        else
		{
            list[total++] = stu;
            return true;
        }
    }

    public boolean remove(int no)
	{
		if (no > total || no <= 0)
			return false;

		int j = 0;
		for(int i = 0; i < total; i++)
			if (i != no - 1)
			{
				if (j != i)
					list[j] = list[i];
				j++;
			}
		total--;
		list[total] = null;
		return true;
    }

    public boolean remove(String number)
	{
		int index = -1;
		for (int i = 0; index == -1 && i < total; i++)
			if (list[i].getNumber().equals(number))
				index = i;

		if (index == -1)
			return false;
		else
			return this.remove (index + 1);
    }

    public boolean isEmpty()
	{
        return total == 0;
    }

    public _14211288_���_1_Student getItem(int no)
	{
        if (no > total || no <= 0)
            return null;
        else
            return list[no - 1];
    }

    public _14211288_���_1_Student getItem(String number)
	{
        for(int i = 0; i < total; i++)
            if (list[i].getNumber().equals(number))
                return list[i];
        return null;
    }

    public int getTotal()
	{
        return total;
    }
}

class StudentListTest
{
    public static void main(String[] args)
	{
        System.out.println("�˵����£������� 1~8������Ҫִ�еĲ�����\n" +
						   "1. ����1��ѧ��  2. ����ѧ��ɾ��ѧ��  3. ����λ��ɾ��ѧ��\n" +
						   "4. �ж��Ƿ�Ϊ��   5.����λ�÷���ѧ��   6.����ѧ�ŷ���ѧ��\n" +
						   "7. ���ȫ��ѧ����Ϣ  8.�˳�����");

        _14211288_���_1_StudentList studentList =
			new _14211288_���_1_StudentList(10);

        Scanner scanner = new Scanner(System.in);
		boolean isQuit = false;
        while (!isQuit)
		{
			boolean isPrintAll = false;
            System.out.print("���������Ĳ���: ");
			try
			{
				switch (Integer.parseInt(scanner.next().trim()))
				{
					case 1:
					{
						System.out.println("������ѧ����Ϣ��");
						System.out.print("ѧ�ţ�");
						String studentNumber = scanner.next();
						System.out.print("������");
						String studentName = scanner.next();
						System.out.print("��ѧ�ɼ�: ");
						int markForMaths = Integer.parseInt(scanner.next().trim());
						System.out.print("Ӣ��ɼ�: ");
						int markForEnglish = Integer.parseInt(scanner.next().trim());
						System.out.print("��ѧ�ɼ�: ");
						int markForScience = Integer.parseInt(scanner.next().trim());

						_14211288_���_1_Student student =
							new _14211288_���_1_Student(studentNumber, studentName);
						student.enterMarks(markForMaths, markForEnglish, markForScience);
						studentList.add(student);

						isPrintAll = true;
						break;
					}
					case 2:
					{
						System.out.print("������ѧ��ѧ�ţ�");

						if (studentList.remove(scanner.next()))
						{
							isPrintAll = true;
							System.out.println("ɾ���ɹ�");
						}
						else
							System.out.println("�Բ���û�ж�Ӧ��ѧ��");
						break;
					}
					case 3:
					{
						System.out.print("������ѧ��ѧ�ţ�");

						if (studentList.remove(Integer.parseInt(scanner.next().trim())))
						{
							isPrintAll = true;
							System.out.println("ɾ���ɹ�");
						}
						else
							System.out.println("�Բ���û�ж�Ӧ��ѧ��");
						break;
					}
					case 4:
					{
						if (studentList.isEmpty())
							System.out.println("Ϊ��");
						else
							System.out.println("�ǿ�");
						break;
					}
					case 5:
					{
						System.out.print("������ѧ��λ�ã�");
						_14211288_���_1_Student stu =
							studentList.getItem(Integer.parseInt(scanner.next().trim()));

						if (stu != null)
						{
							System.out.println("ѧ����Ϣ���£�");
							System.out.println(stu);
						}
						else
							System.out.println("�Բ���û����Ӧ��ѧ��");
						break;
					}
					case 6:
					{
						System.out.print("������ѧ��ѧ�ţ�");
						_14211288_���_1_Student stu =
							studentList.getItem(scanner.next());

						if (stu != null)
						{
							System.out.println("ѧ����Ϣ���£�");
							System.out.println(stu);
						}
						else
							System.out.println("�Բ���û����Ӧ��ѧ��");
						break;
					}
					case 7:
					{
						isPrintAll = true;
						break;
					}
					case 8:
					{
						isQuit = true;
						break;
					}
					default:
					{
						throw new Exception();
					}
				}

				// Print All Here
				if (isPrintAll)
				{
					System.out.println("---Ŀǰ��" +studentList.getTotal() + "��ѧ������ϢΪ---");
					for (int i = 0; i < studentList.getTotal(); i++)
						System.out.println(studentList.getItem(i + 1));
				}
			}
			catch (Exception e)
			{
				System.out.println("Bad Input");
			}
        }
    }
}