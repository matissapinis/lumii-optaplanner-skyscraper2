************************************************************************
file with basedata            : mm14_.bas
initial value random generator: 29322
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  12
horizon                       :  80
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     10      0       13        8       13
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          3           7   8   9
   3        3          3           5   6   8
   4        3          1           7
   5        3          1          11
   6        3          1          10
   7        3          2          10  11
   8        3          1          10
   9        3          1          12
  10        3          1          12
  11        3          1          12
  12        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     1       8    0    6    6
         2     4       8    0    4    4
         3     7       0    9    2    2
  3      1     4       7    0    9   10
         2     6       5    0    7    8
         3     8       3    0    4    7
  4      1     5       0    5    7    8
         2     8       0    2    6    6
         3     9       0    2    2    4
  5      1     6       0    2    5    4
         2     6       6    0    4    4
         3    10       5    0    3    4
  6      1     3      10    0    7   10
         2     4       0    2    6    8
         3     7      10    0    6    4
  7      1     3       0    5    4    8
         2     4       7    0    4    8
         3    10       0    4    4    7
  8      1     2       7    0    4   10
         2     7       0    8    3    7
         3     8       0    3    2    3
  9      1     3       8    0    6    8
         2     5       0    3    3    7
         3     5       4    0    4    5
 10      1     4       3    0    4    9
         2     5       0    2    3    9
         3     7       0    1    3    8
 11      1     3       0    8    5    6
         2     9       0    2    3    6
         3     9       8    0    1    5
 12      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   17   11   44   64
************************************************************************
