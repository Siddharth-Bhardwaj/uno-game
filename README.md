# uno-game

Maven Project built on OpenJDK 11 (I am using Oracle OpenJDK 11.0.1).

Install and Configure [google-java-format](https://plugins.jetbrains.com/plugin/8527-google-java-format) to keep the
formatting consistent (requires
additional [config changes](https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config)).

## DB setup

Start mongodb on the default port (localhost:27017).

I am using v6.0.4 for local development.

If you don't have mongodb installed you can do so in one of the following ways -

- ### Download run-rs (short and easy method)
    1. Install npm if not already installed.
    2. `npm install run-rs -g`
    3. `run-rs --keep` -> This will download mongodb and start 3 replica sets.


- ### Install MongoDB and Mongosh
    1. https://www.mongodb.com/docs/manual/tutorial/
    2. https://www.mongodb.com/docs/mongodb-shell/install/
    3. `mongod` will start up the local MongoDB.


- ### Homebrew/LinuxBrew (for MacOS or Linux)
    1. Install homebrew -> https://brew.sh/ or https://docs.brew.sh/Homebrew-on-Linux
    2. `brew tap mongodb/brew`
    3. `brew update`
    4. `brew install mongodb-community@6.0`
    5. `brew services start mongodb-community@6.0` will start up the local MongoDB.

## Starting up the local server

**You may run the project natively or on docker**

### Run on docker

- ` sudo docker build . `

- You will see a message like ```Successfully built <image>``` after successful build.

- After that, run `sudo docker run -p8888:8080 <image>`

- For example, if after docker build you got `Successfully built fd7b6305da12`,
  run `sudo docker run -p8888:8080 fd7b6305da12`

If at any step you see a message
like `docker: Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?`,
run `sudo dockerd` in a new terminal and try again.

### Run natively

- `mvn clean install` to install all the dependencies and create the jar (required during initial setup).
- Once the build is successful and jar file is created,
  run `java -jar path/to/your/jarfile.jar fully.qualified.package.Application`.
  For example, `java -jar /home/app/target/uno-game-0.0.1-SNAPSHOT.jar uno-game-0.0.1.jar`

**OR**

- Navigate to `UnoGameApplication.java` and click on the green arrow to start the server (assuming you are using
  IntelliJ Idea).
  <br/>

#### Once the jvm is up and running, you can access the swagger via `http://localhost:8888/swagger-ui/`