#undef UNICODE

#include "server.h"

bool isFileExist (string filename) {
    HANDLE  hFindFile;
    WIN32_FIND_DATA  FileData;

    hFindFile = FindFirstFile ("resource\\*", &FileData);

    if (hFindFile == INVALID_HANDLE_VALUE) {
        return false;
    }
    else {
        FindNextFile (hFindFile, &FileData);
        char br[2] = { '\n','\0' };
        while (FindNextFile (hFindFile, &FileData)) {

            if (strstr (FileData.cFileName, filename.data ()) == NULL)
                continue;
            else {
                FindClose (hFindFile); //˵���ļ�����
                return true;
            }
        }
        FindClose (hFindFile);
        return false;
    }
}

bool openFile (FILE * * pfile, REQPacket packet) {
    int flag;
    string path = "resource\\";
    string filePath = path + packet.fileName;

    if (packet.opCode == RRQ) {
        // ���ļ�
        if (packet.mode == "octet" || packet.mode == "OCTET") {
            // ������
            flag = fopen_s (pfile, filePath.c_str (), "rb");
            if (flag == 0)
                return true;
            else
                return false;
        }
        else {
            // �ı�
            flag = fopen_s (pfile, filePath.c_str (), "r");
            if (flag == 0)
                return true;
            else
                return false;
        }
    }
    else {
        // д�ļ�
        if (packet.mode == "octet" || packet.mode == "OCTET") {
            // ������
            flag = fopen_s (pfile, filePath.c_str (), "wb");
            if (flag == 0)
                return true;
            else
                return false;
        }
        else {
            // �ı�
            flag = fopen_s (pfile, filePath.c_str (), "w");
            if (flag == 0)
                return true;
            else
                return false;
        }
    }
}

void closeFile (FILE * * pfile) {
    fclose (*pfile);
}

//buf�������������СΪ512�ֽ�,����ֵ��ʵ�ʶ������ַ���
int readFile (FILE * * pfile, char * buf) {
    int len = 0;
    clear (buf, DATA_LEN);
    len = fread (buf, 1, DATA_LEN, *pfile);
    return len;
}

//buf���������
void writeFile (FILE * * pfile, char * buf) {
    fwrite (buf, 1, DATA_LEN, *pfile);
}



