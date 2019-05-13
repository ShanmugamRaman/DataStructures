package com.shan.algo.chess;

public class NQueens {

	static final int N = 8;

	public static void main(String[] args) {
		placeNQueens();
	}

	private static void placeNQueens() {
		int colNum = 0;
		int[][] chessBoard = new int[N][N];
		if(placeNQueenRecur(chessBoard, colNum)) {
			printChessBoard(chessBoard);
		}
	}

	private static void printChessBoard(int[][] chessBoard) {
		 for (int i = 0; i < N; i++) { 
			 for (int j = 0; j < N; j++) 
				 System.out.print(" " + chessBoard[i][j] + " "); 
	            
			 System.out.println(); 
		 } 		
	}

	private static boolean placeNQueenRecur(int[][] chessBoard, int colNum) {

		if(colNum == N) {
			return true;
		}
		
		for(int rowNum = 0; rowNum < N; rowNum++) {
			
			if(isSafe(chessBoard, rowNum, colNum)) {
			
				chessBoard[rowNum][colNum] = 1;
				
				if(placeNQueenRecur(chessBoard, colNum+1)) {
					return true;
				}
				
				chessBoard[rowNum][colNum] = 0;	
			}
		}
		
		return false;
	}
	
	private static boolean isSafe(int[][] chessBoard, int row, int col) {
		 int i, j; 
		  
        /* Check this row on left side */
        for (i = 0; i < col; i++) 
            if (chessBoard[row][i] == 1) 
                return false; 
  
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--) 
            if (chessBoard[i][j] == 1) 
                return false; 
  
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<N; i++, j--) 
            if (chessBoard[i][j] == 1) 
                return false; 
  
        return true; 
	}
	
}
