/*
 * Ryan Lutz
 * 11/6/19
 * M2A7
 */

public class Board {
    private char[][] squares; // Represents the game board

    /**
     * Contructs a new Board with 10 rows and 10 columns
     */
    public Board() {
        squares = new char[10][10];
        for (int i=0; i<squares.length; i++) {
            for (int j=0; j<squares[i].length; j++) {
                squares[i][j] = '-';
            }
        }
    }

    /**
     * ToString method for Board class
     * @return A string representing the current game board
     */
    public String toString() {
        String out = "";
        for (char[] row: squares) { // For each row in squares
            for (char e: row) { // For each column in row
                out += e + " "; // Add the element to out and a space after it
            }
            out += "\n"; // Add a newline char after every row
        }
        return out; // Return the out string
    }
    /**
     * Attempts to add a ship of len at (row, col) on either the horizontal or vertical axis
     * @param row row in which the ship should start
     * @param col column in which the ship should start
     * @param len length of the ship
     * @param horizontal if the ship should be horizontal (true) or vertical (false)
     * @return true if the ship was added
     * <li>false if the ship could not be added</li>
     */
    public boolean addShip(int row, int col, int len, boolean horizontal) {
        int f = 0; // Flag var
        if (horizontal) { // Ship wants to be horizontal
            for (int i=0; i<len; i++) { // For each index from column i to i+len
                try {
                    if (squares[row][col+i] != '-') { // If a square isn't empty
                        f = 1; // Raise the flag
                    }
                } catch (IndexOutOfBoundsException e) { // If index goes out of bounds
                    f = 1; // Raise the flag
                }
            }
            if (f == 0) { // If flag has not been set
                for (int i=0; i<len; i++) { // Set each square that the user wants the ship to be in to 'b'
                    squares[row][col+i] = 'b';
                }
                return true;
            } else { // If flag has been set
                return false;
            }
        } else { // Ship wants to be vertical
            for (int i=0; i<len; i++) { // For each index from row i to i+len
                try {
                    if (squares[row+i][col] != '-') { // If a square isn't empty
                        f = 1; // Raise the flag
                    }
                } catch (IndexOutOfBoundsException e) { // If index goes out of bounds
                    f = 1; // Raise the flag
                }
            }
            if (f == 0) { // If flag has not been set
                for (int i=0; i<len; i++) { // Set each square that the user wants the ship to be in to 'b'
                    squares[row+i][col] = 'b';
                }
                return true;
            } else { // If flag has been set
                return false;
            }
        }
    }
    /**
     * Attempts a shot at the specified row and column
     * @param row row of the shot
     * @param col column of the shot
     * @return an int representing if the shot hit, missed, was already shot, or was out of bounds
     * <ul><li>-1 if the shot was out of bounds</li>
     * <li>0 if the shot missed</li>
     * <li>1 if the shot hit</li>
     * <li>2 if the shot had already been taken</li></ul>
     */
    public int shoot(int row, int col) {
        try {
            if (squares[row][col] == '-') { // Shot missed
                squares[row][col] = 'm';
                return 0;
            } else if (squares[row][col] == 'b') { // Ship hit
                squares[row][col] = 'x';
                return 1;
            } else { // Square already guessed
                return 2;
            }
        } catch (IndexOutOfBoundsException e) { // Out of bounds
            return -1;
        }
    }
    /**
     * Checks if there is still a ship left on the board
     * @return true if there is no ship left
     * <li>false if a ship is still left</li>
     */
    public boolean gameOver() {
        for (char[] row: squares) { // For each row in squares
            for (char e: row) { // For each column in row
                if (e == 'b') { // If that element equals 'b'
                    return false;
                }
            }
        }
        return true; // If the loops have ended and no 'b' was found, then game over
    }
    /**
     * Checks if a ship of length len is found either vertically or horizontally on the board
     * @param len length of the ship being searched for
     * @return true if the ship was found
     * <li>false otherwise</li>
     */
    public boolean foundShip(int len) {
        char[][] temp = new char[squares.length][squares[0].length]; // Copy the squares array into a temp array
        for (int i=0; i<squares.length; i++) {
            for (int j=0; j<squares[i].length; j++) {
                temp[i][j] = squares[i][j];
            }
        }
        for (int i=0; i<temp.length; i++) { // For each row in temp
            for (int j=0; j<temp[i].length; j++) { // For each element in row
                if (temp[i][j] == 'b') { // If the element is b
                    int h = 1; // Declare vars for tracking vert and horiz ship length
                    int v = 1; // Initialized to 1 because a square of ship has already been found
                    temp[i][j] = '-'; // Remove the val in the temp array so that it won't trigger another event
                    for (int m=1; m<squares.length-i && m<squares[i].length-j; m++) { // While m is in bounds
                        if (temp[i][j+m] == 'b') { // If any of the squares to the right of [i][j] are also 'b'
                            h++; // Increment h
                            temp[i][j+m] = '-'; // Remove the val in the temp array so that it won't trigger another event
                        }
                        if (temp[i+m][j] == 'b') { // If any of the squares below [i][j] are also 'b'
                            v++; // Increment v
                            temp[i+m][j] = '-'; // Remove the val in the temp array so that it won't trigger another event
                        }
                    }
                    h = h > v ? h : 0; // Basically decides which direction the ship is facing
                    v = v > h ? v : 0; // (the larger value is preserved, the smaller val is set to 0)
                    if (h == len || v == len) { // If the horiz or vert ship length equals the input length
                        return true;
                    }
                }
            }
        }
        return false; // If no ship of correct length found, return false
    }
}