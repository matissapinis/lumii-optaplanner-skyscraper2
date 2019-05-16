************************************************************************
file with basedata            : md350_.bas
initial value random generator: 1893291323
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  22
horizon                       :  159
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     20      0       29        2       29
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          3           6  12  13
   3        3          3           9  12  15
   4        3          3           5   9  13
   5        3          2           6  14
   6        3          2           7  16
   7        3          1           8
   8        3          2          10  11
   9        3          1          16
  10        3          3          15  18  20
  11        3          3          15  17  20
  12        3          2          14  18
  13        3          1          17
  14        3          2          19  20
  15        3          2          19  21
  16        3          1          17
  17        3          1          18
  18        3          2          19  21
  19        3          1          22
  20        3          1          22
  21        3          1          22
  22        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     6       8    5    0    6
         2    10       3    3    0    4
         3    10       3    3    2    0
  3      1     3       5   10    0    6
         2     6       3    7    7    0
         3     9       2    6    7    0
  4      1     2      10    9    0    9
         2     4      10    9    0    7
         3     9      10    8    0    6
  5      1     2       9   10    4    0
         2     4       9    7    4    0
         3    10       9    3    0    6
  6      1     1       7    8    0    6
         2     5       6    8    6    0
         3     7       4    7    3    0
  7      1     3       7    6    0    6
         2     3       7    5    8    0
         3     7       6    5    6    0
  8      1     6       9   10    7    0
         2    10       8    6    0    4
         3    10       7    8    7    0
  9      1     2       6    8    7    0
         2     3       4    4    0    2
         3     7       3    4    0    2
 10      1     3       6    8    5    0
         2     4       5    7    0    8
         3     6       4    3    3    0
 11      1     4       6    8    0    7
         2     5       6    7    7    0
         3     6       3    7    0    5
 12      1     6       8   10    8    0
         2     8       6    7    6    0
         3    10       4    7    0    7
 13      1     2       8    6    0    3
         2     4       8    5    0    2
         3     5       8    5    2    0
 14      1     4       5    1    0    4
         2     8       5    1    8    0
         3     8       4    1    9    0
 15      1     1       9    6    0   10
         2     9       5    4    0    3
         3     9       5    5    3    0
 16      1     3       5    3    0    7
         2     5       4    3    0    6
         3     6       1    1    4    0
 17      1     2       9    3    0    6
         2     6       8    3    0    5
         3     7       3    2    0    5
 18      1     3       8    6    7    0
         2     7       8    5    7    0
         3     8       8    3    0    9
 19      1     4       4    7    6    0
         2     7       4    6    0    5
         3     8       3    6    6    0
 20      1     4       7    5    6    0
         2     7       3    4    4    0
         3     9       2    3    1    0
 21      1     1       6    5    7    0
         2     6       5    4    7    0
         3     8       4    2    0    3
 22      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   19   17  105  114
************************************************************************
