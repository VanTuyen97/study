#pragma once
#include "stdafx.h"
#include <string>
#include <vector>
#include <iostream>
using namespace std;

class TreeString
{
private:
	Node * head;
public:
	TreeString(); 
	bool addString(string point);//luu tru mot dinh vao cay
	vector<string> getNeighbor(string);//lay hang xom chua duyet cua mot dinh
	string getPointFree();//lay dinh chua duyet
	bool markVisited(string);//danh dau dinh la da tham
	int countInterconnected();//dem so thanh phan lien thong
	~TreeString();
private:
	Node * getLeaf(string);//lay nut la cua dinh
	int getIndexCharacter(char x);//lay so thu tu cua ky tu a->0, w->22
	void getNeighbor(vector<string> * vec, Node * current, string point, int deep, int ignore);//su dung de quy de tim dinh ke voi vi tri bo qua la ignore 
	string getPointFree(Node *, string);//lay dinh chua duyet bat dau tu mot nhanh
};