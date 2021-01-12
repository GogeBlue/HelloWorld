#include "LinkedList.h"

LinkedList create(int l) {
	if (l < 0) {
		return (LinkedList) 0;
	}
	
	// Initialize head node.
	int *ha = (int*) malloc(sizeof(int) * 16);
	ha[0] = l;
	Node head = {ha, NULL};
	LinkedList list = head.next;
	int i;
	int count = 0; 
	for (i = 1; i < l; i++) {
		list = (LinkedList) malloc(sizeof(Node));
		list->data = (int*) malloc(sizeof(int) * 16);
		list = list->next;
		if (count % 1000000 == 0) {
			printf("%s\n", "Hello Memory!");
		}
		count++;
	} 
	return &head;
}

int get(LinkedList const L, int i, int *e) {
	//Caculate which node the element is in.
	int nodeIndex = i / 16;
	int nodeArrIndex = i % 16 - 1;
	int j = 1;
	LinkedList p = L->next;
	while (p != NULL && j < nodeIndex) {
		p = p->next;
		++j;
	}
	if (i < j && p == NULL) {
		return FALSE;
	}
	*e = p->data[nodeArrIndex];
	return TRUE;
}

int insert(LinkedList L, int i, int e) {
	int nodeIndex = i / 16;
	int nodeArrIndex = i % 16 - 1;
	LinkedList p = L->next;
	int j = 1;
	int k;
	while (p != NULL && j < nodeIndex) {
		p = p->next;
		++j;
	}
	if (i < j && p == NULL) {
		return FALSE;
	}
	for (k = 15;k > nodeArrIndex; --k) {
		p->data[k+1] = p->data[k];
	}
	p->data[nodeArrIndex] = e;
	return TRUE;
}


