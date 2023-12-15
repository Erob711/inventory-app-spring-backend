#!/bin/bash
#From a terminal session, execute the following commands:

#start commands
#cd <project-root>/database/
#./create.sh
#end commands

#system info

export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=inventory_app
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/itemSeed.sql"
