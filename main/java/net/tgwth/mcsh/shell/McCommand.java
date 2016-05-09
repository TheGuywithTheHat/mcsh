package net.tgwth.mcsh.shell;

import net.minecraft.client.Minecraft;

public class McCommand extends Command {
    public McCommand(Mcsh parent, String command) {
        super(parent, command);
        //Minecraft.getMinecraft().getServer().getCommandManager().executeCommand(parent, command);
        Minecraft.getMinecraft().getIntegratedServer().getCommandManager().executeCommand(parent, command);
    }
}
