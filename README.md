lion
======

**lion** is a front-end development environment supports [Freemarker](http://freemarker.org) and [Velocity](http://velocity.apache.org/) managed by [maven](http://maven.apache.org).

install
======

Download [maven](http://maven.apache.org/download.html) and add _bin_ directory to your _$PATH_.

Run 

    mvn jetty:run -e

in the root of **lion**.

Open your browser and navigate to <http://localhost:8080/>

You can change the port in _pom.xml_.

develop
======
1. Write JSON files in *src/main/webapp/\_data/*	
2. 2.Write templates in *src/main/webapp/template/*

changelog
======

- 2014/02/21:initialize;freemarker local supported;
- 2014/02/22:support velocity.

todo
======
 - split lion and project
 - building tool
 
contact
======
 - <yanni4night@gmail.com> 
