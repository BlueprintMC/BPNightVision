package com.blueprintmc.nightvision;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NVCmd implements CommandExecutor
{
	private BPNightVision plugin;

	public NVCmd(BPNightVision plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		/* Only players can use this command */
		if (!(sender instanceof Player))
		{
			sender.sendMessage(plugin.getMessage(BPNVLang.MUST_BE_PLAYER));
			return true;
		}

		/* Permission */
		if (!sender.hasPermission("bpnightvision.nv"))
		{
			sender.sendMessage(plugin.getMessage(BPNVLang.NO_PERMISSION));
			return true;
		}

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
						Player p = (Player) sender;
						plugin.players.put(p.getName(), p);
						p.addPotionEffect(
								new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false,
										false));
						sender.sendMessage(plugin.getMessage(BPNVLang.ON));
						break;
					case "off":
						String username = ((Player) sender).getName();
						Player p2 = plugin.players.get(username);
						if (p2 == null)
						{
							/* Player does not have night vision! */
							sender.sendMessage(plugin.getMessage(BPNVLang.NO_NIGHT_VISION));
						}
						else
						{
							p2.removePotionEffect(PotionEffectType.NIGHT_VISION);
							plugin.players.remove(username);
							sender.sendMessage(plugin.getMessage(BPNVLang.OFF));
						}
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