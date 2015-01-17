[![Flattr this git repo](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=jonnybbb&url=https%3A%2F%2Fgithub.com%2Fjonnybbb%2Fspring-social-xing&title=Spring Social Xing&language=&tags=github&category=software)

[![Build Status](https://travis-ci.org/jonnybbb/spring-social-xing.svg?branch=master)](https://travis-ci.org/jonnybbb/spring-social-xing)

# Spring Social Xing

## Download Artifacts


### Dependencies

#### Gradle

    compile(group: 'org.springframework.social', name: 'spring-social-xing', version: '1.1.0.RELEASE')


#### Maven

```xml
<dependency>
    <groupId>org.springframework.social</groupId>
    <artifactId>spring-social-xing</artifactId>
    <version>${org.springframework.social-xing-version}</version>
</dependency>

```


### Repositories

```xml
<repository>
    <id>spring-social-xing</id>
    <name>Spring Social Xing Repository</name>
    <url>http://dl.bintray.com/jonnybbb/repo</url>
</repository>   

```

## Build from source


To check out the project and build from source, do the following:

    git clone git://github.com/jonnybbb/spring-social-xing.git
    cd spring-social-xing
    ./gradlew build


-------------------------------------------------------------------------------
To generate Eclipse metadata (`.classpath` and `.project files`), do the following:

    ./gradlew eclipse

Once complete, you may then import the projects into Eclipse as usual:

    File -> Import -> Existing projects into workspace

-------------------------------------------------------------------------------
To generate IDEA metadata (`.iml` and `.ipr` files), do the following:

    ./gradlew idea

-------------------------------------------------------------------------------
To build the JavaDoc, do the following from within the root directory:

    ./gradlew :docs:api

The result will be available in `docs/build/api`.

