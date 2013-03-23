
public class Pawn extends Piece {

	public String color;
	private boolean hasMoved;
	
	public Pawn(String color){
		this.color = color;
		this.hasMoved = false;
	}
	
	public boolean validateMove(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {

		if(color.equals("white")){
			if(currentRow > newRow){
				return false;
			}
		}else{
			if(newRow > currentRow){
				return false;
			}
		}
		
		if(currentCol == newCol){
			//Not taking a piece
			if(color.equals("white")){
				if(board[currentRow + 1][currentCol] != null){
					return false;
				}
			}else{
				if(board[currentRow - 1][currentCol] != null){
					return false;
				}
			}
			
			if(Math.abs(newRow - currentRow) > 2){
				return false;
			}else if(Math.abs(newRow - currentRow) == 2){
				//Advancing two spaces at beginning
				if(hasMoved){
					return false;
				}
				
				if(color.equals("white")){
					if(board[currentRow + 2][currentCol] != null){
						return false;
					}
				}else{
					if(board[currentRow - 2][currentCol] != null){
						return false;
					}
				}
				
			}
		}else{
			//Taking a piece
			if(Math.abs(newCol - currentCol) != 1 || Math.abs(newRow - currentRow) != 1){
				return false;
			}
			
			if(board[newRow][newCol] == null){
				return false;
			}
		}
		
		if(!hasMoved){
			hasMoved = true;
		}
		
		return true;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String toString(){
		return color.charAt(0) + "p";
		
	}

}