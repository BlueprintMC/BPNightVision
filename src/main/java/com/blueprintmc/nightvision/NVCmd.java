package com.blueprintmc.nightvision;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NVCmd implements CommandExecutor
{
    private BPNightVision plugin;

    public NVCmd(BPNightVision plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        switch (args.length)
        {
            case 0:
                sender.sendMessage("");
                sender.sendMessage(plugin.getMessage(BPNVLang.DEFAULT));
                sender.sendMessage("");
                break;
            case 1:
                switch (args[0].toLowerCase())
                {
                    case "help":
                        sender.sendMessage(plugin.getMessage(BPNVLang.HELP));
                        break;
                    case "on":
                        sender.sendMessage(plugin.getMessage(BPNVLang.ON));
                        break;
                    case "off":
                        sender.sendMessage(plugin.getMessage(BPNVLang.OFF));
                        break;
                    case "list":
                        sender.sendMessage(plugin.getMessage(BPNVLang.LIST));
                        break;
                    default:
                        sender.sendMessage(plugin.getMessage(BPNVLang.INVALID));
                        break;
                }
                break;
            default:
                sender.sendMessage(plugin.getMessage(BPNVLang.INVALID));
                break;
        }

        return true;
    }
}