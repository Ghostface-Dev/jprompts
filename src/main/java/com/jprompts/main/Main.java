package com.jprompts.main;


import com.jprompts.template.Prompt;
import com.jprompts.template.confirm.ConfirmPrompt;
import com.jprompts.template.input.InputPrompt;
import com.jprompts.template.list.ListPrompt;

public class Main {

    public static void main(String[] args) {

        ListPrompt prompt = new ListPrompt();

        prompt.addQuestion("test1", 1);
        prompt.addQuestion("test2", 2);
        prompt.addQuestion("test3", 3);

        prompt.run();

        System.out.println(prompt.getAnwser(3));

    }
}
