# Cabonline-Technologies-Test

Quick start
Execute the program with the below command from the root folder of the project.
java -Xms512m -Xmx1536m -classpath ".;bin;lib/*" main.CabonlineTechnologiesTest files 1 2
The first parameter, "files". tells which folder to look for files to import
The second parameter, "1", is which type of data is in the files. The options are 1 or 2.
The third parameter, "2", is which version of the code to run. The options are 1 or 2.

Detailed information
The program takes the first argument as in which folder to look for files to parse, with either a relative path from where the command is executed or an absolute path.
The program takes the second argument as which type of data there is in the files.
	1 = Array like data as [4, 1, 6, 3, 7, 8, 7], the data can be seperated over severall lines.
	2 = Each value is on a separate line in the file. 
The program takes the third argument as in which version of the code to run, possible values are empty, 1 or 2. If left empty the program will run both versions of the code.
	1 = Version 1 of the code uses Apache Common libraries to calculate the median.
	2 = Version 2 of the code uses Collections to sort the data and Math to get Median.

Memory usage
The Xmx setting defines the limit of number of inputs in each file. With 512 MB it can handle 7 million, 1024 MB it can handle 14 million, 1536 MB it can handle 20 million.
The memory usage and amount of inputs are more or less lineasr, each input requires about 75 byte of memory for the program to be able to run.

Performance
Depending on memory settings, Xmx and Xms, the two versions of the code performs in various ways.
In generall version 1 of the code retrives the median value fastest. But i.e. with Xmx 2048 and Xms 1024 version 2 of the code get the median value of 20 million inputs faster than version 1.

Comments to test instructions
"The Integers range is between 0 and 1000", but still there is an example with values above 1000, 5: [1, 2000, 2000] // median 1000, that says the median should be 1000.
Therefor in the code all values above 1000 and belove 0 are changed to 1000 and 0.
"let’s assume that the amount of inputer samples are always odd", but example 6 contains 100 values and example 7 contains 1000 values.
For me "we decided to save the average millisecond (as Integer) per second and evaluate the data for the entire week." and "just keep in mind that the amount of data will be huge and memory is going to be a problem" is a little contradicting.
The data for a week will only be 604 800 inputs based on the first statement, that is not huge amount of data.