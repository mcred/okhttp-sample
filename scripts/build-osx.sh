#!/usr/bin/env bash

set -ex

version=`cat VERSION`

native-image -cp ${PWD}/target/okhttp-test-$version-jar-with-dependencies.jar\
    -H:Name=okhttp\
    -H:Class=com.delphix.okhttp.Test\
    -H:+ReportUnsupportedElementsAtRuntime\
    -H:ReflectionConfigurationFiles=${PWD}/config/reflect-config.json\
    -H:ResourceConfigurationFiles=${PWD}/config/resource-config.json\
    -H:+ReportExceptionStackTraces\
    --allow-incomplete-classpath\
    --enable-url-protocols=http\
    --initialize-at-build-time\
    --no-server