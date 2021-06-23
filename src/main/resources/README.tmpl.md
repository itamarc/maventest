# Testing ITemplate on Maven

This project was created to test running a Maven project inside a Docker container.

This is my first step to in the future create an Action to auto-create the Page of
a GitHub project using [ITemplate](https://github.com/itamarc/itemplate) and the
GitHub API.

Considering that you have installed and properly configured these requisites:
- JDK 11
- Maven 3.8.1
- Docker

To build the Docker image:

    docker build -t maventest .

To run the image:

    docker run -v {path in host machine}/maventest/doc:/home/app/doc maventest:latest

The {path in the host machine} is where the README.md file will be saved,
outside the Docker container.

(For now, the 'lastupdate' is the only key available.)

Last auto generation: [# lastupdate #]
