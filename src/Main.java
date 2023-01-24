public class Main {
    public static int[][] model;

    public static void main(String[] args) {
        Main game = new Main();
        game.setField();
        game.solveSudoku();
        game.displaySudoku();

    }

    public void setField() {
        model = new int[9][9];
        model[0][0] = 9;
        model[0][4] = 2;
        model[0][6] = 7;
        model[0][7] = 5;

        model[1][0] = 6;
        model[1][4] = 5;
        model[1][7] = 4;

        model[2][1] = 2;
        model[2][3] = 4;
        model[2][7] = 1;

        model[3][0] = 2;
        model[3][2] = 8;

        model[4][1] = 7;
        model[4][3] = 5;
        model[4][5] = 9;
        model[4][7] = 6;

        model[5][6] = 4;
        model[5][8] = 1;

        model[6][1] = 1;
        model[6][5] = 5;
        model[6][7] = 8;

        model[7][1] = 9;
        model[7][4] = 7;
        model[7][8] = 4;

        model[8][1] = 8;
        model[8][2] = 2;
        model[8][4] = 4;
        model[8][8] = 6;
    }


    private boolean containsInRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (model[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean containsInCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (model[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean containsInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (model[i][j] == number) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isAllowed(int row, int col, int number) {
        return !(containsInRow(row, number) || containsInCol(col, number) || containsInBox(row, col, number));
    }

    public boolean solveSudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (model[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isAllowed(row, col, number)) {
                            model[row][col] = number;
                            if (solveSudoku()) {
                                return true;
                            } else {
                                model[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void displaySudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------------------------------\n");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + model[i][j] + " ");

            }

            System.out.println();
        }
        System.out.println("\n\n__________________________________________\n\n");
    }
}