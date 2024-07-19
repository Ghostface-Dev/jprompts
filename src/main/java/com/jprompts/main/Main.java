package com.jprompts.main;

import com.jprompts.core.Prompt;
import com.jprompts.exception.InconsistentScriptTypeException;
import com.jprompts.exception.ResponseNoAllowed;
import com.jprompts.script.ConfirmScript;

public class Main {

    public static void main(String[] args) throws InconsistentScriptTypeException {

        Prompt prompt = new Prompt("confirm");

        prompt.addQuestion("teste");
        prompt.addQuestion("teste2");

        System.out.println(prompt.getType());

        ConfirmScript script = new ConfirmScript(prompt);

        do {
            script.execute(prompt);
        } while (!script.getInput().isValid());

        if (script.getAnwser().equalsIgnoreCase("n")) {
            System.out.println("ent vai tomar no cu");
        }
        if (script.getAnwser().equalsIgnoreCase("y")) {
            System.out.println("fds");
        }

        script.getInput().isValid();

    }

}
