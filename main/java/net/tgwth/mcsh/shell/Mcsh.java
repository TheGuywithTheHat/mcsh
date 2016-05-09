package net.tgwth.mcsh.shell;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.tgwth.mcsh.gui.GuiMcsh;

public class Mcsh implements ICommandSender {
    GuiMcsh parent;
    HashMap<String, CommandFactory> commandMap = new HashMap<>();
    
    public Mcsh(GuiMcsh parent) {
        this.parent = parent;
        
        commandMap.put("achievement", McCommand::new);
        commandMap.put("ban", McCommand::new);
        commandMap.put("ban-ip", McCommand::new);
        commandMap.put("banlist", McCommand::new);
        commandMap.put("blockdata", McCommand::new);
        commandMap.put("clear", McCommand::new);
        commandMap.put("clone", McCommand::new);
        commandMap.put("debug", McCommand::new);
        commandMap.put("defaultgamemode", McCommand::new);
        commandMap.put("deop", McCommand::new);
        commandMap.put("difficulty", McCommand::new);
        commandMap.put("effect", McCommand::new);
        commandMap.put("enchant", McCommand::new);
        commandMap.put("entitydata", McCommand::new);
        commandMap.put("execute", McCommand::new);
        commandMap.put("fill", McCommand::new);
        commandMap.put("gamemode", McCommand::new);
        commandMap.put("gamerule", McCommand::new);
        commandMap.put("give", McCommand::new);
        commandMap.put("help", McCommand::new);
        commandMap.put("kick", McCommand::new);
        commandMap.put("kill", McCommand::new);
        commandMap.put("list", McCommand::new);
        commandMap.put("me", McCommand::new);
        commandMap.put("op", McCommand::new);
        commandMap.put("pardon", McCommand::new);
        commandMap.put("particle", McCommand::new);
        commandMap.put("playsound", McCommand::new);
        commandMap.put("publish", McCommand::new);
        commandMap.put("replaceitem", McCommand::new);
        commandMap.put("save-all", McCommand::new);
        commandMap.put("save-off", McCommand::new);
        commandMap.put("save-on", McCommand::new);
        commandMap.put("say", McCommand::new);
        commandMap.put("scoreboard", McCommand::new);
        commandMap.put("seed", McCommand::new);
        commandMap.put("setblock", McCommand::new);
        commandMap.put("setidletimeout", McCommand::new);
        commandMap.put("setworldspawn", McCommand::new);
        commandMap.put("spawnpoint", McCommand::new);
        commandMap.put("spreadplayers", McCommand::new);
        commandMap.put("stats", McCommand::new);
        commandMap.put("stop", McCommand::new);
        commandMap.put("summon", McCommand::new);
        commandMap.put("tell", McCommand::new);
        commandMap.put("tellraw", McCommand::new);
        commandMap.put("testfor", McCommand::new);
        commandMap.put("testforblock", McCommand::new);
        commandMap.put("testforblocks", McCommand::new);
        commandMap.put("time", McCommand::new);
        commandMap.put("title", McCommand::new);
        commandMap.put("toggledownfall", McCommand::new);
        commandMap.put("tp", McCommand::new);
        commandMap.put("trigger", McCommand::new);
        commandMap.put("weather", McCommand::new);
        commandMap.put("whitelist", McCommand::new);
        commandMap.put("worldborder", McCommand::new);
        commandMap.put("xp", McCommand::new);
    }
    
    public int execute(String input) {
        String base = input.split("\\s")[0];
        CommandFactory command = commandMap.get(base);
        if(command == null) {
            parent.out.println("Invalid command " + base);
            return 1;
        }
        command.go(this, input);
        return 0;
    }

    @Override
    public String getName() {
        return Minecraft.getMinecraft().thePlayer.getName();
    }

    @Override
    public ITextComponent getDisplayName() {
        return Minecraft.getMinecraft().thePlayer.getDisplayName();
    }

    @Override
    public void addChatMessage(ITextComponent component) {
        parent.out.println(component.getUnformattedText());
    }

    @Override
    public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
        return Minecraft.getMinecraft().thePlayer.canCommandSenderUseCommand(permLevel, commandName);
    }

    @Override
    public BlockPos getPosition() {
        return Minecraft.getMinecraft().thePlayer.getPosition();
    }

    @Override
    public Vec3d getPositionVector() {
        return Minecraft.getMinecraft().thePlayer.getPositionVector();
    }

    @Override
    public World getEntityWorld() {
        return Minecraft.getMinecraft().theWorld;
    }

    @Override
    public Entity getCommandSenderEntity() {
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public boolean sendCommandFeedback() {
        return true;
    }

    @Override
    public void setCommandStat(Type type, int amount) {
        Minecraft.getMinecraft().thePlayer.setCommandStat(type, amount);
        
    }

    @Override
    public MinecraftServer getServer() {
        return Minecraft.getMinecraft().thePlayer.getServer();
    }
}
