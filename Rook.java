
public class Rook extends Piece{

	public String color;
	
	public Rook(String color){
		this.color = color;
	}
	
	public boolean validateMove(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		// TODO Auto-generated method stub
		
		System.out.println("currentRow: " + currentRow + " currentCol: " + currentCol + " newRow: " + newRow + " newCol: " + newCol);
		
		if(currentRow != newRow && currentCol != newCol){
			//Did not move along one rank/file
			return false;
		}
		
		//First I will assumed the Rook is moving along the rows.
		int offset;
		
		if(currentRow != newRow){
			if(currentRow < newRow){
				offset = 1;
			}else{
				offset = -1;
			}
			
			for(int x = currentRow + offset; x != newRow; x += offset){
				//Go from currentRow to newRow, and check every space
				if(board[x][currentCol] != null){
					System.out.println("1 " + x);
					return false;
				}
			}
		}
	
		//Now do the same for columns
		if(currentCol != newCol){
			if(currentCol < newCol){
				offset = 1;
			}else{
				offset = -1;
			}
			
			for(int x = currentCol + offset; x != newCol; x += offset){
				//Go from currentCol to newCol, and check every space
				if(board[currentRow][x] != null){
					System.out.println("2");
					return false;
				}
			}
		}
		
		return true;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String toString(){
		return color.charAt(0) + "R";
		
	}

}
