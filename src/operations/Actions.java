package operations;

import models.Activity;
import models.DefaultUser;
import models.Project;

import java.util.List;
import java.util.Stack;

public abstract class Actions {

    protected List<DefaultUser> listUser;
    protected List<Project> listProject;
    protected List<Activity> listActivities;

    public Actions(List<DefaultUser> users, List<Project> projects, List<Activity> activities){
        this.listUser = users;
        this.listProject = projects;
        this.listActivities = activities;
    }

    private Stack setStkUndo;
    private Stack setStkRedo;

    public Stack getStkUndo() { return setStkUndo; }

    public void setStkUndo(Stack setStkUndo) { this.setStkUndo = setStkUndo; }

    public Stack getStkRedo() { return setStkRedo; }

    public void setStkRedo(Stack setStkRedo) { this.setStkRedo = setStkRedo; }

}
