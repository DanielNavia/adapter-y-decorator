package co.edu.unicauca.commandrestaurant.domain;

import java.util.Stack;

/**
 * Invocador de comandos. Ejecuta y deshace los comandos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Invoker {

    /**
     * Comando a ser invocado
     */
    private FoodCommand cmd;
    /**
     * Pila de operaciones deshacer
     */
    private final Stack<FoodCommand> undoStack;

    /**
     * Constructor
     */
    public Invoker() {
        undoStack = new Stack<>();
    }

    public void setCommand(FoodCommand cmd) {
        this.cmd = cmd;
    }

    public FoodCommand getCommand() {
        return cmd;
    }

    /**
     * Ejecuta el comando
     */
    public void execute() {
        if (cmd.hasUndo) {
            undoStack.push(cmd);
        }
        cmd.execute();
    }

    /**
     * Ejecuta la operación de deshacer
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            FoodCommand cmdAux = undoStack.pop();
            cmdAux.undo();
        }
    }

    /**
     * Tiene comandos en la pila?
     *
     * @return true si lo tiene, false si no
     */
    public boolean hasCommandUndo() {
        return !undoStack.isEmpty();
    }

}
