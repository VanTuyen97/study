#include "stdafx.h"
#include "TreeString.h"
#include <algorithm>
#include <queue>

TreeString::TreeString()
{
	this->head = new Node();
	this->head->index = 0;
}

bool TreeString::addString(string point) {
	if (point.length() != 5)//neu do dai xau khac 5
		return false;

	std::transform(point.begin(), point.end(), point.begin(), ::tolower);//chuyen chu hoa thanh thuong

	int index[5];//chua vi tri cua node cac ky tu trong xau
	for (int i = 0; i < 5; i++) {//khoi tao danh sach index
		if ((index[i] = this->getIndexCharacter(point.at(i))) == -1)//neu khong phai la chu
			return false;
	}

	Node * current = head;
	int indexChar;
	for (int i = 0; i < 5; i++) {//luu xau
		indexChar = index[i];
		if (current->child[indexChar] == nullptr) {//tao node cho ky tu hien tai neu chua co.
			current->child[indexChar] = new Node();
			current->child[indexChar]->character = point.at(i);
			current->child[indexChar]->index = indexChar;
			if (i == 4) {
				current->child[indexChar]->isleaf = true;//danh dau la nut la
			}
		}
		current = current->child[indexChar];
	}
}

vector<string> TreeString::getNeighbor(string point) {//su dung khu de quy
	vector<string> vec;
	for (int i = 0; i < 5; i++) {//vi tri khac tu mot den 5
		this->getNeighbor(&vec, head, point, -1, i);
	}
	return vec;
}

void TreeString::getNeighbor(vector<string> * vec, Node * current, string point, int deep, int ignore) {
	if (current->visted == VISITED)//cac phan tu trong nhanh nay da duyet het
		return;

	if ((deep == ignore)) {
		point.at(deep) = current->character;
		if (current->isleaf) {//la node can bo qua va la nut la
			if (current->visted == NONE)//dinh nay chua duyet
				(*vec).push_back(point);
		}else {//la node can bo qua va khong la nut la
			deep += 1;
			int index = this->getIndexCharacter(point.at(deep));
			if (current->child[index] != nullptr) {//co kha nang la dinh ke
				this->getNeighbor(vec, current->child[index], point, deep, ignore);
			}
		}

	}else{
		if (current->isleaf) {//khong la node can bo qua va la nut la
			if (current->visted == NONE)//dinh nay chua duyet
				(*vec).push_back(point);
		}
		else {//khong la node can bo qua va khong la nut la
			deep += 1;
			if (deep == ignore) {//nut tiep theo la nut can bo qua
				for (int i = 0; i < 23; i++) {
					if (current->child[i] != nullptr) {
						this->getNeighbor(vec, current->child[i], point, deep, ignore);
					}
				}
			}
			else {//nut tiep theo la nut khong can bo qua
				int index = this->getIndexCharacter(point.at(deep));
				if (current->child[index] != nullptr) {//co kha nang la dinh ke
					this->getNeighbor(vec, current->child[index], point, deep, ignore);
				}
			}
		}
	}
}

int TreeString::getIndexCharacter(char x) {
	int index = (int)x;
	index -= 97;//tinh so thu tu
	if ((index < 0) || (index > 22))//khong phai la ky tu thuong
		return -1;
	else
		return index;
}

string TreeString::getPointFree() {
	string result;
	string empty;
	for (int i = 0; i < 23; i++) {
		if ((head->child[i] != nullptr) && (head->child[i]->visted == NONE)) {//neu co nhanh nay
			result = this->getPointFree(head->child[i], empty);
			if (result.length() == 5)
				return result;
		}
	}
	return empty;
}

bool TreeString::markVisited(string point) {//danh dau dinh la da tham
	Node * leaf = this->getLeaf(point);
	if (leaf == nullptr)
		return false;
	else {
		leaf->visted = VISITED;
		return true;
	}
}

int TreeString::countInterconnected() {//dem so thanh phan lien thong
	int count = 0;//so thanh phan lien thong
	string current;
	vector <string> pointNeighbor;//chua cac hang xom chua duyet
	queue <string> queuePoint;
	while ((current = this->getPointFree()).length() == 5) {//duyet den khi khong con dinh chua duyet
		queuePoint.push(current);
		this->markVisited(current);//danh dau da duyet dinh nay
		while (!queuePoint.empty()) {//duyet den het thanh phan lien thong
			current = queuePoint.front();//lay dinh tu hang doi
			queuePoint.pop();
			pointNeighbor = this->getNeighbor(current);//lay hang xom
			int length = pointNeighbor.size();
			for (int i = 0; i < length; i++) {//dua dinh vao hang doi
				queuePoint.push(pointNeighbor[i]);
				this->markVisited(pointNeighbor[i]);//danh dau la da duyet dinh nay
			}
		}
		count++;
	}
	return count;
}

