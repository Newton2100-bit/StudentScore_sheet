#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

int main() {
    int pipefd[2]; // pipefd[0] - read end, pipefd[1] - write end
    pid_t pid;
    char write_msg[] = "Hello from parent!";
    char read_msg[100];

    // Create a pipe
    if (pipe(pipefd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Create a child process
    pid = fork();

    if (pid < 0) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (pid > 0) {
        // Parent process
        close(pipefd[0]); // Close unused read end
        write(pipefd[1], write_msg, strlen(write_msg) + 1);
       close(pipefd[1]); // Close write end after writing
        wait(NULL); // Wait for child to finish
    } else {
        // Child process
        close(pipefd[1]); // Close unused write end
        read(pipefd[0], read_msg, sizeof(read_msg));
        printf("Child received message: %s\n", read_msg);
        close(pipefd[0]); // Close read end after reading
    }

    return 0;

