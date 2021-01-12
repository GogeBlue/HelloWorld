#include <stdio.h>
#include <stdlib.h>

void showArray(const int* arr, int length);
void reverseArray(int* arr, int length);
void* mallocmine(int size);

int main(int agrc, char* argv[]) {
    int a[] = {1,123,2,2,4,2,4,1,45,5,2};
    int l = sizeof(a) / sizeof(a[0]);
    int m = 0;
    reverseArray(a, l);
    showArray(a, l);
    printf(" ‰»Î¥Û–°£∫");
    scanf("%d",&m);
    int* p = mallocmine(m);
    free(p);
    return 0;
}
void reverseArray(int* arr, int length) {
    int min = 0;
    int max = length - 1;
    int temp;
    for (;min < max; max--, min++) {
        temp = arr[min];
        arr[min] = arr[max];
        arr[max] = temp;
    }
}
void showArray(const int* arr, int length) {
    int i;
    for (i = 0; i < length; i++) {
        printf("%d ", arr[i]);
    }
}

void* mallocmine(int size) {
    return malloc(size);
}