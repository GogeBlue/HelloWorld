#ifndef _LINKEDLIST_H_
#define _LINKEDLIST_H_
#define TRUE 1
#define FALSE 0
#include <stdio.h>
#include <stdlib.h>
typedef struct Node {
	int *data; //Data Area
	struct Node *next;
} Node;

typedef struct Node* LinkedList;
/*
Create a LinkedList at a certain initial length.
*/
LinkedList create(int l);

/*
Get the element at certain index.
*/
int get(LinkedList const L, int i, int *e);

/*
Insert the element at certain index.
*/
int insert(LinkedList L, int i, int e);

/*
remove the element at certain index and reduce the index at 1 each time.
*/
//int remove(LinkedList L, int i);

/*
Free the LinkedList.
*/
//int clear(LinkedList L);

/*
Add one element at the last of the List.
*/
//int push(LinkedList L, int e);

/*
Remove one element at the last of the List
*/
int pop(LinkedList L);
#endif
