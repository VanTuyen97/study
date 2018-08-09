// TimKiemTrenDoThi.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <fstream>
#include "TreeString.h"
#include <iostream>
using namespace std;

int main()
{
	fstream file("..\\src\\sgb-words.txt", ios::in | ios::out);
	string line;
	TreeString * tree = new TreeString();
	while (!file.eof()) {
		getline(file, line);
		tree->addString(line);
		
	}
	file.close();
	int count = tree->countInterconnected();
	cout << "co " << count << "thanh phan lien thong" << endl;;
	cin >> line;
    return 0;
}

