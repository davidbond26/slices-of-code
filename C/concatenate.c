

#include <stdio.h>

int main() {
	char s1[200];
	char s2[100];
	int s1Length = 0;
	int s2Length = 0;
	printf("Enter the first string: ");
	fgets(s1, 200, stdin);
	printf("Enter the second string: ");
	fgets(s2, 100, stdin);
	for (int i = 0; i < 100; i++) {
		if (s1[i] == '\n') break;
		s1Length++;
	}
	for (int i = 0; i < 100; i++) {
                if (s2[i] == '\n') break;
 		s2Length++;
	}
	int index = 0;
	do {
		s1[s1Length + index] = s2[index];
		index++;
	} while (index < s2Length);
	printf("%s\n", s1);
	return 0;
}
