# Unity

This repo contains our first and third project code in ICS0024.

## Authors
[Hannes toots](https://gitlab.cs.ttu.ee/htoots)

[Levent Alici](https://gitlab.cs.ttu.ee/mealic)

## Server IP

http://3.137.182.74:8080/

## Setup (details in wiki)

**Clone repo**

`git clone https://gitlab.cs.ttu.ee/htoots/unity.git`

**Build docker**

`docker build --build-arg JAR_FILE=build/libs/*.jar -t <containertag> .`

**Run docker**

`docker run -p 8080:8080 <containertag>`
