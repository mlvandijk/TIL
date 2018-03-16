# Today I learned (TIL)
A list of little things I learn every day...
(Saved here for reference)


## Ports
How to find out which process is active on a particular port (Mac OS):

https://stackoverflow.com/questions/4421633/who-is-listening-on-a-given-tcp-port-on-mac-os-x

`lsof -n -i:$PORT | grep LISTEN`

## Docker
Restart a docker: 
```
docker stop $(docker ps -q -f ancestor=<image>)
docker rmi <image>
```
To get the info of the docker, use `docker ps`.

Rebuild it if you make changes:
```
docker-compose up --build
```

## npm
`npm init -y` to create package.json

`npm install <package_name> --save-dev` to add package as devDependency to package.json

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

* Run the command `chmod 755` to change the rights to the file.

* Check if it worked with `ls -F` -> you should see an `*` after your filename. Or, if you check with `ls -l` your file should have the following rights: `-rwxr-xr-x`

* TEST YOUR SCRIPT!

* Add to git and commit. Now everyone can use it!
