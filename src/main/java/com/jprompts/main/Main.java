package com.jprompts.main;

import com.jprompts.core.Prompt;
import com.jprompts.response.Script;
import com.jprompts.script.ConfirmScript;
import com.jprompts.script.ListScript;

public class Main {

    public static void main(String[] args) {

        Prompt prompt = new Prompt("confirm");

        prompt.addQuestion("teste");
        prompt.addQuestion("teste2");

        ConfirmScript script = new ConfirmScript(prompt);

        script.outDesignPrompt(prompt.getQuestions());

    }

}