void TreeString::resetMark(){//bo danh dau cho toan bo cay
	this->resetMark(head);
}

vector <string> TreeString::shortDist(string u, string v) {//tim dương di ngan nhat tu u den v
	this->resetMark();
	std::transform(u.begin(), u.end(), u.begin(), ::tolower);//chuyen chu hoa thanh thuong
	std::transform(v.begin(), v.end(), v.begin(), ::tolower);//chuyen chu hoa thanh thuong
	vector<string> dist;
	if (this->getLeaf(u) == nullptr)
		return dist;
	if (this->getLeaf(v) == nullptr)
		return dist;
	this->dijkstra(u);//dung thuat toan dijkstra

	//lay duong di
	Node * current;
	string point;
	if ((current = this->getLeaf(v))->visted != VISITED)//dinh v khong nam trong cung thanh phan lien thong voi u
		return dist;
	dist.push_back(v);
	while(current->prev.compare(u) != 0){
		dist.push_back(current->prev);
		current = this->getLeaf(current->prev);
	}
	dist.push_back(u);
	return dist;
}

void TreeString::resetMark(Node * current) {//bo danh dau cho mot nhanh
	current->visted = NONE;
	current->dist = -1;
	if (current->isleaf)//la nut la
		return;

	for (int i = 0; i < 23; i++) {
		if (current->child[i] != nullptr) {
			resetMark(current->child[i]);
		}
	}
}

void TreeString::dijkstra(string point) {//dung thuat toan dijkstra voi dinh point
	vector<string> listPoint;//chua cac dinh va do dai tam thoi cua chung
	vector<string> pointNeighbor;//chua cac dinh ke
	Node * leaf;
	listPoint.push_back(point);
	leaf = this->getLeaf(point);
	leaf->dist = 0;
	leaf->visted = TEMPORATY;//danh dau la chua gia tri tam thoi

	while (listPoint.size() > 0) {
		string min = listPoint[0];//dinh co khoang cach nho nhat
		int length = listPoint.size();
		int indexMin = 0;
		for (int i = 1; i < length; i++) {//tim dinh co do dai nho nhat
			if ((this->getLeaf(min)->dist) > (this->getLeaf(listPoint[i])->dist)) {//neu khoang cach min lon hon khoang cach dinh hien tai thi thay the min
				min = listPoint[i];
				indexMin = i;
			}
		}
		listPoint.erase(listPoint.begin() + indexMin);//xoa dinh

		pointNeighbor = this->getNeighbor(min);//tim cac dinh hang xom
		length = pointNeighbor.size();
		Node * leafMin = this->getLeaf(min);
		for (int i = 0; i < length; i++) {
			Node * leaf = this->getLeaf(pointNeighbor[i]);
			if ((leaf->dist == -1) || (leafMin->dist + 1 < leaf->dist)) {//neu dinh ke co khang cach lơn hon khoang cach tu min + 1
				leaf->dist = leafMin->dist + 1;
				leaf->prev = min;
				if (leaf->visted == NONE) {
					listPoint.push_back(pointNeighbor[i]);
					leaf->visted = TEMPORATY;//danh dau la dinh co gia tri tam thoi
				}
			}
		}
		leafMin->visted = VISITED;
	}
}

Node * TreeString::getLeaf(string point) {//lay nut la cua dinh
	int indexNode[5];
	Node *leaf;
	for (int i = 0; i < 5; i++) {//lay vi tri
		indexNode[i] = this->getIndexCharacter(point.at(i));
	}
	leaf = head;
	for (int i = 0; i < 5; i++) {
		int index = indexNode[i];
		leaf = leaf->child[index];
		if (leaf == nullptr)
			return nullptr;
	}
	return leaf;
}

string TreeString::getPointFree(Node * current, string str) {//lay dinh chua duyet bat dau tu mot nhanh
	string empty;
	string character(1,current->character);
	str.append(character);
	if (current->visted == VISITED)//neu nhan nay da duyet
		return empty;

	if (current->isleaf) {//la nut la
		if (current->visted == NONE)
			return str;
	}

	for (int i = 0; i < 23; i++) {
		if (current->child[i] != nullptr) {
			string point = this->getPointFree(current->child[i], str);
			if (point.length() == 5)
				return point;
		}
	}
	current->visted = VISITED;//danh dau nhanh nay da duyet het
	return empty;
}

TreeString::~TreeString()
{
}
