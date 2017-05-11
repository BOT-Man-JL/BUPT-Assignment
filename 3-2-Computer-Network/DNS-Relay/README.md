# DNS �м̷����� ʵ�鱨��

> by BOT Man, 2017

[heading-numbering]

## ϵͳ�Ĺ������

���һ�� DNS ���������򣬶��� **IP ��ַ-����** _(hosts)_ ���ձ����ͻ��˲�ѯ������Ӧ�� IP ��ַʱ�������������ö��ձ������ֿ��ܼ��������

- ������� IP ��ַ `0.0.0.0`������ͻ��˷��� **����������** �ı�����Ϣ��������վ���ع��ܣ�
- �������Ϊ��ͨ IP ��ַ������ͻ��˷��ظõ�ַ�����������ܣ�
- ����δ�쵽������������������ DNS ������������ѯ��������������ͻ��ˣ��м̹��ܣ�
  - ���Ƕ��������ϵĿͻ��˻�ͬʱ��ѯ����Ҫ������Ϣ ID ��ת��

## ģ�黮��

������Ҫ��Ϊ 5 ��ģ�飺��־ģ�顢����ģ�顢���ݰ�ģ�顢Socket ģ�� �� ������ģ�顣

### ��־ģ�� `DnsRelay::Logger`

- ��װ `std::ostream` �����в���
- ����ʱ������ʱ���
- ����ʱ��ˢ�ջ�������������־д���ļ���

### ����ģ�� `DnsRelay::Config`

- ��ȡ�����в�����ʾ�ַ���
- ��������в������ã�ȫ����ѡ��
  - ��־�ļ��� (`-o <log-file-name>`)
  - ������ DNS ������ IP (`-n <name-server-ip>`)
  - **IP ��ַ-����** _(hosts)_ ���ļ��� (`-h <hosts-file-name>`)
  - ��ѯ��������������ʱʱ�� (`-t <timeout-seconds>`)
- �����в�������� `std::ostream`

### ���ݰ�ģ�� `DnsRelay::Packet`

- �������ݰ�����
  - �����ַ
  - ��ͷ��
  - ��ѯ���Ķ�
  - ��Դ���Ķ�
- �� Socket �ֽ�����ȡ���ݰ�
- �����ݰ����� Socket �ֽ���
- �����ݰ���������� `std::ostream`

#### ��Դ���Ķ� `DnsRelay::Packet::Resource`

- ��Բ�ͬ���͵���Դ�����岻ͬ�Ľ�����ʽ
- ��Բ�ͬ���͵���Դ���Բ�ͬ��ʽ����� `std::ostream`

#### �ϸ����ݰ� `DnsRelay::StrictPacket`

- ���������֣�
  - ���ݰ�
  - Socket �ֽ���
- �������޸����ݰ��ģ�
  - �����ַ
  - ��ͷ��
- ���ϸ����ݰ���������� `std::ostream`

### Socket ģ�� `DnsRelay::Connector`

- �������ر� Socket
- ���� Socket �ֽ�����תΪ�ϸ����ݰ�
- �������ݰ����ϸ����ݰ�

### ������ģ�� `main`

- ��ʼ��
  - ��������ģ��
  - ������ DNS ��������ַ
  - **IP ��ַ-����** _(hosts)_ ��
  - ��־ģ��
  - ID ת����
  - Socket ģ��
- ����ҵ���߼���[sec|�������ͼ]��

## �������ͼ

![Flowchart](flowchart.svg)

<!--
recv=>inputoutput: ��������
isResponse=>condition: ��ѯ���ģ�
isStandardQuery=>condition: �����ѯ��
isAQuery=>condition: IPv4 ��ѯ��
isInTable=>condition: �ҵ����
isBlocked=>condition: `0.0.0.0`��
fromNameServer=>condition: ����ʱ��
fromNameServer2=>operation: ��ԭ ID �͵�ַ
toNameServer=>operation: ���� ID �͵�ַ
toNameServer2=>operation: ����Ϊ�� ID��
���������� DNS ��������ַ
setAns=>operation: д���
setBlocked=>operation: д�� δ�ҵ�
sendStrict=>inputoutput: �����ϸ����ݰ�
sendNew=>inputoutput: �������ݰ�
endRecv=>operation: ��ջ���
start=>start: ��ʼ

start->recv->isResponse
isResponse(yes,right)->fromNameServer
isResponse(no)->isStandardQuery
isStandardQuery(no)->toNameServer
isStandardQuery(yes)->isAQuery
isAQuery(no)->toNameServer
isAQuery(yes)->isInTable
isInTable(no)->toNameServer
isInTable(yes)->isBlocked
isBlocked(yes,right)->setBlocked->sendNew
isBlocked(no)->setAns->sendNew
toNameServer->toNameServer2->sendStrict
fromNameServer(yes,right)->endRecv
fromNameServer(no)->fromNameServer2->sendStrict
sendStrict->endRecv
sendNew->endRecv
endRecv(left)->recv
-->

## ���������Լ����н��

- ����ƽ̨
  - `Windows 10`
  - `Ubuntu 16.04`
- ���Թ���
  - `nslookup`
- ���Զ���
  - ��������
  - ��֪����
  - δ֪����

### ��������

### ��֪����

### δ֪����

## ���������������������

���������ʵ���ǣ��Ȱ��յ��İ������ɸ����ֶΣ�Ȼ�����޸����ݲ���װ����󷢳�ȥ��������������Ҫ�ڽ�������ʱ���������ؼ������⣺����ѹ������Դ����ʶ��

### ����ѹ��

#### ��������

����ѹ������һ��ָ��ָ��֮ǰ���ֹ��ĺ�׺���Ӷ������ظ��ļ�¼��Щ��׺�����磬`bupt.edu.cn` �� `www.bupt.edu.cn` ӵ�й�����׺�����ǰ���ȳ��֣���ô���߿���ѹ��Ϊ `www.` ��һ��ָ��ǰ�߿�ͷ��ָ�룻��������ȳ��֣���ôǰ�߿���ѹ��Ϊһ��ָ�� `www.bupt.edu.cn` �� `bupt` λ�õ�ָ�롣

�ʼ�İ汾û�п��ǵ�������⣬�����˽�����������������ȷ��

#### �������

������ԭ

### ��Դ����ʶ��

#### ��������

����ѹ�����������ڲ�ѯ�Ρ���Դ�ε������ֶΣ������ܳ�������Դ�ε������ֶΡ������ԭ�������ֶε�������������ԭ��Դ���ݵ��������Ϳ��ܵ�����Դ����ʧЧ�����磬��ԭ��ǰ�ߵ�һЩ������ʹ���������������󣬵�����������ָ��ָ���λ�û��ǻ�ԭǰ��λ�ã�������Щָ���ȫ��ʧЧ��

�ʼ�İ汾û�п��ǵ�������⣬�����˴������� DNS ���������ص����ݰ�������װ�󣬱��ͻ���ʶ��Ϊ���ܽ����İ���

#### �������

- ������Դ
- �����ϸ����ݰ���[sec|�ϸ����ݰ� `DnsRelay::StrictPacket`]��

## �γ���ƹ����ܽ�
