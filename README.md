# Game description:

### The board:

The board is a 5x5 array made with characters. 
The characters are: "~", "0" and "X".

- "~" : Represents de ocean
- "0" : Represents a wrong shot
- "X" : Represents a shipwrecked.

### Rules:

- After the players entered his names both of the Boards will be randomized.
- Both will have 5 boats, they can be any size.
- In each round, the player have to input a line and a column who wants to atack his enemy.
- If the player hits the enemy, the position on the boards turns to "X", but, if he miss it, the board position will be marked with "0".

### Problems:

The game is not finished, so you can met some bugs and unhandled exceptions. Look some examples:

- If you dont insert any name on the players, the game will execute with no name in players.
- If you insert one board position that is not on the board ( a line or column greater than 4 or lesser than 0), the game will stop.
- If you dont insert any position to atack, the game will stop.

