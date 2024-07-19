package com.jprompts.main;

import com.jprompts.core.Prompt;
import com.jprompts.exception.InconsistentScriptTypeException;

import com.jprompts.script.ListScript;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InconsistentScriptTypeException {

        Prompt prompt = new Prompt("LIST");

        prompt.addQuestion("teste");
        prompt.addQuestion("teste2");

        ListScript script = new ListScript(prompt);

        script.execute(prompt);

        if (script.getAnwser().equalsIgnoreCase("2")) {
            System.out.println("blz...");
        }
    }

}
