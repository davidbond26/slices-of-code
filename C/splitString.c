//David Bond
//This program splits a string at each space in the string, and prints each word on a new line.


#include <stdio.h>
#include <stdlib.h>
#include <string.h>     
                                                                         
int splitString(char* ptrS, int start_index, char c) {
        int index = start_index;
        while(ptrS[index] !=c) {
                if(ptrS[index] == '\0') {return index;}
                index++;
        }
        return index;
}  
                    
int main() { 
        char txt[100];
        char nextWord[100];
        printf("Type text: ");
        
        fgets(txt, sizeof(txt), stdin);
        int start_index = 0, end_index = 0;

        do {
                end_index = splitString(txt, start_index, ' ');
                for (int i=start_index; i<end_index;i++) {
                        printf("%c",txt[i]);
                }
                printf("\n"); 
                start_index = end_index+1;
        }
        while (txt[end_index] !='\0');
        
        return 0;
}
