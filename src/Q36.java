public class Q36 {
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int box = (i / 3) * 3 + j / 3;

                    if (rows[i][num] || cols[j][num] || boxes[box][num]) {
                        return false;
                    }

                    rows[i][num] = cols[j][num] = boxes[box][num] = true;
                }
            }
        }

        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    int num = board[row][col] - '1';
                    int boxIndex = (row / 3) * 3 + col / 3;

                    int bit = (1 << num);

                    if ((rows[row] & bit) != 0 || (cols[col] & bit) != 0 || (boxes[boxIndex] & bit) != 0) {
                        return false;
                    }

                    rows[row] |= bit;
                    cols[col] |= bit;
                    boxes[boxIndex] |= bit;
                }
            }
        }
        return true;
    }
}
