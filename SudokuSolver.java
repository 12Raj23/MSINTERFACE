public class SudokuSolver {

        private static final int SIZE = 9; // Size of the grid

        // Method to solve the Sudoku puzzle
        public boolean solveSudoku(int[][] board) {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    // If the current cell is empty
                    if (board[row][col] == 0) {
                        // Try filling the cell with numbers 1-9
                        for (int num = 1; num <= SIZE; num++) {
                            if (isSafe(board, row, col, num)) {
                                board[row][col] = num;
                                // Recursively solve the rest of the grid
                                if (solveSudoku(board)) {
                                    return true;
                                }
                                // If it leads to no solution, backtrack
                                board[row][col] = 0;
                            }
                        }
                        // If no number can be placed in this cell, return false
                        return false;
                    }
                }
            }
            // If the entire grid is filled, return true
            return true;
        }

        // Method to check if a number can be placed in a specific cell
        private boolean isSafe(int[][] board, int row, int col, int num) {
            // Check the row
            for (int i = 0; i < SIZE; i++) {
                if (board[row][i] == num) {
                    return false;
                }
            }

            // Check the column
            for (int i = 0; i < SIZE; i++) {
                if (board[i][col] == num) {
                    return false;
                }
            }

            // Check the 3x3 sub-grid
            int startRow = row - row % 3;
            int startCol = col - col % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i + startRow][j + startCol] == num) {
                        return false;
                    }
                }
            }

            return true;
        }

        // Method to print the Sudoku board
        public void printBoard(int[][] board) {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            SudokuSolver solver = new SudokuSolver();

            // Sample Sudoku puzzle (0 represents an empty cell)
            int[][] board = {
                    {5, 3, 0, 0, 7, 0, 0, 0, 0},
                    {6, 0, 0, 1, 9, 5, 0, 0, 0},
                    {0, 9, 8, 0, 0, 0, 0, 6, 0},
                    {8, 0, 0, 0, 6, 0, 0, 0, 3},
                    {4, 0, 0, 8, 0, 3, 0, 0, 1},
                    {7, 0, 0, 0, 2, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 2, 8, 0},
                    {0, 0, 0, 4, 1, 9, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };

            if (solver.solveSudoku(board)) {
                solver.printBoard(board);
            } else {
                System.out.println("No solution exists.");
            }
        }
    }
