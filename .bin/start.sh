#!/bin/sh

if [ -d "/projects/app/.theia" ]; then
  if [ ! -d "/projects/.theia" ]; then
    cp -R /projects/app/.theia /projects/.theia
  fi
fi

sh /projects/app/start.sh
