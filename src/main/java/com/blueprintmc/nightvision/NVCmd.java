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
                sender.sendMessage("bpnightvision.default");
                break;
            case 1:
                switch (args[0].toLowerCase())
                {
                    case "help":
                        sender.sendMessage("bpnightvision.help");
                        break;
                    case "on":
                        sender.sendMessage("bpnightvision.on");
                        break;
                    case "off":
                        sender.sendMessage("bpnightvision.off");
                        break;
                    case "list":
                        sender.sendMessage("bpnightvision.list");
                        break;
                    default:
                        sender.sendMessage("bpnightvision.invalid");
                        break;
                }
                break;
            default:
                sender.sendMessage("bpnightvision.invalid");
                break;
        }

        return true;
    }
}