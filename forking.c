#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
int main(int argc, char ** argv){
	pid_t pid = fork();

	if(pid > 0){
		int value = wait(NULL);
		printf("The value of the pid of our chld process is %d\n",value);
		printf("Parent process id is %d \n",getpid());
	}else{
		printf("Me as child my id is %d\n",getpid());
	}
	printf("Enter two number to find their sum :\n");
	int num1,num2,sum;
	scanf("%d %d",&num1,&num2);
	sum = num1,num2;
	printf("The sum of your values is %d\n",sum);
	return 0;
}

