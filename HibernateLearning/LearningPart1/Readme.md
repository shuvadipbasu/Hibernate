1. ojdbc is a third party jar. So one need to install it to local maven repo.

Steps:
1. place the jar at project root
2. run below command

mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=oracle -DartifactId=ojdbc6 Dversion=11.2.0.3 -Dpackaging=jar