#!/bin/bash

cwd="$( pwd )"; cd "$( dirname "$0" )"; dir="$( pwd )"; cd "$cwd"

echo Running the usage exaple ...
"$dir/sbt.sh" 'run-main hr.element.example.YouthAlchocolismPrevention JP 18'
