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
	if (current->visted)//cac phan tu trong nhanh nay da duyet het
		return;

	if ((deep == ignore)) {
		point.at(deep) = current->character;
		if (current->isleaf) {//la node can bo qua va la nut la
			if (current->visted == false)//dinh nay chua duyet
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
			if (current->visted == false)//dinh nay chua duyet
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
		if ((head->child[i] != nullptr) && (head->child[i]->visted == false)) {//neu co nhanh nay
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
		leaf->visted = true;
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
	if (current->visted)//neu nhan nay da duyet
		return empty;

	if (current->isleaf) {//la nut la
		if (current->visted == false)
			return str;
	}

	for (int i = 0; i < 23; i++) {
		if (current->child[i] != nullptr) {
			string point = this->getPointFree(current->child[i], str);
			if (point.length() == 5)
				return point;
		}
	}
	current->visted = true;//danh dau nhanh nay da duyet het
	return empty;
}

TreeString::~TreeString()
{
}
