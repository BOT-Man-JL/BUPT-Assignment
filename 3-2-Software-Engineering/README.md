# �ֲ�ʽ�¿�ϵͳ�����ʵ��

> 2017 BUPT ������̴���ҵ
>
> ���̴��뼰����ĵ� ���� [MIT Э��](LICENSE) ����

## ����˵��

### ��������

- ���ԣ�C++ 14 / Qt (GUI Only)
- ϵͳ��
  - Windows 10
  - Ubuntu 16.04
- ������
  - [json](https://github.com/nlohmann/json)
  - bot-cs/bot-socket
  - [ORM-Lite](https://github.com/BOT-Man-JL/ORM-Lite)
  - [Qt 5](https://www.qt.io/)
- ��������
  - gcc/clang�������� Linux��
  - Visual Studio 2017 - MSVC 15�������� Windows��
  - Qt 5��ͼ�λ���
- ���ݿ⣺
  - [sqlite 3](https://sqlite.org/)���� ORM-Lite �ṩ��

### ��Ŀ�ļ�

- makefile/
  - [server-cli](makefile/server-cli)�������� ���ػ� Linux��
  - [client-cli](makefile/client-cli)�������� �ӿػ� Linux��
- vs-proj/
  - [Air-Conditioner.sln](vs-proj/Air-Conditioner.sln)
  - Air-Conditioner-Server/
    - [Air-Conditioner-Server.vcxproj](vs-proj/Air-Conditioner-Server/Air-Conditioner-Server.vcxproj)�������� ���ػ� Windows��
  - Air-Conditioner-Client/
    - [Air-Conditioner-Client.vcxproj](vs-proj/Air-Conditioner-Client/Air-Conditioner-Client.vcxproj)�������� �ӿػ� Windows��
- qt-proj/
  - Air-Conditioner-Server/
    - [Air-Conditioner-Server.pro](qt-proj/Air-Conditioner-Server/Air-Conditioner-Server.pro)��ͼ�λ� ���ػ���
  - Air-Conditioner-Client/
    - [Air-Conditioner-Client.pro](qt-proj/Air-Conditioner-Server/Air-Conditioner-Server.pro)��ͼ�λ� �ӿػ���

**����ǰ**����Ҫ��ѹ���������Դ�ļ���

- src/common/json/
  - [json.hpp](src/common/json/json.hpp.zip)
- src/server/ormlite/
  - [sqlite3.h](src/server/ormlite/sqlite3.h.zip)
  - [sqlite3.c](src/server/ormlite/sqlite3.c.zip)
  - [ormlite.h](src/server/ormlite/ormlite.h.zip)

### Դ�����ļ�

- src/common/
  - [common-model.h](src/common/common-model.h)������ ģ�ͣ�
  - [common-protocol.h](src/common/common-protocol.h)������ Э�飩
  - [json/json.hpp](src/common/json/json.hpp)��json �⣩
  - [bot-socket.h](src/common/bot-socket.h)��socket �⣩
  - [bot-cs.h](src/common/bot-cs.h)������ socket �ķ�����/�ͻ��˿�ܣ�
  - [common-view.h](src/common/common-view.h)������ ��ͼ�⣩
  - [cli-helper.h](src/common/cli-helper.h)������ �����п⣩
- src/server/
  - ormlite/��ORM Lite �⣩
  - ui/��Qt UI �ļ���
  - [server.cpp](src/server/server.cpp)�����ػ� ��������
  - [server-model.h](src/server/server-model.h)�����ػ� ģ�ͣ�
  - [server-service.h](src/server/server-service.h)�����ػ� ����ģ�飩
  - [server-protocol.h](src/server/server-protocol.h)�����ػ� Э��ģ�飩
  - [server-protocol-controller.h](src/server/server-protocol-controller.h)�����ػ� ����� ��������
  - [server-view-controller.h](src/server/server-view-controller.h)�����ػ� ��ͼ�� ��������
  - [server-view.h](src/server/server-view.h)�����ػ� ��ͼ / ��ͼ��������
  - [server-view-cli.h](src/server/server-view-cli.h)�����ػ� ��������ͼ��
  - [server-view-manager-cli.cpp](src/server/server-view-manager-cli.cpp)�����ػ� ��������ͼ��������
  - [server-view-gui.h](src/server/server-view-gui.h)�����ػ� ͼ�λ���ͼ��
  - [server-view-manager-gui.cpp](src/server/server-view-manager-gui.cpp)�����ػ� ͼ�λ���ͼ��������
  - [server-view-gui-qt.h](src/server/server-view-gui-qt.h)�����ػ� Qt ͼ�λ��ӿڣ�
  - [server-view-gui-qt.cpp](src/server/server-view-gui-qt.cpp)�����ػ� Qt ͼ�λ�ʵ�֣�
  - [log-helper.h](src/server/log-helper.h)��������ģ�飩
  - [time-helper.h](src/server/time-helper.h)��ʱ��ת��ģ�飩
- src/client/
  - ui/��Qt UI �ļ���
  - [client.cpp](src/client/client.cpp)���ӿػ� ��������
  - [client-model.h](src/client/client-model.h)���ӿػ� ģ�ͣ�
  - [client-protocol.h](src/client/client-protocol.h)���ӿػ� Э��ģ�飩
  - [client-controller.h](src/client/client-controller.h)���ӿػ� ��������
  - [client-view.h](src/client/client-view.h)���ӿػ� ��ͼ / ��ͼ��������
  - [client-view-cli.h](src/client/client-view-cli.h)���ӿػ� ��������ͼ��
  - [client-view-manager-cli.cpp](src/client/client-view-manager-cli.cpp)���ӿػ� ��������ͼ��������
  - [client-view-gui.h](src/client/client-view-gui.h)���ӿػ� ͼ�λ���ͼ��
  - [client-view-manager-gui.cpp](src/client/client-view-manager-gui.cpp)���ӿػ� ͼ�λ���ͼ��������
  - [client-view-gui-qt.h](src/client/client-view-gui-qt.h)���ӿػ� Qt ͼ�λ��ӿڣ�
  - [client-view-gui-qt.cpp](src/client/client-view-gui-qt.cpp)���ӿػ� Qt ͼ�λ�ʵ�֣�

#### ģ������ͼ

[![Dependency](docs/dependency.png)](docs/dependency.svg)

<!--
[common-protocol{bg:lightpink}]->[common-model{bg:palegoldenrod}]
[common-protocol]-.->[json{bg:lightgray}]
[bot-cs{bg:lightpink}]-.->[json]
[bot-cs]->[bot-socket{bg:lightpink}]

[client-model{bg:palegoldenrod}]->[common-model]
[client-view{bg:yellowgreen}]->[client-model]
[client-view-manager{bg:yellowgreen}]->[client-view]
[client-protocol{bg:lightpink}]-^[bot-cs]
[client-protocol]-.->[common-protocol]
[client-controller{bg:skyblue}]->[client-model]
[client-controller]->[client-view-manager]
[client-controller]->[client-protocol]
[client]->[client-protocol]
[client]->[client-view-manager]

[client-view-cli{bg:yellow}]-^[client-view]
[client-view-manager-cli{bg:yellow}]-^[client-view-manager]
[client-view-manager-cli]->[client-view-cli]
[client-view-manager-cli]->[client-controller]

[client-view-gui{bg:green}]-^[client-view]
[client-view-gui]-.->[Qt{bg:lightgray}]
[client-view-manager-gui{bg:green}]-^[client-view-manager]
[client-view-manager-gui]->[client-view-gui]
[client-view-manager-gui]->[client-controller]

[server-model{bg:palegoldenrod}]->[common-model]
[server-view{bg:yellowgreen}]->[server-model]
[server-view-manager{bg:yellowgreen}]->[server-view]
[server-service{bg:skyblue}]->[server-model]
[server-service]->[ORM-Lite{bg:lightgray}]
[server-view-controller{bg:skyblue}]->[server-service]
[server-view-controller]->[server-view-manager]
[server-protocol-controller{bg:skyblue}]->[server-service]
[server-protocol{bg:lightpink}]-^[bot-cs]
[server-protocol]-.->[common-protocol]
[server-protocol]->[server-protocol-controller]
[server]->[server-view-manager]
[server]->[server-protocol]

[server-view-cli{bg:yellow}]-^[server-view]
[server-view-manager-cli{bg:yellow}]-^[server-view-manager]
[server-view-manager-cli]->[server-view-cli]
[server-view-manager-cli]->[server-view-controller]

[server-view-gui{bg:green}]-^[server-view]
[server-view-gui]-.->[Qt{bg:lightgray}]
[server-view-manager-gui{bg:green}]-^[server-view-manager]
[server-view-manager-gui]->[server-view-gui]
[server-view-manager-gui]->[server-view-controller]
-->

### Э���ĵ�

> 2017 �ֲ�ʽ�¿�ϵͳ F �� ͨ��Э��

#### Json ��ʽ

``` json
PACKET = JSON_REQ | JSON_RES \0
```

> ����� socket �ַ����� ���ַ� '\0' ����

#### �ӿػ����� (Request)

``` json
JSON_REQ = {"request":ACTION, "param":PARAM}

ACTION = "auth" | "pulse"

1) ACTION = "auth"
  PARAM = {"room":ROOM_ID, "guest":GUEST_ID}
2) ACTION = "pulse"
  PARAM = {"room":ROOM_ID, "current":TEMP,
           "target":TEMP, "wind":WIND}

ROOM_ID = [string]
GUEST_ID = [string]
TEMP = [double]
WIND = 1 | 2 | 3
```

#### ���ػ����� (Response)

``` json
JSON_RES = {"success":SUCCESS, "response":RESPONSE}

SUCCESS = true | false

1) SUCCESS = false
  RESPONSE = ERR_MSG
2) SUCCESS = true
  RESPONSE = {"hasWind":HAS_WIND, "energy":ENERGY, "cost":COST,
              "on":SERVER_ON, "mode":MODE}

ERR_MSG = [string]
HAS_WIND = true | false
ENERGY = [double]
COST = [double]
SERVER_ON = true | false
MODE = 0 | 1
```

## ����ĵ�

1. [�����ȡ](docs/Requirements.md)
2. [��������������](docs/User-cases.md)
3. [�ṹ���������](docs/Requirements-Spec.md)
4. [����������](docs/OO-Design.md)
5. [�ṹ�����](docs/Structural.md)

## ������

- [John Lee](https://github.com/BOT-Man-JL)
- [@WalkerJG](https://github.com/WalkerJG)
- [@xtdong1001](https://github.com/xtdong1001)
- [@xiaokeZuo](https://github.com/xiaokeZuo)
- [@ZL96](https://github.com/ZL96)