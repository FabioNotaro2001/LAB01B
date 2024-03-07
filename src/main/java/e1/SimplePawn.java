package e1;

public class SimplePawn implements Pawn{
    private Position position;

    public SimplePawn(final Position spawningPosition){
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
}
