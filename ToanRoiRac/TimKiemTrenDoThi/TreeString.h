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
	void resetMark();//bo danh dau cho toan bo cay
	vector <string> shortDist(string u, string v);//tim dương di ngan nhat tu u den v
	~TreeString();
private:
	void dijkstra(string point);//dung thuat toan dijkstra voi dinh point
	void resetMark(Node * current);//bo danh dau cho mot nhanh
	Node * getLeaf(string);//lay nut la cua dinh
	int getIndexCharacter(char x);//lay so thu tu cua ky tu a->0, w->22
	void getNeighbor(vector<string> * vec, Node * current, string point, int deep, int ignore);//su dung de quy de tim dinh ke voi vi tri bo qua la ignore 
	string getPointFree(Node *, string);//lay dinh chua duyet bat dau tu mot nhanh
};