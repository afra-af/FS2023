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
so from beginning third value is '30' and from ending third value is 80. so swap both elements.*/

#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};

void push(struct Node** headRef, int data)
{
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = *headRef;
    *headRef = newNode;
}

void printList(struct Node *node)
{
    while (node)
    {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}

void swapNodes(struct Node **headRef, int k,int nn)
{
    struct Node *x=*headRef, *y=*headRef;
    int temp;
    int GG=nn-k;
    while(GG--){
        x=x->next;
    }
    while(--k){
        y=y->next;
    }
    temp=x->data;
    x->data=y->data;
    y->data=temp;

}    

int main(void)
{
    int nn;
    scanf("%d",&nn);
    int arr[nn]; 
    for(int i=0;i<nn;i++){
        scanf("%d",&arr[i]);
    }
    int n = sizeof(arr)/sizeof(arr[0]);

    struct Node* head = NULL;
    for (int i = n - 1; i >= 0; i--) {
        push(&head, arr[i]);
    }
    int k;
    scanf("%d",&k);
    swapNodes(&head, k,nn);
    printList(head);

    return 0;
}
