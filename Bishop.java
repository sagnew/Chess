
public class Bishop extends Piece{

	public String color;
	
	public Bishop(String color){
		this.color = color;
	}
	
	@Override
	public boolean validateMove(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		
		if(currentRow == newRow || currentCol == newCol){
			//Did not move diagonally
			return false;
		}
		
		if(Math.abs(newRow - currentRow) != Math.abs(newCol - currentCol)){
			return false;
		}
		
		int rowOffset, colOffset;
		
		if(currentRow < newRow){
			rowOffset = 1;
		}else{
			rowOffset = -1;
		}
		
		if(currentCol < newCol){
			colOffset = 1;
		}else{
			colOffset = -1;
		}
		
		int y = currentCol + colOffset;
		for(int x = currentRow + rowOffset; x != newRow; x += rowOffset){
			
			if(board[x][y] != null){
				return false;
			}
			
			y += colOffset;
		}
		
		return true;
		
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String toString(){
		return color.charAt(0) + "B";
		
	}

}
