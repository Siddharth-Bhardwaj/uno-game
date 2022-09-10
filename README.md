# uno-game
Maven Project on Java 11

## Run on docker
` sudo docker build . `

You will see a message like ```Successfully built <image>``` after successful build.

After that, run

`sudo docker run -p8888:8080 <image>`

For example, if after docker build you got `Successfully built fd7b6305da12`, 
run `sudo docker run -p8888:8080 fd7b6305da12`

Once the jvm is up and running, you can access the swagger via `http://localhost:8888/swagger-ui/`

### If at any step you see a message like
`docker: Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?`

Run the following command in a new terminal

`sudo dockerd`
