
package homework2;
import java.util.Scanner;

class ScoreException extends Exception
{
	public ScoreException (int score)
	{
		super ("You add " + score + " to Score");
	}
}

class StudentNumberException extends Exception
{
	public StudentNumberException (String number)
	{
		super ("You add " + number + " to studentNumber");
	}
}

public class _14211288_���_2_Student
{
	private String studentNumber;
	private String studentName;
	private int markForMaths;
	private int markForEnglish;
	private int markForScience;

	public _14211288_���_2_Student(String number, String name)
	{
		studentName = name;
		studentNumber = number;
		markForMaths = -1;
		markForEnglish = -1;
		markForScience = -1;
	}

	public _14211288_���_2_Student()
	{
		markForMaths = -1;
		markForEnglish = -1;
		markForScience = -1;
	}

	public String getNumber()
	{
		return studentNumber;
	}

	public String getName()
	{
		return studentName;
	}

	public void enterMarks(int markForMaths,
						   int markForEnglish,
						   int markForScience)
						   throws ScoreException
	{
		this.markForMaths = markForMaths;
		this.markForEnglish = markForEnglish;
		this.markForScience = markForScience;

		if (markForMaths > 100 || markForMaths < 0)
			throw new ScoreException (markForMaths);
		if (markForEnglish > 100 || markForEnglish < 0)
			throw new ScoreException (markForEnglish);
		if (markForScience > 100 || markForScience < 0)
			throw new ScoreException (markForScience);
	}

	public int getMathsMark()
	{
		return markForMaths;
	}

	public int getEnglishMark()
	{
		return markForEnglish;
	}

	public int getScienceMark()
	{
		return markForScience;
	}

	public double calculateAverage()
	{
		return (markForEnglish +
				markForMaths +
				markForScience) / 3.0;
	}

	public String toString()
	{
		return "ѧ��: " + studentNumber +
			   "\n����: " + studentName +
			   "\n��ѧ�ɼ�: " + markForMaths +
			   "\nӢ��ɼ�: " + markForEnglish +
			   "\n�Ƽ��ɼ�: " + markForScience +
			   "\nƽ���ɼ�: " + calculateAverage();
	}
}

class StudentTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		_14211288_���_2_Student student;

		while (true)
		{
			try
			{
				System.out.print("������ѧ��ѧ�ţ�");
				String number = input.next();
				
				if (number.length () != 10 ||
					number.charAt (0) != '2' ||
					number.charAt (1) != '0')
					throw new StudentNumberException (number);
				try
				{
					Integer.parseInt (number); 
				}
				catch (Exception e)
				{
					throw new StudentNumberException (number);
				}

				System.out.print("������ѧ��������");
				String studentName = input.next();

				student = new _14211288_���_2_Student(number, studentName);
				input.nextLine();
				break;
			}
			catch (Exception e)
			{
				System.out.println("ѧ�Ÿ�ʽ����ȷ������������");
			}
		}

		while (true)
		{
			try
			{
				System.out.print("������ѧ�����ſγɼ�����ѧ��Ӣ���ѧ����");
				String[] strs = input.nextLine().split(",");
				student.enterMarks(Integer.parseInt(strs[0].trim()),
								   Integer.parseInt(strs[1].trim()),
								   Integer.parseInt(strs[2].trim()));
				break;
			}
			catch (Exception e)
			{
				System.out.println("ѧ�Ÿ�ʽ����ȷ������������");
			}
		}

		System.out.println("ѧ����Ϣ����: ");
		System.out.println(student);
	}
}