package com.shan.algo.chess;

public class VerifyCheckMate {
	
	static final int N = 8;
	public static void main(String[] args) {

		// K = Black King; other = White coins
		String[][] chessBoard = {
				{".", ".", ".", "K", ".", ".", ".", "."},
				{".", ".", "P", ".", ".", ".", ".", "."},
				{".", ".", ".", ".", ".", ".", ".", "."},
				{".", ".", ".", ".", ".", ".", "P", "."},
				{".", ".", ".", ".", ".", ".", ".", "R"},
				{".", ".", "N", ".", ".", ".", ".", "."},
				{".", ".", ".", ".", ".", ".", ".", "."},
				{".", ".", ".", ".", ".", "Q", ".", "."}
				};
		if(checkKingSafe(chessBoard)) {
			System.out.println("King is not threatened");
		}else {
			System.out.println("King is threatened");
		}
	}

	private static boolean checkKingSafe(String[][] chessBoard) {
		String kCoOrds = findKingCoOrdinates(chessBoard);
		int kx = Integer.valueOf(kCoOrds.split("_")[0]), 
				ky = Integer.valueOf(kCoOrds.split("_")[1]);
		
		boolean isKingSafe = true;
		int i,j; 

		// row
		for(i=kx, j=0; j<N; j++) {
			if(chessBoard[i][j].equals("Q") || chessBoard[i][j].equals("R")) {
				isKingSafe = false;
			}
		}
		
		// column
		for(i=0, j=ky; j<N; j++) {
			if(chessBoard[i][j].equals("Q") || chessBoard[i][j].equals("R")) {
				isKingSafe = false;
			}
		}
		
		// left upper diagonal
        for (i=kx, j=ky; i>=0 && j>=0; i--, j--) {
        	if (chessBoard[i][j].equals("B")) 
            	isKingSafe = false;
        	
        	if( chessBoard[i][j].equals("P") && Math.abs(kx - i) == 1 && Math.abs(ky - j) == 1)
        		isKingSafe = false;
        }
             

        // left lower diagonal
        for (i=kx, j=ky; j>=0 && i<N; i++, j--) {
        	if (chessBoard[i][j].equals("B")) 
            	isKingSafe = false;
        	
        	if( chessBoard[i][j].equals("P") && Math.abs(kx - i) == 1 && Math.abs(ky - j) == 1)
        		isKingSafe = false;
        }
        
        // right upper diagonal
        for (i=kx, j=ky; i>=0 && j<N; i--, j++) {
        	if (chessBoard[i][j].equals("B")) 
            	isKingSafe = false;
        	
        	if( chessBoard[i][j].equals("P") && Math.abs(kx - i) == 1 && Math.abs(ky - j) == 1)
        		isKingSafe = false;
        }
             

        // right lower diagonal
        for (i=kx, j=ky; j<N && i<N; i++, j++) {
        	if (chessBoard[i][j].equals("B")) 
            	isKingSafe = false;
        	
        	if( chessBoard[i][j].equals("P") && Math.abs(kx - i) == 1 && Math.abs(ky - j) == 1)
        		isKingSafe = false;
        }
        
        //Knight check
        for(i=0; i<N; i++)
        	for(j=0;j<N;j++)
        		if(chessBoard[i][j].equals("N") && 
        				( (Math.abs(i - kx) == 1 && Math.abs(j-ky) == 2) || (Math.abs(i - kx) == 2 && Math.abs(j-ky) == 1)) 
        				)
        			isKingSafe = false;
        
        return isKingSafe;
        
	}

	private static String findKingCoOrdinates(String[][] chessBoard) {
		boolean isKingFound = false;
		int kx =0 , ky = 0;
		for (int i = 0; i < N && !isKingFound; i++) { 
			 for (int j = 0; j < N && !isKingFound; j++)
				 if(chessBoard[i][j].equals("K")) {
					 kx = i; 
					 ky = j;
					 break;
				 }
		 }
		return kx+"_"+ky;
	}

}
