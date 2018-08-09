// stdafx.h : include file for standard system include files,
// or project specific include files that are used frequently, but
// are changed infrequently
//

#pragma once

#include "targetver.h"

#include <stdio.h>
#include <tchar.h>
#include <array>
using namespace std;


// TODO: reference additional headers your program requires here
enum Visit {
	VISITED,// khong duoc duyet nua
	TEMPORATY,//có gia tri tam thoi
	NONE//chua duyet lan nao
};


struct Node {
	Node() {
		for (int i = 0; i < 23; i++) {
			child[i] = nullptr;
		}
	};//constructtor của Node
	char character;
	int index;//vi tri cua doi tuong trong mang
	Visit visted = NONE;
	array<Node*, 23> child;// danh sách chứa 23 ký tự có thể là node con của node hiện tại.
	bool isleaf = false;
	string prev;
	int dist = -1;
};