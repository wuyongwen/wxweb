#!/bin/bash
CLASSPATH=.
APP_HOME=.
for i in "$APP_HOME"/lib/*.jar
do
   CLASSPATH="$CLASSPATH":"$i"
done
echo 'start'
java -Xms300m -Xmx400m -classpath $CLASSPATH wxweb.Start
