package c_theory.question13;

public class Docker {

    //todo A
    // What is a server?
    // Answer: A computer that serves information to clients (often other computers)

    //todo B
    // What is the difference between build server and production server?
    // Answer: Build server is a server focusing on building projects. Build servers are the first place where code
    //          changes get tested and compiled. Production servers are where the code gets deployed after it has been
    //          build and confirmed to work as intended.

    //todo C
    // What is docker?
    // Answer: Docker is a container runtime environment. Docker creates its own small virtual environment to run
    // containers as efficiently as possible, saving on resources of creating a whole new OS to run one application.

    //todo D
    // Name and explain docker container benefits over virtual machine setup (java jar as system process and installed nginx)
    // 1 Reduced snapshot size, more cost efficient when purchasing server room.
    // 2 Quicker in starting and maintaining various OS apps.

    //todo E
    // Name and explain docker container drawback over virtual machine setup (java jar as system process and installed nginx)
    // 1 Docker does not support non-linux machines natively and runs virtual machines on those operation systems.

    //todo F
    // Name and describe tools for docker architecture
    // 1 Docker engine: core docker part, containing the daemon (dockerd), REST API and cli app that clients use to
    //                  interact with docker.
    // 2 Docker object: Helps build yml files and docker containers overall, includes many docker components such as
    //                  containers, volumes, networks, images and so on.

    //todo G
    // Name and explain why are companies slow in moving existing systems to docker architecture (do not explain why docker is bad)
    // 1 From own experience, many companies do not want to change their systems if they are already functional.
    // 2 The expense for moving all running applications could be high, including the experience sink instead of just
    //      developing apps as they already know how.
}
