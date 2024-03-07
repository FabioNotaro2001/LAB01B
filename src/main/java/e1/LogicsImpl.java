package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	private static final int MINIMUM_SIZE = 3;

	private SimplePawn simplePawn;
	private Knight knight;
	private final int size;
	 
    public LogicsImpl(int size){
		this.checkAcceptableSize(size);
		this.size = size;
        this.simplePawn = new SimplePawn(this.getRandomEmptyPosition());
		this.knight = new Knight(this.getRandomEmptyPosition());
    }

	// More explicit constructor useful for testing purposes.
	public LogicsImpl(int size, Position simplePawnPosition, Position knighPosition){
		this.checkAcceptableSize(size);
		this.size = size;
		this.simplePawn = new SimplePawn(simplePawnPosition);
		this.knight = new Knight(knighPosition);
	}
    
	@Override
	public boolean moveKnight(Position targePosition) {
		this.knight.move(targePosition, this.size);
		return this.checkIfKnightHasEatenSimplePawn();
	}

	@Override
	public boolean hasKnight(Position positionToBeChecked) {
		return this.knight.getPosition().getRow() == positionToBeChecked.getRow() && 
				this.knight.getPosition().getColumn() == positionToBeChecked.getColumn();
	}

	@Override
	public boolean hasSimplePawn(Position positionToBeChecked) {
		return this.simplePawn.getPosition().getRow() == positionToBeChecked.getRow() && 
				this.simplePawn.getPosition().getColumn() == positionToBeChecked.getColumn();
	}

	@Override
	public Pawn getSimplePawn() {
		return this.simplePawn;
	}

	@Override
	public Pawn getKnight() {
		return this.knight;
	}

	private void checkAcceptableSize(int passedSize){
		if(passedSize < MINIMUM_SIZE){
			throw new IllegalArgumentException("Size must be at least 3!");
		}
	}
    
	private final Position getRandomEmptyPosition(){
		final Random random = new Random();
		Position extractedPosition = new ConcretePosition(random.nextInt(this.size), random.nextInt(this.size));
    	return this.simplePawn != null && this.simplePawn.getPosition().equals(extractedPosition) ? getRandomEmptyPosition() : extractedPosition;
    }

	private boolean checkIfKnightHasEatenSimplePawn() {
		return (this.simplePawn.getPosition().getRow() == this.knight.getPosition().getRow() && this.simplePawn.getPosition().getColumn() == this.knight.getPosition().getColumn());
	}
}
