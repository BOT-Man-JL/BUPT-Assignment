# ʵ�� 1��SimpleScalar �İ�װ������

> 2017/6/1

## ʵ��Ŀ��

��װʵ��ƽ̨����Ϥʵ�黷����Ϊ����ѧϰ��׼����

## ʵ��Ҫ��

1. � SimpleScalar��3.0e �汾��ģ���������������� hello world��д��ϸ�Ĵ���棬��ͼչʾ������̡�
2. ���� SimpleScalar ���������� Mibench�\auotomotive ��׼���԰���

## ʵ�黷��

- Ubuntu 16.04��docker �Դ���
- gcc 5.4��Ubuntu 16.04 �Դ���

## ʵ�鲽��

### ����ʵ�黷��

����ʵ��ʹ�� docker �ϵ� Ubuntu 16.04 �������еĲ����� docker ����ɣ�Ĭ���� `root`�����ô��ǣ�
- ���Ժܷ���Ļָ�ԭ����״̬������ֱ�Ӷ�ϵͳ����
- ��װ��ɺ󣬿��Ա��澵�񣬷���֮���ʵ��

``` bash
sudo apt-get install docker
docker run -i -t ubuntu:16.04
```

### ��װ������

���� docker �ϵľ���Ƚ�ԭʼ����Ҫ���ǰ�װʵ�����������

- ʹ�� `update` ���°�����Դ
- ��װ `git` �� `curl` ��������������Ҫ��Դ�ļ�
- ��װ `build-essential` `flex` `bison` ���� `gcc` ��������
- ��װ `libc6-dev-i386` ���ڱ���ϵͳ�������

``` bash
apt-get update
apt-get install -y git curl
apt-get install -y build-essential flex bison libc6-dev-i386
```

### ���û�������

- ���û�������
- ����ʵ����Ҫ��Ŀ¼

``` bash
export IDIR=/home/john
export HOST=i686-pc-linux
export TARGET=sslittle-na-sstrix
mkdir $IDIR
```

### ����ʵ����Ҫ���ļ�

- �ӹ������� `simple sim` �� `simple tools`
  - ʹ�� `curl -e` α�� **ͬ��** ������
- ��������վ���� `simple utils` �� `gcc-2.7.2.3` ���������
- �� `git` ������ ֮����Ҫ�� `ar` �� `ranlib`

``` bash
cd $IDIR
curl http://www.simplescalar.com/gatedftp.php3?simplesim-3v0e.tgz -e http://www.simplescalar.com/agreement.php3?simplesim-3v0e.tgz -o simplesim-3v0e.tgz  ## spoofing :-)
curl http://www.simplescalar.com/downloads/simpletools-2v0.tgz -o simpletools-2v0.tgz
curl http://www.cse.iitd.ernet.in/~cs5070217/csl718/simpleutils-990811.tar.gz -o simpleutils-990811.tar.gz
curl http://american.cs.ucdavis.edu/RAD/gcc-2.7.2.3.ss.tar.gz -o gcc-2.7.2.3.ss.tar.gz
git clone https://github.com/BOT-Man-JL/simple-scalar
```

Ϊ�˷��������˵����أ�������Ҫ���ļ��Ѿ��ŵ� https://github.com/BOT-Man-JL/simple-scalar �ֿ��С�

### ��װ Simple Utilities

- ��ѹԴ�ļ�
- �� `sed` ���Դ������� **ƴд����**��`yy_current_buffer` �滻Ϊ `YY_CURRENT_BUFFER`��
- ʹ�� `configure` ����
- ʹ�� `make` ���ɴ���

``` bash
cd $IDIR
tar -xf simpleutils-990811.tar.gz
rm simpleutils-990811.tar.gz

cd $IDIR/simpleutils-990811
find . -name ldlex.l -exec sed -i 's/yy_current_buffer/YY_CURRENT_BUFFER/g' {} \;  ## fix typo
./configure --host=$HOST --target=$TARGET --with-gnu-as --with-gnu-ld --prefix=$IDIR
make CFLAGS=-O
make install
```

