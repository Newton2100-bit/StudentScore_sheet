#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>
int main(void){
	FILE *ptr = NULL;
	ptr=fopen("./data.txt","w");
	if(ptr == NULL) assert(0);
	printf("Enter a string to write to the file \n");
	char text[100];
	scanf("%s",text);
	int fd = fileno(ptr);
	write(fd,text,sizeof text);
	fclose(ptr);
	return 0;
}
