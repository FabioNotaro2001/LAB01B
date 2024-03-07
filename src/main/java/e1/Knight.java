package e1;

public class Knight implements Pawn{
    private Position position;

    public Knight(final Position spawningPosition){
        this.position = spawningPosition;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(Position targetPosition, int mapSize){
        this.checkIfTargetPositionIsWrong(targetPosition, mapSize);
		int x = targetPosition.getRow()-this.position.getRow();	
		int y = targetPosition.getColumn()-this.position.getColumn();	
		if (checkMovementHasLShape(x, y)) {
			this.setPosition(targetPosition);
        }
    }

    private void checkIfTargetPositionIsWrong(Position positionToBeChecked, int mapSize){
        if(positionToBeChecked.getRow() < 0 || positionToBeChecked.getColumn() < 0 || 
            positionToBeChecked.getRow() >= mapSize || positionToBeChecked.getColumn() >= mapSize){
                throw new IllegalArgumentException("The knight is asked to move to an impossibile position!");
            }
    }

    private boolean checkMovementHasLShape(int row, int column){
        return row !=0 && column != 0 && Math.abs(row) + Math.abs(column) ==3;
    }
}
