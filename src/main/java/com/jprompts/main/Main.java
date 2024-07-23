package com.jprompts.main;

import com.jprompts.core.menu.MenuPrompt;
import com.jprompts.core.option.OptionPrompt;

public class Main {

    public static void main(String[] args) {

        MenuPrompt menuPrompt = new MenuPrompt();

        menuPrompt.addQuestion("test1", 1);
        menuPrompt.addQuestion("test1", 2);
        menuPrompt.addQuestion("test1", 3);

        menuPrompt.run();
    }
}
