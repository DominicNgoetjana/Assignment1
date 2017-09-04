#!/bin/bash

# Run Makefile and execute .java programs for extracting time

make
cd bin
TIMEFORMAT=%U		#change the format of the output of 'time' to only display User time
for count in {100000..1000000..100000}	# loop from 100000 to 1000000 with a step of 100000
do
	java DataFileGenerator data.file $count	# generate query file with $count random names
	if [ $count -eq 100000 ]; then
		(time java SearchIt > /dev/null) > SearchItTime 2>&1	#write time into SearchItTime file
		(time java SearchItLinear > /dev/null) > SearchItLinearTime 2>&1
	else
		(time java SearchIt > /dev/null) >> SearchItTime 2>&1		#append time to SearchItTime
		(time java SearchItLinear > /dev/null) >> SearchItLinearTime 2>&1
	fi
done
