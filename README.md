# Today I learned (TIL)
(Saved here for reference)

## Java
Set $JAVA_HOME on Mac: 
https://www.mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/

## Maven / IntelliJ
When imports are red despite having the external libs: https://stackoverflow.com/questions/11454822/import-maven-dependencies-in-intellij-idea

## Ports
How to find out which process is active on a particular port (Mac OS):

https://stackoverflow.com/questions/4421633/who-is-listening-on-a-given-tcp-port-on-mac-os-x

`lsof -n -i:$PORT | grep LISTEN`

## xcode

Install xcode: `xcode-select --install`

## Docker
Restart a docker: 
```
docker stop $(docker ps -q -f ancestor=<image>)
docker rmi <image>
```
To get the info of the docker, use `docker ps`.

To see which dockers are running:
```
docker ps
```

Rebuild it if you make changes:
```
docker-compose up --build
```

Get logging:
```
docker-compose logs -f <docker-name>
```
or:
```
docker logs {containerid}
```
Add a wait:
```
docker-compose up -d --build && sleep 2
```

Get a port number:
```
docker-compose port <docker-name> <internal-port-number>
```

Stop all running containers
```
docker kill $(docker ps -q)
```

How a Docker name is set:
1. `docker run...` generates a random name, like `curious_pete`
2. `docker run --name=HELLO` uses the specified name `HELLO`
3. `docker-compose` generates the name `<docker-compose.yml parent directory>_<service-name-in-docker-compose.ym>_<1-based-index-of-number-of-copies-of-service-you-are-running>`

To override the name:
```
docker-compose -p <project-name>
```

To use (Jenkins) variables in the name:
```
docker-compose -p <project-name>${BUILD_ID} // TODO: Check exact name of environment variable, could also be ${JENKINS_BUILD_ID}, or something like ${JOBNAME}${BUILD_ID}
```

Generate a unique ID (Note: Not tested)
```
docker-compose -p $(uuidgen) up -d --build
```
`uuidgen` is a command (at least on OS X) that generates a UUID (universally unique ID), thus providing a unique name/

$(uuidgen) is shell-talk for: run `uuidgen` and use the output

So `docker-compose -p $(uuidgen) up -d --build` means something like:

UUID=(output of) uuidgen
docker-compose -p $UUID up -d --build

This guarantess a unique project-name for your docker-compose.


**Note:** Don't try to load external links on CI server; use Docker [extra_hosts](https://docs.docker.com/compose/compose-file/#extra_hosts)

## npm
`npm init -y` to create package.json

`npm install <package_name> --save-dev` to add package as devDependency to package.json

## yarn

Uninstall:

`npm uninstall yarn`

`npm uninstall -g yarn`

`brew uninstall yarn`

`brew uninstall --force yarn`

Install a particular version globally:

`npm install -g yarn@<version>` e.g. `npm install -g yarn@1.6.0`

## shell
* Create a script in the root of your project to do several command line steps:
```
#!/usr/bin/env bash
# Description of the file

set -e      # stop on failure of one of the commands

# Go to right directory
cd <dir>

# Do the thing
<thing>
```
* Go to the location on your file system where your file is located.

* Run the command `chmod 755 <filename>` to change the rights to the file.

* Check if it worked with `ls -F` -> you should see an `*` after your filename. Or, if you check with `ls -l` your file should have the following rights: `-rwxr-xr-x`

* TEST YOUR SCRIPT!

* Add to git and commit. Now everyone can use it!

## Selenium
If sendKeys() doesn't work anymore, try using a different ChromeDriver.

## bash profile
Show content: `cat .bash_profile`
Edit (with vi): `vi ~/.bash_profile`

## crontab examples

https://crontab.guru/examples.html
