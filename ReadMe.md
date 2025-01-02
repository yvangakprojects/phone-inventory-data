docker build -t phone-inventory-data:v1.0.0 .  

docker login

docker tag phone-inventory-data:v1.0.0 ygakuba/phone-inventory-data:v1.0.0

docker push ygakuba/phone-inventory-data:v1.0.0