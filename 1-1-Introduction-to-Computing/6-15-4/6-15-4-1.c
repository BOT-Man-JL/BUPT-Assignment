#include <stdio.h>

int main()
{
	int i, kind, num ;
	double sum = 0 ;
	
	for (i = 1; i <= 5; i++)
	{
		printf ("��%d�������:\n", i) ;
		kind = 0 ;
		
		while (kind != -1)
		{
			fflush (stdin) ;
			scanf ("%d,%d", &kind, &num) ;
			switch (kind)
			{
			case 1 :
				sum += 2.98 * num ;
				break ;
			case 2 :
				sum += 4.50 * num ;
				break ;
			case 3 :
				sum += 9.98 * num ;
				break ;
			case 4 :
				sum += 4.49 * num ;
				break ;
			case 5 :
				sum += 6.87 * num ;
				break ;
			}
		}
	}
	printf ("���������ܶ�Ϊ:%f\n", sum) ;
	return 0 ;
}
	
