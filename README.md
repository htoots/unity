# Unity (outdated readme)

This repo contains our first and third project code in ICS0024.

## Authors
[Hannes toots](https://gitlab.cs.ttu.ee/htoots)

[Levent Alici](https://gitlab.cs.ttu.ee/mealic)

## Server IP

http://13.49.224.68

Details of server setup in wiki

## Domain

https://financeprj21.ml/

Domain is registered through freenom.com

AWS is used for cloud services and namespaces taken from AWS instance were added on freenom


Nginx certbot was used to enable HTTPS.

Commands for enabling https:

sudo  add-apt-repository ppa:certbot/certbot

sudo certbot --nginx

## Docker Setup

**Clone repo**

`git clone https://gitlab.cs.ttu.ee/htoots/unity.git`

**Build docker**

`docker build --build-arg JAR_FILE=build/libs/*.jar -t <containertag> .`

**Run docker**

`docker run -p 8080:8080 <containertag>`
