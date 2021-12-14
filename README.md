# Linear_Regression
CS341 Software Engineering

Homework 9

Write application described below in Java.  Commit the source code (with documentation) to GitHub. 
Submit the Git repository URL to Moodle.
Submit the following Word documents to Moodle
•	Testing summary. 


 
 
Assignment

Write a program to calculate the simple linear regression (least squares) to predict the number of bugs you can expect during development of an application. Use the development data you collected from programs 3-8.  Specifically, use the hours you spent coding each homework and the total number of bugs incurred during the development of the homework application. Use a List data structure to store these corresponding values.
 
 
Requirements

•	The process to calculate the linear regression parameters, and the required formulas, are explained in the pdfs. You will need to use a simple least squares method in this assignment.

•	Begin by collecting the data from previous homework: (a) the number of consecutive hours spent coding and (b) the number of bugs produced during those hours. This data will be input into the linear regression program as a text file. Each line in the text file should be in the form: xValue, yValue..  The xValues represent the number of consecutive hours spent coding an application and the yValues represent the number of bugs produced during development. 


For example: 
Consider the input text file (shown on right) containing data collected from seven homework programming assignments. Note that each line contains x,y pairs: x representing the hours of coding and y representing the number of bugs for each assignment.






 

•	Design your program so that the user can select the input data file from their computer. The user should also be able to input the number of coding hours for a future project prediction

•	Use a linear regression algorithm to compute the predicted number of bugs the user should expect during this development.

Example: The following output will occur for the specified input shown.  This is based on the data collection file used on the previous page

 


•	In your testing phase, include a test that takes as input your estimated new and changed LOC, and your actual new and changed LOC, for Assignments 4-8. Include a table with the output.
•	You are responsible for resolving any issue not covered by these requirements. Document all your assumptions and decisions wherever requirements are unclear.
