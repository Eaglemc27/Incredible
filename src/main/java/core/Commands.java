package core;

import java.lang.reflect.Method;
import java.util.HashMap;

class Commands {
    private static HashMap<String, Command> commands;

    static Object executeCommand(Method method, Object proxy, ElementFinder finder, Object[] args) {
        if(commands == null)
            fillCommands();
        Command command = commands.get(method.getName());
        if(command != null)
           return command.execute((SmartElement) proxy, finder, args);
        else
            throw new RuntimeException("There is no command with such name: " + method.getName());
    }

    private static void fillCommands() {
        commands = new HashMap<>();
        commands.put("click", Command.click());
        commands.put("sendKeys", Command.sendKeys());
        commands.put("should", Command.should());
    }
}
