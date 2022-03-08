// David Bond
// This program takes an integer array of size 10 as input, removes duplicates, and outputs the array without duplicates.

#include <stdio.h>

int main() {
	int arr[10];
	int count = 0;
	int num;
	printf("Enter 10 integers to be in the array:\n");
	while (count < 10) {
		if (scanf("%d", &num) == 0) {
			printf("Invalid input.\n");
			while (getchar() != '\n');
		}
		else {
			arr[count] = num;
			count++;
		}
	}
	int length = 10;
	int offset = 0;
	for (int i = 0; i <= 8 - offset; i++) {
		for (int j = i + 1; j <= 9 - offset; j++) {
			while (arr[i] == arr[j] && 9 - offset >= j) {
				int temp = arr[j];
				for (int k = j; k <= 8 - offset; k++) {
					arr[k] = arr[k + 1];
				}
				arr[9 - offset] = temp;
				length--;
				offset++;
			}
		}
	}
	int newArr[length];
	for (int i = 0; i < length; i++) {
		newArr[i] = arr[i];
	}
	printf("New Array:\n[");
	for (int i = 0; i < length; i++) {
		printf("%d", newArr[i]);
		if (i != length - 1) printf(",");
	}
	printf("]\n");
	return 0;
}
