cd ./discovery-server
mvn clean package -DskipTests=true
cd ..
cd ./inventory
mvn clean package -DskipTests=true
cd ..
cd ./web-client
mvn clean package -DskipTests=true