### ��װ Simple Sim

- ��ѹԴ�ļ�
- ʹ�� `make` ���� `config-pisa` �� Ŀ�����
  - ��� `make` ��ʾ `my work is done here...` ��ʾ�ɹ�
- ʹ�� `update-alternatives` ��������������֮��ʵ��Ľ��У�����ʹ�û���������

``` bash
cd $IDIR
tar -xf simplesim-3v0e.tgz
rm simplesim-3v0e.tgz

cd $IDIR/simplesim-3.0
make config-pisa
make

update-alternatives --install /bin/sim-safe sim-safe $IDIR/simplesim-3.0/sim-safe 100
update-alternatives --install /bin/sim-outorder sim-outorder $IDIR/simplesim-3.0/sim-outorder 100
update-alternatives --install /bin/sim-sim-bpred sim-bpred $IDIR/simplesim-3.0/sim-bpred 100
```

### ���� Simple Tools �� gcc ���������

- ��ѹԴ�ļ�
- �滻 `sslittle-na-sstrix/bin/` ·���µ� `ar` �� `ranlib`
- �� `ar` �� `ranlib` ��ִ��Ȩ��

``` bash
cd $IDIR
tar -xf simpletools-2v0.tgz
tar -xf gcc-2.7.2.3.ss.tar.gz
rm simpletools-2v0.tgz
rm -rf gcc-2.6.3
rm gcc-2.7.2.3.ss.tar.gz

mv simple-scalar/ar $IDIR/sslittle-na-sstrix/bin/
mv simple-scalar/ranlib $IDIR/sslittle-na-sstrix/bin/
rm simple-scalar -rf
chmod +x $IDIR/sslittle-na-sstrix/bin/ar
chmod +x $IDIR/sslittle-na-sstrix/bin/ranlib
```

### ��һ�α��� gcc ���������

- ʹ�� `configure` ����
- �� `Makefile` �� 130 ��β������ `-I/usr/include`
- �� `protoize.c` �� 60 �У�`varargs.h` ��Ϊ `stdarg.h`
- �� `obstack.h` �� 341 �У�`next_free)++` ��Ϊ `next_free++)`
- ���� `cdefs.h`��`libc.a` �� `crt0.o` �ļ�
- ʹ�� `gcc -m32` ���� 32 λĿ��

``` bash
cd $IDIR/gcc-2.7.2.3
./configure --host=$HOST --target=$TARGET --with-gnu-as --with-gnu-ld --prefix=$IDIR
sed '130s/GCC_CFLAGS=$(INTERNAL_CFLAGS) $(X_CFLAGS) $(T_CFLAGS) $(CFLAGS) -I.\/include/GCC_CFLAGS=$(INTERNAL_CFLAGS) $(X_CFLAGS) $(T_CFLAGS) $(CFLAGS) -I.\/include -I\/usr\/include/g' Makefile -i
sed '60s/#include <varargs.h>/#include <stdarg.h>/g' protoize.c -i
sed '341s/next_free)++/next_free++)/g' obstack.h -i
cp ./patched/sys/cdefs.h ../sslittle-na-sstrix/include/sys/cdefs.h
cp ../sslittle-na-sstrix/lib/libc.a ../lib/
cp ../sslittle-na-sstrix/lib/crt0.o ../lib/
make LANGUAGES=c CFLAGS=-O CC="gcc -m32"
```

��һ�α����ᱨ��ԭ���Ǳ������Զ����ɵĴ��� `insn-output.c` �����⣩��

![First Time](imgs/first-time.png)

### �ڶ��α��� gcc ���������

