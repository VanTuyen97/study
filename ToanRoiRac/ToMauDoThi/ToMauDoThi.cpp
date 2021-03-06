// ToMauDoThi.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <string>
#include <fstream>
#include <iostream>
#include <stdlib.h> 
using namespace std;

void resetArray(int ** array, int x, int y);//đặt tất cả giá trị mảng bằng 0
void resetArray(int * array, int x);//đặt tất cả giá trị mảng bằng 0
int maxDeg(int ** array, int x, int y);//tìm bậc lớn nhất của đỉnh trong ma trận kề
int getPoint();//lấy đỉnh có bậc nhỏ hơn bậc lơn nhất
void drawColor();//sắp xếp và tô màu các đỉnh của đồ thị 
void setColor(int point);//tô màu cho một đỉnh (point)

string * colors;
int **edgeMatrix;//ma trận kề chứa các cạnh
int n;//lưu số đỉnh của đồ thị;
int numberEdge;//lưu số cạnh của đồ thị
int * color;//danh sách màu của các đỉnh
int * sortPoint;//danh sách thứ tự duyệt đỉnh
int **edgeList;//lưu danh sách cạnh của đồ thị

int main()
{
	//khởi tạo màu sắc
	colors = new string[10];
	colors[0] = "red";
	colors[1] = "black";
	colors[2] = "brown";
	colors[3] = "grey";
	colors[4] = "white";
	colors[5] = "yellow";
	colors[6] = "orange";
	colors[7] = "pink";
	colors[8] = "purple";
	colors[9] = "blue";

	fstream file("..\\src\\dothi.txt", ios::in | ios::out);
	string line;
	int x, y;//chứa các đỉnh kề của một cạnh

	if (!file.eof()) {//đọc dòng đầu tiên ghi hai số nguyên n và m là số đỉnh và số cạnh của đồ thị
		getline(file, line);
		n = atoi(line.c_str());//lấy số đỉnh của đồ thị
		line = line.substr(line.find(' ') + 1);//cắt xâu thành xâu con bắt đầu từ sau dấu whitespace
		numberEdge = atoi(line.c_str());//lấy số cạnh của đồ thị
	}

	edgeList = new int*[numberEdge];
	for (int i = 0; i < numberEdge; i++) {
		edgeList[i] = new int[2];
	}

	sortPoint = new int[n];//chứa danh sách đã sắp xếp
	color = new int[n];//chứa màu của các đỉnh,vd đỉnh 2 có màu color[1]
	resetArray(color, n);

	//khởi tạo mảng hai chiều chứa ma trận kề
	edgeMatrix = new int*[n];
	for (int i = 0; i < n; i++) {
		edgeMatrix[i] = new int[n];
	}
	resetArray(edgeMatrix, n, n);

	int j = 0;
	//đọc dữ liệu từ một file vào ma trận kề
	while (!file.eof()) {
		getline(file, line);
		if (line.empty())//dòng rỗng
			continue;
		x = atoi(line.c_str());//chuyển sâu thành số
		x -= 1;
		line = line.substr(line.find(' ') + 1);//cắt xâu thành xâu con bắt đầu từ sau dấu whitespace
		y = atoi(line.c_str());
		y -= 1;
		edgeMatrix[x][y] = 1;
		edgeMatrix[y][x] = 1;
		edgeList[j][0] = x;
		edgeList[j][1] = y;
		j++;
	}
	
	drawColor();//tô màu đồ thị
	
	fstream fileOutput("..\\src\\dothitomau.dot", ios::out);
	fileOutput << "graph dothi\n";
	fileOutput << "{\n";
	for (int i = 0; i < n; i++) {
		int index = sortPoint[i] - 1;
		int indexColor = color[index];
		fileOutput << "\t" << sortPoint[i] << " [fillcolor=" << colors[indexColor] << ", style=filled];\n";
	}
	for (int i = 0; i < numberEdge; i++) {
		fileOutput << "\t" << edgeList[i][0] << " -- " << edgeList[i][1] << ";\n";
	}
	fileOutput << "}";
    return 0;
}

void resetArray(int ** array, int x, int y) {
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			array[i][j] = 0;
		}
	}
}

void resetArray(int * array, int x) {
	for (int i = 0; i < x; i++) {
		array[i] = 0;
	}
}

int maxDeg(int ** array, int x, int y) {
	int max = 0;
	int current = 0;
	for (int i = 0; i < x; i++) {
		if (max < current)
			max = current;
		current = 0;
		for (int j = 0; j < y; j++) {
			if (array[i][j] == 1)
				current++;
		}
	}
	return max;
}

int getPoint() {
	int point = 2;
	int old = 0;
	int current = 0;
	for (int j = 0; j < n; j++) {//lấy bậc của đỉnh đầu tiên
		if (edgeMatrix[0][j] == 1)
			old++;
	}

	for (int i = 1; i < n; i++) {//duyệt từ đỉnh thứ 2 đến hết 
		for (int j = 0; j < n; j++) {
			if (edgeMatrix[i][j] == 1)
				current++;
		}

		//gặp đỉnh có bậc nhỏ hơn thì trả về đỉnh đó
		if (old == current){
			point++;
			current = 0;
		}
		else if (old < current) {
			return point - 1;
		}
		else {
			return point;
		}
	}
	return 1;//là đồ thị chính quy
}

void drawColor() {
	int * sorted = new int[n];//đánh dấu các đỉnh, 1 là đỉnh đã sắp xếp
	resetArray(sorted, n);

	int begin = 0, end = 1, current = 1;

	int point = getPoint();//lấy đỉnh đầu tiên
	point -= 1;
	setColor(point);//gán màu cho đỉnh
	sortPoint[0] = point +1;
	sorted[point] = 1;

	while (current != n) {//lấy đến khi hết tất cả các đỉnh
		for (int i = begin; i < end; i++) {//lấy các đỉnh kề của các đỉnh đã sắp xếp
			point = sortPoint[i] -1;
			for (int j = 0; j < n; j++) {
				if ((edgeMatrix[point][j] == 1) && (sorted[j] == 0)) {//nếu đỉnh kề và chưa được sắp xếp thì sắp xếp
					sortPoint[current] = j + 1;
					setColor(j);
					sorted[j] = 1;//đỉnh đã tô màu
					current++;
				}
			}
		}

		if (current == end) {//đồ thị không liên thông thì chọn một đỉnh chưa sắp xếp để sắp xếp tiếp
			for (int i = 0; i < n; i++) {
				if (sorted[i] == 0) {
					sortPoint[current] = i + 1;
					setColor(i);
					sorted[i] = 1;
					current++;
				}
			}
		}

		begin = end;
		end = current;
	}
}

void setColor(int point) {
	int size = n + 1;//bắt đầu tính từ phần tử thứ nhất
	int * buffer = new int[size];//các màu đã tô sẽ gán là 1, chưa tô gán là 0. độ rộng là n vì sẽ tô không quá n màu
	resetArray(buffer, size);
	int indexColor;
	for (int i = 0; i < n; i++) {
		if ((edgeMatrix[point][i] == 1) && (color[i] != 0)) {//tìm đỉnh kề đã tô màu của đỉnh cần tô màu
			indexColor = color[i];
			buffer[indexColor] = 1;//đánh dấu màu này đã được tô màu
		}
	}
	
	for (int i = 1; i < size; i++) {
		if (buffer[i] == 0) {//tìm màu nhỏ nhất chưa được tô
			color[point] = i;//tô màu cho đỉnh đó
			break;
		}
	}
}