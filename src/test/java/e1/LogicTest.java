package e1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    Logics logic;

    @Test
    public void testAcceptableSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.logic = new LogicsImpl(-1);
        });
    }

    @BeforeEach
    public void correctSpawn() {
        Position wishedSimplePawnPosition = new ConcretePosition(0, 0);
        Position wishedKnightPosition = new ConcretePosition(3, 3);
        this.logic = new LogicsImpl(6, wishedSimplePawnPosition, wishedKnightPosition);
    }

    @Test
    public void checkPawnsArePositioned(){
        Position knownSimplePawnPosition = new ConcretePosition(0, 0);
        Position knownKnightPosition = new ConcretePosition(3, 3);
        assertAll(
            () -> assertTrue(this.logic.hasKnight(knownKnightPosition)),
            () -> assertTrue(this.logic.hasSimplePawn(knownSimplePawnPosition))
        );
    }

    @Test
    public void checkTheKnightMovesAwayFromItsOriginalPosition() {
        Position targetPosition = new ConcretePosition(1, 2);
        Position knightPosition = this.logic.getKnight().getPosition();
        logic.moveKnight(targetPosition);
        assertFalse(this.logic.hasKnight(knightPosition));
    }

    @Test
    public void checkTheKnightsCanMoveWithLShape() {
        assertAll(
            () -> {
                this.checkPawnsArePositioned();
                Position targetPosition = new ConcretePosition(1, 2);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            },
            () -> {
                this.correctSpawn();
                Position targetPosition = new ConcretePosition(1, 4);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            },
            () -> {
                this.correctSpawn();
                Position targetPosition = new ConcretePosition(2, 1);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            },
            () -> {
                this.correctSpawn();
                Position targetPosition = new ConcretePosition(2, 5);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            },
            () -> {
                this.correctSpawn();
                Position targetPosition = new ConcretePosition(4, 1);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            },
            () -> {
                this.correctSpawn();
                Position targetPosition = new ConcretePosition(4, 5);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            },
            () -> {
                this.correctSpawn();
                Position targetPosition = new ConcretePosition(5, 2);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            },
            () -> {
                this.correctSpawn();
                Position targetPosition = new ConcretePosition(5, 4);
                this.logic.moveKnight(targetPosition); 
                assertTrue(this.logic.hasKnight(targetPosition));
            }
        );
    }

    @Test
    public void checkTheKnightsCannotMovesWithoutLShape() {
        Position knightInitialPosition = this.logic.getKnight().getPosition();
        Position targetWrongPosition = new ConcretePosition(4, 4);
        this.logic.moveKnight(targetWrongPosition);
        assertAll(
            () -> assertFalse(this.logic.hasKnight(targetWrongPosition)),
            () -> assertTrue(this.logic.hasKnight(knightInitialPosition))
        );
    }

    @Test
    public void checkCorrectEating(){
        Position wishedSimplePawnPosition = new ConcretePosition(1, 2);
        Position wishedKnightPosition = new ConcretePosition(3, 3);
        this.logic = new LogicsImpl(6, wishedSimplePawnPosition, wishedKnightPosition);
        assertTrue(this.logic.moveKnight(wishedSimplePawnPosition));
    }

    @Test
    public void checkCorrectGeneratingPawn(){
        Pawn knight = this.logic.getKnight();
        Pawn simplePawn = this.logic.getSimplePawn();
        assertAll(
            () -> assertTrue(this.logic.hasKnight(knight.getPosition())),
            () -> assertTrue(this.logic.hasSimplePawn(simplePawn.getPosition()))
        );
    }

}

