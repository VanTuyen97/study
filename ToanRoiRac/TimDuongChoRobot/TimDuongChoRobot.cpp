// TimDuongChoRobot.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Graph.h"
#include <fstream>
#include <string>
#include <iostream>
using namespace std;

int main()
{
	fstream file("..\\src\\dothirobot.txt", ios::in | ios::out);
	string line;
	int numberPoint;
	int numberEdge;
	int begin1, begin2, destination1, destination2, radius;
	getline(file, line);
	numberPoint = atoi(line.c_str());
	line = line.substr(line.find(' ') + 1);
	numberEdge = atoi(line.c_str());
	Graph graph(numberPoint);
	for (int i = 0; i < numberEdge; i++) {
		getline(file, line);
		int point1 = atoi(line.c_str());//lấy số đỉnh thu nhat của canh
		line = line.substr(line.find(' ') + 1);//cắt xâu thành xâu con bắt đầu từ sau dấu whitespace
		int point2 = atoi(line.c_str());//lấy số đỉnh thu hai của canh
		line = line.substr(line.find(' ') + 1);//cắt xâu thành xâu con bắt đầu từ sau dấu whitespace
		int weigh = atoi(line.c_str());//lấy trong so canh
		graph.addEdge(point1, point2, weigh);
	}

	getline(file, line);
	begin1 = atoi(line.c_str());
	line = line.substr(line.find(' ') + 1);
	destination1 = atoi(line.c_str());
	getline(file, line);
	begin2 = atoi(line.c_str());
	line = line.substr(line.find(' ') + 1);
	destination2 = atoi(line.c_str());
	getline(file, line);
	radius = atoi(line.c_str());

	graph.initRadius();
	
	cin >> line;
    return 0;
}

