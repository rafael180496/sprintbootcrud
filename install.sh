echo compiling...
mvn clean | mvn install
::
echo docker build
docker-compose up -d --build