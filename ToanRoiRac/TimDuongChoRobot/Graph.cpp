#include "stdafx.h"
#include "Graph.h"
#include <vector>
#include <iostream>


Graph::Graph(int numberPoint)
{
	this->numberPoint = numberPoint;
	//khoi tao ma tran ke
	this->edge = new int*[numberPoint];
	for (int i = 0; i < numberPoint; i++) {
		edge[i] = new int[numberPoint];
		for (int j = 0; j < numberPoint; j++) {
			if (i == j)//cung la mot dinh
				edge[i][j] = 0;
			else//khong la canh
				edge[i][j] = -1;
		}
	}

	this->radius = new int*[numberPoint];
}

void Graph::addEdge(int point1, int point2, int weigh) {
	if ((point1 < this->numberPoint) && (point2 < this->numberPoint)) {
		this->edge[point1][point2] = weigh;
		this->edge[point2][point1] = weigh;
	}
}

int Graph::getRadius(int point1, int point2) {
	return this->radius[point1][point2];
}

vector<int> Graph::getNeighbor(int point) {
	vector<int> neighbor;
	for (int i = 0; i < this->numberPoint; i++) {
		if (this->edge[point][i] > 0)
			neighbor.push_back(i);
	}
	return neighbor;
}

Graph::~Graph()
{
}

void Graph::initRadius() {
	for (int i = 0; i < this->numberPoint; i++)
	{
		this->radius[i] = this->dijkstra(i);
	}
}

int * Graph::dijkstra(int point) {
	int * dist = new int[this->numberPoint];//chua khoang cach tam thoi
	bool * mark = new bool[this->numberPoint];//danh dau 0 - chua duyet dinh nay, 1 da duyet dinh nay
	int minPoint = 0;
	vector<int> listPoint;//chua cac dinh da duoc gan gia tri tam thoi
	for (int i = 0; i < this->numberPoint; i++) {
		dist[i] = -1;//chua gan gia tri cho dinh nay
		mark[i] = false;//chua duyet
	}
	dist[point] = 0;
	listPoint.push_back(point);

	while (listPoint.size() > 0) {
		int minPoint = listPoint[0];
		int length = listPoint.size();
		int indexVector = 0;
		for (int i = 1; i < length; i++) {//tim dinh co khoang cach nho nhat
			if (dist[minPoint] > dist[i]) {
				minPoint = listPoint[i];
				indexVector = i;
			}
		}

		listPoint.erase(listPoint.begin() + indexVector);//xoa dinh trong vector

		for (int i = 0; i < this->numberPoint; i++)
		{
			if ((this->edge[minPoint][i] > 0) && (mark[i] == false)) {//la dinh ke va chua duyet
				if (dist[i] == -1) {//chua la dinh tam thoi
					dist[i] = dist[minPoint] + this->edge[minPoint][i];
					listPoint.push_back(i);
				}else if(dist[i] > dist[minPoint] + this->edge[minPoint][i]) {//la dinh tam thoi co khang cach lon hon khoang cach tu min + trong so canh
					dist[i] = dist[minPoint] + this->edge[minPoint][i];
				}
			}
		}
		mark[minPoint] = true;
	}
	return dist;
}

bool isMarked(bool * mark, int size) {//toan bo thanh phan trong mang la true
	for (int i = 0; i < size; i++) {
		if (mark[i] == false)
			return false;
	}
	return true;
}
