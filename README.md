# Today I learned (TIL)
(A list of handy things, saved here for reference)

## Java
Find where Java is installed on Mac: 
* `/usr/libexec/java_home -v` (finds the latest version), or
* `echo $(/usr/libexec/java_home)`
(source: https://stackoverflow.com/questions/15826202/where-is-java-installed-on-mac-os-x)

Set $JAVA_HOME on Mac: 
https://www.mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/

## Kotlin
Using Kotlin with Spring: https://www.baeldung.com/kotlin-allopen-spring (Note: Use `${kotlin.version}` instead of the plugin version).

## Git

Rename main: https://www.git-tower.com/learn/git/faq/git-rename-master-to-main

[`core.autocrlf`](https://git-scm.com/book/en/v2/Customizing-Git-Git-Configuration) - Configure to deal with line endings across Windows & macOs / Linux


## Jackson
fun createObjectMapper() = ObjectMapper().registerModule(KotlinModule())
https://stackoverflow.com/questions/59671311/field-name-parts-in-json-causes-deserialization-to-fail

`@JsonIgnoreProperties(ignoreUnknown = true)` to ignore all fields in a class you don't need.

`@JsonProperty("grouped_renditions")` to map which field in the json maps to this field in your class.

## Maven / IntelliJ
When imports are red despite having the external libs: https://stackoverflow.com/questions/11454822/import-maven-dependencies-in-intellij-idea

## Maven

Run `mvn versions:display-dependency-updates` to check for dependency updates.

`mvn dependency:tree`

See where a specific dependency is coming from: http://maven.apache.org/plugins/maven-dependency-plugin/examples/filtering-the-dependency-tree.html

Short version: `mvn dependency:tree -Dincludes=<groupId>:<artifactId>`

Look for specific dependency: `mvn dependency:tree |grep <dependency>`

[`mvn help:effective-pom`](https://maven.apache.org/plugins/maven-help-plugin/effective-pom-mojo.html)

Write into a logfile: `mvn help:effective-pom --log-file log.txt`

`mvn versions:set -DnewVersion=x.y.z -DgenerateBackupPoms=false` to up version in all poms.

`mvn clean install -U` force updates from artifactory.

Run `mvn versions:display-plugin-updates` to check for plugin updates.

Run `mvn dependency:analyze` to find unused dependencies.

### Maven debugging
`mvn clean install -DtrimStackTrace=false` - get full stacktrace

## Failsafe
By default, Maven runs your tests in a separate ("forked") process. You can use the maven.failsafe.debug property to debug your forked tests remotely, like this: `mvn -Dmaven.failsafe.debug verify`

(Source: https://maven.apache.org/surefire/maven-failsafe-plugin/examples/debugging.html)

You can run a particular test only, e.g. `mvn -Dit.test=RunCucumberIT verify`
Source: [Failsafe - running a single test](https://maven.apache.org/surefire/maven-failsafe-plugin/examples/single-test.html)

[Inclusions and Exclusions of Tests](https://maven.apache.org/surefire/maven-failsafe-plugin/examples/inclusion-exclusion.html)

## MacOs
How to find out which process is active on a particular port (Mac OS):

https://stackoverflow.com/questions/4421633/who-is-listening-on-a-given-tcp-port-on-mac-os-x

`lsof -n -i:$PORT | grep LISTEN`

`lsof -n -i:8080` where 8080 is the port number

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

To see all dockers that are stopped:
```
docker ps -a
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

Remove all containers
```
docker rm -f $(docker ps -a -q)
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

`docker build .` will build a docker image based on the Dockerfile in the current directory.

**Note:** Don't try to load external links on CI server; use Docker [extra_hosts](https://docs.docker.com/compose/compose-file/#extra_hosts)

## Kubernetes

https://github.com/dennyzhang/cheatsheet-kubernetes-A4/blob/master/cheatsheet-kubernetes-A4.pdf 

`kubectl help`

`kubectl explain`

## Postgres
`show statement_timeout;`

`set statement_timeout to '1min';`

`set statement_timeout to 0;`

## ElasticSearch

`_cat/` endpoint provides all available endpoints

## Resilience

https://resilience4j.readme.io/docs/getting-started

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
Activate edits: `source ~/.bash_profile`

## Command line
`cp *` - copy all from current directory
`ls -l` - list, with details

## crontab examples

https://crontab.guru/examples.html

## Terminal
`pwd` = print working directory

`ls -all -l` = list directory content, all, long format

## RegEx

https://ihateregex.io/

https://regexcrossword.com/
