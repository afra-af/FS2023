/*given linked list and k value return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end(list is 1-indexed)

example:
input =5
1 2 3 4 5
2
1 4 3 2 5

explanation:
1->2->3->4->5
k=2 
so from beginning second value is '2' and from ending second value is 4. so swap both elements.


ex:
input =10
10 20 30 40 50 60 70 80 90 100
3
output =
10 20 80 40 50 60 70 30 90 100
k=3
so from beginning third value is '30' and from ending third value is 80. so swap both elements.

*/

#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
    int data;
    struct Node *next;
    struct Node *prev;
}node;

node *head = NULL;
node *last = NULL;

void insertData(int val){
    node *ptr = (node *)malloc(sizeof(node));
    ptr -> data = val;
    ptr -> next = NULL;
    ptr -> prev = NULL;
    if(head == NULL){
        head = last = ptr;
    }else{
        last -> next = ptr;
        ptr -> prev = last;
        last = ptr;
    }
}

void swap(int n){
    int temp;
    node *start = head;
    node *end = last;
    while(--n){
        start = start -> next;
        end = end -> prev;
    }
    temp = start -> data;
    start -> data = end -> data;
    end -> data = temp;
    
}

void print(){
    node *ptr = head;
    while(ptr != NULL){
        printf("%d ", ptr -> data);
        ptr = ptr -> next;
    }
}

int main(){
    int data, i, n, index;
    scanf("%d", &n);
    for(i = 0; i < n; i++){
        scanf("%d", &data);
        insertData(data);
    }
    scanf("%d", &index);
    swap(index);
    print();
    return 0;
}
