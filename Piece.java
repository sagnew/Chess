public abstract class Piece {
	
	public String color;
	
	/**
	 * Gets the color
	 * @return color of the piee
	 */
	public abstract String getColor();
	
	/**
	 * Moves the piece 
	 * 
	 * @return true if the move was valid or not.
	 */
	public abstract boolean validateMove(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol);

}
