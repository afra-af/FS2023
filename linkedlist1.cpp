/*

Linked List - Display names from the Specified n 

write a program to print all the names from the number specified  n 
Note - Use recursion only. 

Print all the elements from the number specified (N)

Assume n >=1 and <= Length of the Linked list

input=ram
shyam
tom
shiva
gopi
nagraju
3
output =
tom
shiva
gopi
nagraju

*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

static int n = 0;
static int count = 1;

typedef struct node{
    char name[50];
    struct node *next;
}student;

student *head = NULL;
student *current = NULL;

void printData(student *ptr){
    if(ptr == NULL){
        return;
    }
    if(count >= n){
        printf("%s\n", ptr -> name);
    }
    count++;
    printData(ptr -> next);
    
}

void insertData(char *c){
    student *std = (student *)malloc(sizeof(student));
    strcpy(std-> name, c);
    if(head == NULL){
        head = current = std;
    }else{
        current -> next = std;
        current = std;
    }
}

int main(){
    int i;
    int size;
    char name[50];
    scanf("%d", & size);
    for(i = 0; i < size; i++){
        scanf("%s", name);
        insertData(name);
    }
    scanf("%d", &n);
    student *ptr = head;
    printData(ptr);
}
