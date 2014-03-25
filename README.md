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
- Define your working directory <q>webAppSourceDirectory</q> in *pom.xml* and <q>baseDir</q> in <code>src/main/webapp/manifest.json</code>,make sure they are same;
-  Write JSON files in <code>${baseDir}/\_data/</code>;
-  Write static files in <code>${baseDir}/static/</code>,including css,js and images;
-  Write templates in <code>${baseDir}/template/</code>,make sure the extension is '.ftl' if using [Freemarker](http://freemarker.org),or else '.vm' if [Velocity](http://velocity.apache.org/).


You can use [eclipse](http://www.eclipse.org) to open root directory as a project.

configration
======
The default value of configration items in manifest.json is:

 - template:freemarker/velocity
 - charset:'utf-8'
 - baseDir:'src/main/webapp'


changelog
======
- 2014/03/25:move default working directory to <code>projects/demo</code>
- 2014/03/21:support charset settting;
- 2014/02/21:initialize;freemarker local supported;
- 2014/02/22:support velocity.

todo
======
 - split lion and project
 - building tool
 
contact
======
 - <yanni4night@gmail.com> 
