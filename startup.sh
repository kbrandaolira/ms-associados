sudo ./gradlew --stacktrace --info clean build
sudo docker-compose build --no-cache ms-associados
sudo docker-compose up -d
sudo docker rmi `docker images --filter dangling=true -q` --force