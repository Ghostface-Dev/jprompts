package com.jprompts.main;


import com.jprompts.command.Prompt;
import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Main {

    public static void main(String[] args) {

        Prompt prompt = new Prompt("confirm");

        prompt.addQuestion("Deposit");
        prompt.addQuestion("Transference");
        prompt.addQuestion("Create Customer");

        prompt.run();



    }

}
