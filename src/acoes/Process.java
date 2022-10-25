package acoes;

import models.*;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Process {
    public static void processMenuExt(MenuExt menu, int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Atividade> listAtividades, MenuInt menu1){
        boolean ready = false;
        while(!ready){
            try {
                menu.opcoesMenuE(logged, listUser, identificador, redo, undo, listProject, listAtividades, menu, menu1);
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
    public static void processMenuInt(MenuInt menu, Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Atividade> listAtividade, Pilha undo){
        boolean ready = false;
        while(!ready){
            try {
                menu.opcoesMenuI(input, listUser, identificador, password, logged, listProject, redo, listAtividade, undo);
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
}
