#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(){
    int t,x1,y1,r1,x2,y2,r2,result;
    double distance;
    scanf("%d",&t);
    while(t>0){
        scanf("%d %d %d %d %d %d",&x1,&y1,&r1,&x2,&y2,&r2);
        distance=sqrt(pow(x1-x2,2)+pow(y1-y2,2));
        if(r1==r2&&distance==0)
            result=-1;
       else if(distance < r1 + r2 && (abs(r1-r2) < distance)) 
           result = 2;
       else if(distance == r1 + r2 || distance == abs(r1-r2)) 
           result = 1;
       else 
           result = 0;
        printf("%d\n",result);
        t--;
    }
    return 0;
}