#include <stdio.h>

int main(void){
	int arr[20],n,i;
	printf("Enter number of elements (less than 20)\n");
	scanf("%d",&n);

	for(int i = 0; i<n ; ++i){
		printf("Enter the value arry[%d] = ",i);
		scanf("%d",&arr[i]);
	}

	printf("\n");

	printf("We are now printing the values of the array\n\n");
	printf("[");
	for(int i = 0; i < n ; ++i){
		printf("%d",arr[i]);
		if(i < n-1) printf(",");
	}
	printf("]");
	printf("\n\n");


	int array[5] = {23,45,56,67,65};
	printf("[");
	for( int i = 0 ; i < 5 ; ++i) printf("%d ",array[i]);
	printf("]");

	int * ptr;
	ptr = array;
	printf("\n");
	for(int i = 0 ; i < 5 ; ++i) printf("array[%d] = %d\n",i,ptr[i]);
	printf("\n");

}
