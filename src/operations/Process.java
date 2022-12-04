package operations;

import models.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Process {
    public static void processMenuExt(MenuExt menu, int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Activity> listActivities, MenuInt menu1){
        boolean ready = false;
        while(!ready){
            try {
                menu.optMenuE(logged, listUser, identificador, redo, undo, listProject, listActivities, menu, menu1);
            } catch (ParseException e){
                System.out.println("Date format wrong, please use -> (dd/MM/yyyy hh:mm:ss)" + " - " + "Error: " + e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("Wrong input." +
                        "You tiped a value that is not an integer: " +
                        e.getMessage());
            }
            catch( NullPointerException e){
                System.out.println("Not found activities! Error: " + e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Option not valid!");
            }
            finally {
                ready = true;
            }
        }
    }
    public static void processMenuInt(MenuInt menu, Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Activity> listActivity, Pilha undo){
        boolean ready = false;
        while(!ready){
            try {
                menu.optMenuI(input, listUser, identificador, password, logged, listProject, redo, listActivity, undo);
            } catch (ParseException e){
                System.out.println("Date format wrong, please use -> (dd/MM/yyyy hh:mm:ss)" + "Error: " + e.getMessage());
            } catch( NullPointerException e){
                System.out.println("Not found activities! Error: " + e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Option not valid!");
            } catch (NumberFormatException e){
                System.out.println("Wrong input." +
                        "You tiped a value that is not an integer: " +
                        e.getMessage());
            }
            finally {
                ready = true;
            }
        }
    }
    public static void init(){
        MenuExt menuE = new MenuExt();
        MenuInt menuI = new MenuInt();
        List<DefaultUser> listUser = new ArrayList<>();
        List<Activity> listActivity = new ArrayList<>();
        List<Project> listProject = new ArrayList<>();
        Pilha redo = new Pilha(), undo = new Pilha();
        int logged = 0, identificador = 0;
        while(true) {
            processMenuExt(menuE, logged, listUser, identificador, redo, undo, listProject, listActivity, menuI);
            break;
        }
    }
}
