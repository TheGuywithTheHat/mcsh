package net.tgwth.mcsh.shell;

public interface CommandFactory {
    public Command go(Mcsh parent, String command);
}
