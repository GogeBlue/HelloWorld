#include <stdio.h>
#include <stdlib.h>
#include "mi.h"

Student a = {1,"me"};

void printStu(void) {
	printf("%d\n", a.age);
	printf("%s\n", a.name);
}
