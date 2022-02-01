rm -rf build
./gradlew --stacktrace --info clean build
docker-compose build ms-associados
docker-compose up -d
docker rmi `docker images --filter dangling=true -q` --force