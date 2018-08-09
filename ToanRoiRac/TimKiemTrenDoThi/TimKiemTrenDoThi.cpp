// TimKiemTrenDoThi.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <fstream>
#include "TreeString.h"
#include <iostream>
using namespace std;

int main()
{
	cout << "dang tai..." << endl;
	fstream file("..\\src\\sgb-words.txt", ios::in | ios::out);
	string line;
	TreeString * tree = new TreeString();
	while (!file.eof()) {
		getline(file, line);
		tree->addString(line);
		
	}
	file.close();
	cout << "dang chay..." << endl;
	int count = tree->countInterconnected();
	cout << "co " << count << " thanh phan lien thong" << endl << endl;

	string u, v;
	cout << "tim duong di ngan nhat tu u den v" << endl;
	cout << "nhap vao dinh u: ";
	cin >> u;
	cout << "nhap vao dinh v: ";
	cin >> v;
	cout << "vui long doi 1 den 2 phut tuy theo toc do may tinh." << endl;
	vector <string> dist = tree->shortDist(u, v);
	int length = dist.size();
	for (int i = length -1; i >= 0; i--) {
		cout << dist[i];
		if(i  != 0){
			cout << ", ";
		}
	}
	cin >> line;
    return 0;
}

