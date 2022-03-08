// David Bond
// Assignment 6 pt. 2
// This program is a Rock Paper Scissors game!

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef enum {Rock = 1, Paper, Scissors} Rps;

int main() {
	srand(time(0));
	Rps rps;
	int playerChoice;
	int playerScore = 0;
	int compScore = 0;
	printf("Let's play Rock Paper Scissors!\n");
	while (1) {
	printf("Select a move:\n");
	printf("\t%d. Rock\n\t%d. Paper\n\t%d. Scissors\n\t0. Quit\n", Rock, Paper, Scissors);
	printf("Your choice: ");
	scanf("%d", &playerChoice);
	if (playerChoice == 0) {
		printf("Final Scores: Player %d, Computer %d.\nThank you for playing!\n", playerScore, compScore);
		break;
	}
	int compChoice = rand() % 3 + 1;
	switch (compChoice) {
		case Rock: printf("Computer chose: Rock\n"); break; 
		case Paper: printf("Computer chose: Paper\n"); break;
		case Scissors: printf("Computer chose: Scissors\n"); break;
	}
	switch (playerChoice) {
		case Rock: printf("You chose: Rock\n"); break; 
		case Paper: printf("You chose: Paper\n"); break;
		case Scissors: printf("You chose: Scissors\n"); break;
	}
	if (playerChoice == compChoice) printf("Tie!\n");
	else if(playerChoice == 1 && compChoice == 2) {
		printf("Computer wins!\n");
		compScore++;
	}
	else if(playerChoice == 2 && compChoice == 1) {
		printf("You win!\n");
		playerScore++;
	}
	else if(playerChoice == 2 && compChoice == 3) {
		printf("Computer wins!\n");
		compScore++;
	}
	else if(playerChoice == 3 && compChoice == 2) {
		printf("You win!\n");
		playerScore++;
	}
	else if(playerChoice == 3 && compChoice == 1) {
		printf("Computer wins!\n");
		compScore++;
	}
	else if(playerChoice == 1 && compChoice == 3) {
		printf("You win!\n");
		playerScore++;
	}
}
	return 0;
}
