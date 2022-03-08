// David Bond
// Assignment 4 pt. 1
// This program generates an array of random integers, takes a number to search for as input, and outputs the number of times that integer appears in the array.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	srand(time(0));
	int arr[15];
	int r;
	int num;
	printf("Generating array contents...\n[");
	for (int i = 0; i <= 14; i++) {
		r = rand() % 11;
		arr[i] = r;
		printf("%d", r);
		if (i != 14) printf(",");
	}
	printf("]");
	printf("\nEnter a number in the range 0 - 10: ");
	scanf("%d", &num);
	int count = 0;
	for (int i = 0; i <= 14; i++) {
		if (arr[i] == num) count++;
	}
	printf("The number %d appears %d times in the array.\n", num, count);
	return 0;
}
