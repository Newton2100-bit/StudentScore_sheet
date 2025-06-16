#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() {
    int pipe1[2]; // Parent -> Child
    int pipe2[2]; // Child -> Parent
    pid_t pid;
    char parent_msg[] = "Hi from parent";
    char child_msg[] = "Hi from child";
    char buffer[100];

    // Create both pipes
    if (pipe(pipe1) == -1 || pipe(pipe2) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    pid = fork();

    if (pid < 0) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {
        // Child process
        close(pipe1[1]); // Close write end of pipe1 (parent -> child)
        close(pipe2[0]); // Close read end of pipe2 (child -> parent)

        // Read from parent
        read(pipe1[0], buffer, sizeof(buffer));
        printf("Child received: %s\n", buffer);

        // Respond to parent
        write(pipe2[1], child_msg, strlen(child_msg) + 1);

        // Clean up
        close(pipe1[0]);
        close(pipe2[1]);
        exit(0);
    } else {
        // Parent process
        close(pipe1[0]); // Close read end of pipe1
        close(pipe2[1]); // Close write end of pipe2

        // Send message to child
        write(pipe1[1], parent_msg, strlen(parent_msg) + 1);

        // Read response from child
        read(pipe2[0], buffer, sizeof(buffer));
        printf("Parent received: %s\n", buffer);

        // Clean up
        close(pipe1[1]);
        close(pipe2[0]);
        wait(NULL);
    }

    return 0;
}
