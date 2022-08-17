@ECHO OFF
ECHO compiling...
mvn clean | mvn install
::
ECHO docker build
docker-compose up -d --build