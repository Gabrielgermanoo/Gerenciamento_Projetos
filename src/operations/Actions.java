package operations;

import models.Activity;
import models.DefaultUser;
import models.Project;

import java.text.ParseException;
import java.util.*;

public abstract class Actions {
    private Stack setStkUndo;
    private Stack setStkRedo;

    public Stack getStkUndo() { return setStkUndo; }

    public void setStkUndo(Stack setStkUndo) { this.setStkUndo = setStkUndo; }

    public Stack getStkRedo() { return setStkRedo; }

    public void setStkRedo(Stack setStkRedo) { this.setStkRedo = setStkRedo; }


}
