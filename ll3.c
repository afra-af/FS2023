/* split ll with positive and negative as separate list*/

#include<stdio.h>
#include<stdlib.h>
struct node{
    int num;
    struct node *next;
};
struct node *head=NULL,*temp;
struct node *pos=NULL,*neg=NULL;
struct node *ptemp,*ntemp;
void createList(int s){
    struct node* cur = (struct node*)malloc(sizeof(struct node));
    cur->num=s;
    cur->next=NULL;
    if(head==NULL){
        head=temp=cur;
    }
    else{
        temp->next=cur;
        temp=cur;
    }
}
int main(){
    int n,k;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&k);
        createList(k);
    }
    struct node *a=head;
    while(a!=NULL){
        if(a->num>0){
            if(pos==NULL){
                pos=ptemp=a;
            }
            else{
                ptemp->next=a;
                ptemp=a;
            }
        }
        else{
            if(neg==NULL){
                neg=ntemp=a;
            }
            else{
                ntemp->next=a;
                ntemp=a;
            }
        }
        a=a->next;
    }
    while(pos!=NULL){
        printf("%d ",pos->num);
        pos=pos->next;
    }
    printf("\n");
    while(neg!=NULL){
        printf("%d ",neg->num);
        neg=neg->next;
    }
}
