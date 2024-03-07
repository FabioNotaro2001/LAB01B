package e1;

public class ConcretePosition implements Position{
    private int row;
    private int column;

    public ConcretePosition(int row, int column){
        this.row = row;
        this.column = column;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }
    
}
