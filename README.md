# Unity

This repo contains our first and third project code in ICS0024.

## Authors
Hannes toots - htoots

Levent Alici - mealic

## Setup (details in wiki)

**Clone repo**

`git clone https://gitlab.cs.ttu.ee/htoots/unity.git`

**Build docker**

`docker build --build-arg JAR_FILE=build/libs/*.jar -t <containertag> .`

**Run docker**

`docker run -p 8080:8080 <containertag>`
