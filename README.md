# Unity

This repo contains our first and third project code in ICS0024

## Setup

**Clone repo**
`git clone https://gitlab.cs.ttu.ee/htoots/unity.git`

**Build docker**
`docker build --build-arg JAR_FILE=build/libs/*.jar -t unity/api .`

**Run docker**
`docker run -p 8080:8080 unity/api`
