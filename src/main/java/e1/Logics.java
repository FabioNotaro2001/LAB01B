package e1;

public interface Logics{
    
    /**
     * attempt to move Knight on position if possible
     * 
     * @param targetPosition is the wished position in which the knight has to move
     * @return whether the pawn has been hit by the knight
     */
    boolean moveKnight(Position targetPosition);
    
    /**
     * Check if the position passed contains the knight
     * 
     * @param positionToCheck represents the position to be checked
     * @return whether position passed has the knight
     */
    boolean hasKnight(Position positionToCheck);
    
    /**
     * Check if the position passed contains the simple pawn
     * 
     * @param positionToCheck represents the position to be checked
     * @return whether position passed has the pawn
     */
    boolean hasSimplePawn(Position positionToCheck);

    /**
     * Getter for the simple pawn
     * 
     * @return the simple pawn
     */
    Pawn getSimplePawn();

    /**
     * Getter for the knight
     * 
     * @return the knight
     */
    Pawn getKnight();
}
