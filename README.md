# uno-game
Maven Project on Java 11

## Run on docker
` sudo docker build . `

You will see a message like ```Successfully built fd7b6305da12``` after successful build.

After that, run

`sudo docker run -p8888:8080 <image>`

Once the jvm is up and running, you can access the swagger via `http://localhost:8888/swagger-ui/`
