package com.jprompts.main;

import com.jprompts.core.Prompt;
import com.jprompts.exception.InconsistentScriptException;

import com.jprompts.script.InputScript;

public class Main {

    public static void main(String[] args) throws InconsistentScriptException {

        Prompt prompt = new Prompt("LIST");

        prompt.addQuestion("quem é o melhor?");
        prompt.addQuestion("quantos anos?");

        InputScript script = new InputScript(prompt);

        script.execute(prompt);

        if (script.getAnwser("quem é o melhor?").equalsIgnoreCase("shawlin")) {
            System.out.println("acertou");
        }else {
            System.out.println("caBAÇO");
        }

    }

}
