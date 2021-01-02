# Unity

This repo contains our first and third project code in ICS0024. Wiki has the setup detailed.

## Team members
Hannes Toots - htoots
Levent Alici - mealic

## Quick setup with docker

**Clone repo**

`git clone https://gitlab.cs.ttu.ee/htoots/unity.git`

**Build docker**

`docker build --build-arg JAR_FILE=build/libs/*.jar -t <yourtag> .`

**Run docker**

`docker run -p 8080:8080 <yourtag>`


