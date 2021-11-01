package com.company;

final public class PascalsTriangle {
    private final int n;
    private Long[][] matrix;
    PascalsTriangle (int n) {
        if(n < 0){
            n = 0;
        }
        this.n = n;
        generatePascalsTriangle();
    }
    public Long[][] getPascalsMatrix(){
        return matrix;
    }
    public void generatePascalsTriangle() {
        matrix = new Long[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = (j <= i ? 1l : 0l);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= i; ++j) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
    }
}