- ʹ�� `sed` ���� `insn-output.c` ���г���ĵط�����β��һ�� `\`��
- ���±���

``` bash
cd $IDIR/gcc-2.7.2.3
sed 's/FIXME\\n/FIXME\\n\\/g' insn-output.c -i
make LANGUAGES=c CFLAGS=-O CC="gcc -m32"
```

�ڶ��α������ϴδ���ĵط��������룬���ᱨ��ԭ���Ǳ������Զ����ɵĴ��� `cxxmain.c` �ظ������� `malloc` �� `realloc`��

![Second Time](imgs/second-time.png)

### �����α��� gcc ���������

- ʹ�� `sed` ɾ�� `cplus-dem.c` �� 2978 �� 2979 ��
  - **����ͽ��岻һ��**����Ϊ�� `cxxmain.c` ���޸Ļ������� make ��ʱ��ʧЧ
- ���±��룬��α��벻�ᱨ��

``` bash
cd $IDIR/gcc-2.7.2.3
sed '2978s/.*//g' cplus-dem.c -i
sed '2979s/.*//g' cplus-dem.c -i
make LANGUAGES=c CFLAGS=-O CC="gcc -m32"
```

### ���� gcc �� enquire �� ��װ gcc ���������

- ʹ�� `sed` ���� Makefile �� enquire ��ȱʧ����
- make enquire
  - **����ͽ��岻һ��**�������ָ�� `-m32` �ᵼ�¹����� 64 λĿ�꣬��֮ǰ�� 32 λ��ƥ��
- ʹ�� `sim-safe` ���� `float.h-cross` ����
- ������ `install`
- ʹ�� `update-alternatives` ��������

``` bash
cd $IDIR/gcc-2.7.2.3
sed 's/ENQUIRE_CFLAGS =/ENQUIRE_CFLAGS = -D_GNU_SOURCE/g' Makefile -i
make enquire CC="gcc -m32"
sim-safe ./enquire -f > float.h-cross
make LANGUAGES=c CFLAGS=-O CC="gcc -m32" install

update-alternatives --install /bin/sgcc sgcc $IDIR/bin/sslittle-na-sstrix-gcc 100
```

### ���� SimpleScalar

- ���ɲ����ļ�
- ʹ�����ǹ����ĳ�����롢����

``` bash
mkdir $IDIR/test
cd $IDIR/test
printf '#include <stdio.h> \nmain () { printf ("hello world\\n"); }' > hello.c
sgcc hello.c -o hello
sim-safe hello > output_hello.txt
```

���Ϊ��

![Final](imgs/final.png)

## �����ű�

``` bash
# Install Packages

apt-get update
apt-get install -y curl git
apt-get install -y build-essential flex bison libc6-dev-i386  ## fix sys include hell

# Setup Env Vars

export IDIR=/home/john
export HOST=i686-pc-linux
export TARGET=sslittle-na-sstrix
mkdir $IDIR

# Download Files

cd $IDIR
curl http://www.simplescalar.com/gatedftp.php3?simplesim-3v0e.tgz -e http://www.simplescalar.com/agreement.php3?simplesim-3v0e.tgz -o simplesim-3v0e.tgz  ## spoofing :-)
curl http://www.simplescalar.com/downloads/simpletools-2v0.tgz -o simpletools-2v0.tgz
curl http://www.cse.iitd.ernet.in/~cs5070217/csl718/simpleutils-990811.tar.gz -o simpleutils-990811.tar.gz
curl http://american.cs.ucdavis.edu/RAD/gcc-2.7.2.3.ss.tar.gz -o gcc-2.7.2.3.ss.tar.gz
git clone https://github.com/BOT-Man-JL/simple-scalar

# Install SimpleUtils

cd $IDIR
tar -xf simpleutils-990811.tar.gz
rm simpleutils-990811.tar.gz

cd $IDIR/simpleutils-990811
find . -name ldlex.l -exec sed -i 's/yy_current_buffer/YY_CURRENT_BUFFER/g' {} \;  ## fix typo
./configure --host=$HOST --target=$TARGET --with-gnu-as --with-gnu-ld --prefix=$IDIR
make CFLAGS=-O
make install

