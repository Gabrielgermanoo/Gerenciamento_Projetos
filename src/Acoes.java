import java.util.Stack;

public class Acoes {
    private Stack stkUndo;
    private Stack stkRedo;

    public Stack getStkUndo() {
        return stkUndo;
    }

    public void setStkUndo(Stack stkUndo) {
        this.stkUndo = stkUndo;
    }

    public Stack getStkRedo() {
        return stkRedo;
    }

    public void setStkRedo(Stack stkRedo) {
        this.stkRedo = stkRedo;
    }
}
