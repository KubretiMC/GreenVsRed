Description of the game:
'Green vs Red' is a game played on a 2D grid that in theory can be infinite (in our case we will assume that x<=y<1 000).

Each cell on this grid can be either green (represented by 1) or red(represented by 0). The game always receives an innitial state of the grid which we will call 'Generation Zero'. After that a set of 4 rules are applied across the grid and those rules form the next generation.
Rules that create the next generation:
	1. Each red cell that is surrounded by exactly 3 or exactly 6 green cells will also become green in the next generation
	2. A red cell will stay red in the next generation if it has either 0, 1, 2, 4, 5, 7 or 8 green neighbours.
	3. Each green cell sorruounded by 0, 1, 4, 5, 7 or 8 green neighbours will become red in the next generation.
	4. A green cell will stay green in the next generation if it has either 2, 3 or 6 green neighbours.
(x1 and y1) wil be coordinates of a cell in the grid. We would like to calculate how many generations from Generation Zero until generation N this cell was green. (The calculation should include generation Zero and generation N)
Example1:
# 3x3 grid in the initial state, the second row is all 1s, how many times will the cell [1,0] become green in 10 turns?
3, 3
000
111
000
1, 0, 10
# expected result: 5

Example2:
# 4x4 grid. Input:
4, 4
1001
1111
0100
1010
2, 2, 15
# expected result:14

API Documentation:
In class Grid:
The function "create" fills 2d array called grid with the numbers from the user input.
The function "changeGeneration" prepares the array for going in the next generation.
"changeGeneration" calls the functions "neighbours", which checks  if the neighbour cells 
are green, and "nextGeneration" which calls the next generation with all the changes in
the grid.

In class GreenVsRed:
We have integer values x and y for the size of the grid which we use to create "Grid" instance
and "line" for the "Grid.create" method.
In the function "start" we start the game by asking the user to input the size, values,
observed cell of the grid and how many generations the grid will have.
In the "start function" we create the "Grid" instance and its methods "create" and
"changeGeneration".