# Install SimpleSim

cd $IDIR
tar -xf simplesim-3v0e.tgz
rm simplesim-3v0e.tgz

cd $IDIR/simplesim-3.0
make config-pisa
make

update-alternatives --install /bin/sim-safe sim-safe $IDIR/simplesim-3.0/sim-safe 100
update-alternatives --install /bin/sim-outorder sim-outorder $IDIR/simplesim-3.0/sim-outorder 100
update-alternatives --install /bin/sim-sim-bpred sim-bpred $IDIR/simplesim-3.0/sim-bpred 100

# Config SimpleTools and gcc

cd $IDIR
tar -xf simpletools-2v0.tgz
tar -xf gcc-2.7.2.3.ss.tar.gz
rm simpletools-2v0.tgz
rm -rf gcc-2.6.3
rm gcc-2.7.2.3.ss.tar.gz
mv simple-scalar/ar $IDIR/sslittle-na-sstrix/bin/
mv simple-scalar/ranlib $IDIR/sslittle-na-sstrix/bin/
rm simple-scalar -rf
chmod +x $IDIR/sslittle-na-sstrix/bin/ar
chmod +x $IDIR/sslittle-na-sstrix/bin/ranlib

# 1st Make gcc

cd $IDIR/gcc-2.7.2.3
./configure --host=$HOST --target=$TARGET --with-gnu-as --with-gnu-ld --prefix=$IDIR
sed '130s/GCC_CFLAGS=$(INTERNAL_CFLAGS) $(X_CFLAGS) $(T_CFLAGS) $(CFLAGS) -I.\/include/GCC_CFLAGS=$(INTERNAL_CFLAGS) $(X_CFLAGS) $(T_CFLAGS) $(CFLAGS) -I.\/include -I\/usr\/include/g' Makefile -i
sed '60s/#include <varargs.h>/#include <stdarg.h>/g' protoize.c -i
sed '341s/next_free)++/next_free++)/g' obstack.h -i
cp ./patched/sys/cdefs.h ../sslittle-na-sstrix/include/sys/cdefs.h
cp ../sslittle-na-sstrix/lib/libc.a ../lib/
cp ../sslittle-na-sstrix/lib/crt0.o ../lib/
make LANGUAGES=c CFLAGS=-O CC="gcc -m32"

# 2nd Make gcc

cd $IDIR/gcc-2.7.2.3
sed 's/FIXME\\n/FIXME\\n\\/g' insn-output.c -i
make LANGUAGES=c CFLAGS=-O CC="gcc -m32"

# 3rd Make gcc

cd $IDIR/gcc-2.7.2.3
sed '2978s/.*//g' cplus-dem.c -i
sed '2979s/.*//g' cplus-dem.c -i
make LANGUAGES=c CFLAGS=-O CC="gcc -m32"

# Make enquire and Install

cd $IDIR/gcc-2.7.2.3
sed 's/ENQUIRE_CFLAGS =/ENQUIRE_CFLAGS = -D_GNU_SOURCE/g' Makefile -i
make enquire CC="gcc -m32"
sim-safe ./enquire -f > float.h-cross
make LANGUAGES=c CFLAGS=-O CC="gcc -m32" install

update-alternatives --install /bin/sgcc sgcc $IDIR/bin/sslittle-na-sstrix-gcc 100

# Test

mkdir $IDIR/test
cd $IDIR/test
printf '#include <stdio.h> \nmain () { printf ("hello world\\n"); }' > hello.c
sgcc hello.c -o hello
sim-safe hello > output_hello.txt
```

## ʵ���ܽ�

����ʵ���У�ѧ�������ʹ�� Linux �µĹ��߽��� SimpleScalar �İ�װ�����ã�Ϊ֮���ʵ����׼����