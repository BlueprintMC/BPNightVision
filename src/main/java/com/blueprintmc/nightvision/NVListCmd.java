package com.blueprintmc.nightvision;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

public class NVListCmd implements CommandExecutor
{
	private BPNightVision plugin;

	public NVListCmd(BPNightVision plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		/* Permission */
		if (!sender.hasPermission("bpnightvision.list"))
		{
			sender.sendMessage(plugin.getMessage(BPNVLang.NO_PERMISSION));
			return true;
		}

		/* List is empty */
		if (plugin.players.size() == 0)
		{
			sender.sendMessage(plugin.getMessage(BPNVLang.LIST_EMPTY));
		}
		else
		{
			sender.sendMessage(plugin.getMessage(BPNVLang.LIST));
			String list = "";
			Iterator<String> it = plugin.players.keySet().iterator();
			do
			{
				list = list.concat(it.next());
				if (it.hasNext())
				{
					/* Append comma and space */
					list = list.concat(", ");
				}
			}
			while (it.hasNext());
			sender.sendMessage(list);
		}

		return true;
	}
}