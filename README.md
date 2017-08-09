========================VMEMMAN README ========================


To run the program
------------------------------------------

To run the project from the command line, go to the dist folder and 
type the following:

java -jar "Virtual_Machine.jar" 


When the program is run it will print the following menu
Select Algorithm:
1 FIFO 
2 LRU
3 MRU
4 Optimal
5 ALL
-> 

Select a number from 1 to 5 to select the algorithm to be run. If pressed 3 the following will be
shown: 
************ mru ************
  512   4       MRU     93.40%          2802
  512   8       MRU     91.00%          2730
  512   12      MRU     88.80%          2664
  1024  4       MRU     85.83%          2575
  1024  8       MRU     82.17%          2465
  1024  12      MRU     79.13%          2374
  2048  4       MRU     74.13%          2224
  2048  8       MRU     68.50%          2055
  2048  12      MRU     62.40%          1872

This is one of the example of the 4 algorithms.The rows are the following:
1st row is the size of the page 
2nd row is the number of pages in this case the size of the array
3rd row is the algorithm used 
4th row is the percentage of page faults
5th row is the amount of page faults 

INPUT
------------------------------------
By default the program uses the file "inputfileforpart2.dat"however if you you wish to change
the input file open the class ReadFile.java and you can change the name of the file to be used. 
