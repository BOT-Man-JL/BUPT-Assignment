# ����ͬ��

## Ҫ��

���γ�ʵ���������ԡ�Windows �ں�ʵ��̡̳�(����Ⱥ���ֱ�ȱ�������е��ҵ�����磬2002.9)��

�� Windows �����£�����һ������ n ���̵߳Ŀ��ƽ��̡����� n ���߳�����ʾ n �����߻�д�ߡ�ÿ���̰߳���Ӧ���������ļ���Ҫ�󣬽��ж�д�����������ź������Ʒֱ�ʵ�ֶ������Ⱥ�д�����ȵĶ���-д�����⡣

����-д������Ķ�д�������ƣ�
- д-д���⣻
- ��-д���⣻
- ��-������

�������ȵĸ������ƣ����һ������������ж�����ʱ������һ�������ڽ��ж���������ö��߿�ֱ�ӿ�ʼ��������

д�����ȵĸ������ƣ����һ������������ж�����ʱ������һд���ڵȴ����ʹ�����Դ����ö��߱���ȵ�û��д�ߴ��ڵȴ�״̬����ܿ�ʼ��������

���н����ʾҪ��Ҫ����ÿ���̴߳�����������д�������롢��ʼ��д�����ͽ�����д����ʱ�ֱ���ʾһ����ʾ��Ϣ����ȷ�����д���������Ӧ�Ķ�д�������ơ�

### ���������ļ���ʽ

���������ļ�����n �в������ݣ��ֱ�����������n ���߳��Ƕ��߻���д�ߣ��Լ���д�����Ŀ�ʼʱ��ͳ���ʱ�䡣ÿ�в������ݰ����ĸ��ֶΣ����ֶμ��ÿո�ָ���
- ��һ�ֶ�Ϊһ������������ʾ�߳���š���һ�ֶα�ʾ��Ӧ�߳̽�ɫ��R ��ʾ�����ǣ�W ��ʾд�ߡ�
- �ڶ��ֶ�Ϊһ����������ʾ��д�����Ŀ�ʼʱ�䡣�̴߳�������ʱ��Ӧʱ�䣨��λΪ�룩�󷢳��Թ�����Դ�Ķ�д���롣
- �����ֶ�Ϊһ����������ʾ��д�����ĳ���ʱ�䡣���̶߳�д����ɹ��󣬿�ʼ�Թ�����Դ�Ķ�д�������ò���������Ӧʱ�����������ͷŹ�����Դ��

������һ�����������ļ������ӣ�

```
1 R 3 5
2 W 4 5
3 R 5 2
4 R 6 5
5 W 5.1 3
```

## ����

����ʵ���������������У���ʹ�� Modern C++ ���±�д��

[`Reader-Writer.cpp`](Reader-Writer.cpp)

## �㷨

### ��������

``` cpp
// Resource to R/W
auto resource = CreateSemaphore (NULL, 1, 1, NULL);

// Reader Count
auto rmutex = CreateSemaphore (NULL, 1, 1, NULL);
size_t read_count = 0;
```

#### ����

``` cpp
WaitForSingleObject (rmutex, INFINITE);
read_count++;
if (read_count == 1)
    WaitForSingleObject (resource, INFINITE);
ReleaseSemaphore (rmutex, 1, NULL);

// Critical Section

WaitForSingleObject (rmutex, INFINITE);
read_count--;
if (read_count == 0)
    ReleaseSemaphore (resource, 1, NULL);
ReleaseSemaphore (rmutex, 1, NULL);
```

#### д��

``` cpp
WaitForSingleObject (resource, INFINITE);

// Critical Section

ReleaseSemaphore (resource, 1, NULL);
```

### д������

``` cpp
// Resource to R/W
auto resource = CreateSemaphore (NULL, 1, 1, NULL);

// Reader trying to enter
auto readTry = CreateSemaphore (NULL, 1, 1, NULL);

// Reader Count
auto rmutex = CreateSemaphore (NULL, 1, 1, NULL);
size_t read_count = 0;

// Writer Count
auto wmutex = CreateSemaphore (NULL, 1, 1, NULL);
size_t write_count = 0;
```

#### ����

``` cpp
WaitForSingleObject (readTry, INFINITE);

WaitForSingleObject (rmutex, INFINITE);
read_count++;
if (read_count == 1)
    WaitForSingleObject (resource, INFINITE);
ReleaseSemaphore (rmutex, 1, NULL);

ReleaseSemaphore (readTry, 1, NULL);

// Critical Section

WaitForSingleObject (rmutex, INFINITE);
read_count--;
if (read_count == 0)
    ReleaseSemaphore (resource, 1, NULL);
ReleaseSemaphore (rmutex, 1, NULL);
```

#### д��

``` cpp
WaitForSingleObject (wmutex, INFINITE);
write_count++;
if (write_count == 1)
    WaitForSingleObject (readTry, INFINITE);
ReleaseSemaphore (wmutex, 1, NULL);

WaitForSingleObject (resource, INFINITE);

// Critical Section

ReleaseSemaphore (resource, 1, NULL);

WaitForSingleObject (wmutex, INFINITE);
write_count--;
if (write_count == 0)
    ReleaseSemaphore (readTry, 1, NULL);
ReleaseSemaphore (wmutex, 1, NULL);
```

## �������

### ����

```
1 R 3 5
2 W 4 5
3 R 5 2
4 R 6 5
5 W 5.1 3
```

### ���

```
Reader Preference
Thread 1 - Reader  - Request
Thread 1 - Reader  - Begin
Thread 2 - Writer  - Request
Thread 3 - Reader  - Request
Thread 3 - Reader  - Begin
Thread 5 - Writer  - Request
Thread 4 - Reader  - Request
Thread 4 - Reader  - Begin
Thread 3 - Reader  - End
Thread 1 - Reader  - End
Thread 4 - Reader  - End
Thread 2 - Writer  - Begin
Thread 2 - Writer  - End
Thread 5 - Writer  - Begin
Thread 5 - Writer  - End
Writer Preference
Thread 1 - Reader  - Request
Thread 1 - Reader  - Begin
Thread 2 - Writer  - Request
Thread 3 - Reader  - Request
Thread 5 - Writer  - Request
Thread 4 - Reader  - Request
Thread 1 - Reader  - End
Thread 2 - Writer  - Begin
Thread 2 - Writer  - End
Thread 5 - Writer  - Begin
Thread 5 - Writer  - End
Thread 3 - Reader  - Begin
Thread 4 - Reader  - Begin
Thread 3 - Reader  - End
Thread 4 - Reader  - End
End
```