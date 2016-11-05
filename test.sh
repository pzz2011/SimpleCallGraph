#!/bin/bash

cp target/instrumentation-0.0.1-SNAPSHOT.jar mytest/lib/
cd mytest/target/classes/

java -cp '.: ../random-name-generator-1.0-SNAPSHOT.jar:../../lib/instrumentation-0.0.1-SNAPSHOT.jar:../../lib/javassist-3.17.1-GA.jar' -javaagent:../../lib/instrumentation-0.0.1-SNAPSHOT.jar=uk.co.halfninja.randomnames::dotest uk.co.halfninja.randomnames.Main


