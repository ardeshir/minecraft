#!/bin/sh

cd "$( dirname "$0" )"
java -Xms512M -Xmx1024M -XX:MaxPermSize=128M -jar spigot-1.13.2.jar