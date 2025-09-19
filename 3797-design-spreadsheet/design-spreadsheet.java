class Spreadsheet {
    private final int[][] matrix;
    private final int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        matrix = new int[rows + 1][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        matrix[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        matrix[row][col] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] parts = formula.split("\\+");
        int sum = 0;
        for (String part : parts) {
            if (Character.isLetter(part.charAt(0))) {
                int col = part.charAt(0) - 'A';
                int row = Integer.parseInt(part.substring(1));
                sum += matrix[row][col];
            } else {
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell, value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
