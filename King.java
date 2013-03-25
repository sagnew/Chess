
public class King extends Piece{
	
	public String color;
	public boolean hasMoved;
	public boolean castled;
	
	public King(String color){
		this.color = color;
		this.hasMoved = false;
		this.castled = false;
	}

	@Override
	public boolean validateMove(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		
		if(Math.abs(newRow - currentRow) > 1 || Math.abs(newCol - currentCol) > 1){
			
			if(hasMoved){
				return false;
			}
			
			//Do castling logic here
			if(newCol - currentCol == 2 && currentRow == newRow){
				//Castle kingside
				if(board[newRow][currentCol + 1] != null || board[newRow][currentCol + 2] != null){
					castled = false;
					return false;
				}
				
			}else if(currentCol - newCol == 3 && currentRow == newRow){
				if(board[newRow][currentCol - 1] != null || board[newRow][currentCol - 2] != null || board[newRow][currentCol - 3] != null){
					castled = false;
					return false;
				}
				
			}else{
				castled = false;
				return false;
			}
			
			castled = true;
			
		}
		
		//hasMoved = true;
		return true;
	}
	
	public String getColor(){
		return this.color;
	}

	public String toString(){
		return color.charAt(0) + "K";	
	}
	
}
