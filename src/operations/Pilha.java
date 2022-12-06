package operations;

import models.Activity;
import models.DefaultUser;
import models.Project;

import java.util.List;
import java.util.Stack;

public class Pilha extends Actions {
    private Stack setStkUndo;
    private Stack setStkRedo;

    public Pilha(List<DefaultUser> users, List<Project> projects, List<Activity> activities) {
        super(users, projects, activities);
    }

    public Stack getSetStkUndo() {
        return setStkUndo;
    }

    public void setStkUndo(Stack setStkUndo) {
        this.setStkUndo = setStkUndo;
    }

    public Stack getSetStkRedo() {
        return setStkRedo;
    }

    public void setSetStkRedo(Stack setStkRedo) {
        this.setStkRedo = setStkRedo;
    }

    public static void desfazer(Pilha undo, Pilha redo, List padrao) {
        try {
            Stack stk;
            stk = undo.getStkRedo();
            redo.setStkUndo(undo.getStkRedo());
            var popped = stk.peek();
            stk.pop();
            undo.setStkRedo(stk);
            if(padrao.contains(popped)){
                padrao.remove(popped);
            }
            else{
                padrao.add(popped);
            }
        } catch (IllegalArgumentException e){
            System.out.println("Empty list!");
        }


    }

    public static void refazer(Pilha undo, Pilha redo, List padrao){
        try {
            Stack stk;
            stk = undo.getStkRedo();
            stk.push(redo.getStkUndo());
            undo.setStkRedo(stk);
            var peeked = stk.peek();

            if (padrao.contains(peeked)) {
                padrao.remove(peeked);
            } else {
                padrao.add(peeked);
            }
        } catch (IllegalArgumentException e ){
            System.out.println("Empty list!");
        }
    }
}
