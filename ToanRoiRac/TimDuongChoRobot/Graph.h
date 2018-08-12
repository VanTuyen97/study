#pragma once
using namespace std;

//chua do thi va mot buffer chua ban kinh cua hai canh bat ky
class Graph
{
public:
	int ** edge;//ma tran luu tru canh cua do thi > 0 la mot canh
private:
	int numberPoint;//so dinh
	int ** radius;//ma tran chua duong di ngan nhat giua hai dinh
public:
	Graph(int);
	void addEdge(int point1, int point2, int weigh);//them mot canh va trong so cua no
	void initRadius();//nap ban kinh ha dinh vao ma tran
	int getRadius(int point1, int point2);//lay ban kinh cua hai dinh
	vector<int> getNeighbor(int);//tim hang xom cua mot dinh
	~Graph();
private: 
	int * dijkstra(int);//dung thuat toan dijkstra tren voi mot dinh, tra ve khoang cach cua cac dinh khac den no
};

