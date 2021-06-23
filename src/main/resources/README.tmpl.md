### Testing ITemplate on Maven

This project was created to test running a Maven project inside a Docker container.

Considering that you have installed and properly configured these requisites:
- JDK 11
- Maven 3.8.1
- Docker

To build the Docker image:

    docker build -t maventest .

To run the image:

    docker run -v {path in host machine}/maventest/doc:/home/app/doc maventest:latest

The path in the host machine 

Last auto generation: [# lastupdate #]
