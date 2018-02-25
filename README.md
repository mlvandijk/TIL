# Today I learned (TIL)
A list of little things I learn every day...
(Saved here for reference)

## Ports
How to find out which process is active on a particular port (Mac OS)

https://stackoverflow.com/questions/4421633/who-is-listening-on-a-given-tcp-port-on-mac-os-x

## Docker
Restart a docker: 
```
docker stop $(docker ps -q -f ancestor=<image>)
docker rmi <image>
```
To get the info of the docker, use `docker ps`.
