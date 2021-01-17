#include <iostream>
#include <string>
using namespace std;

struct Stu {
	int age;
	string name;
};

void allocateMem(Stu** p) {
	(*p) = (Stu*)malloc(sizeof(Stu));
	if (*p != NULL) {
		(*p)->age = 10;
	}
}

bool isLargerThan2(int a) {
	return a > 2;
}

void doingForLoop(int num) {
	for (int i = 0; i < num; i++) {
		cout << "HelloWorld" << endl;
	}
}

int main() {
	Stu* s = NULL;
	allocateMem(&s);
	cout << s->age << endl;
	cout << "HelloWorld" << endl;
	cout << isLargerThan2(100) << endl;
	int a;
	cin >> a;
	doingForLoop(a);
	system("pause");
	return EXIT_SUCCESS;
}