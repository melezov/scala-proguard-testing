#!/bin/bash

cwd="$( pwd )"; cd "$( dirname "$0" )"; dir="$( pwd )"; cd "$cwd"

# First, clean all targets to ensure no artifacts remained from previous compilations.
# Then, compile project for all Scala versions.
# Finally (if all compilations were successful), publish the artifacts to a local binary repository.

echo Publishing project to a local repository ...
"$dir/sbt.sh" clean +compile +publish-local "$@"
