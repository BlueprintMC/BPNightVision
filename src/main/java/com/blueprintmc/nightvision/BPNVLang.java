package com.blueprintmc.nightvision;

public enum BPNVLang
{
	PREFIX("bpnightvision.prefix", "&7[&9BP&6NightVision&7] &f"),
	MUST_BE_PLAYER("bpnightvision.must-be-player", "&cYou must be a Player to use this command."),
	NO_PERMISSION("bpnightvision.no-permission", "&cYou do not have permission to use night vision."),
	VERSION("bpnightvision.default",
			"&9Blueprint &6NightVision &fv" + BPNightVision.VERSION + "\n&fWritten by &ojstnf &f/ &opokeball92870"
					+ "\nUse &b/nv help &ffor a list of commands."),
	HELP("bpnightvision.help",
			"&9Blueprint &6NightVision &fCommand Help"
					+ "\n&b/nv&f - Toggle night vision on and off."
					+ "\n&b/nv on&f - Toggle night vision on."
					+ "\n&b/nv off&f - Toggle night vision off."
					+ "\n&b/nvlist&f - List all players with night vision on."
					+ "\n&b/nv version&f - View information about BPNightVision."),
	ON("bpnightvision.on", "&bNight vision has been toggled &a&lON&b."),
	OFF("bpnightvision.off", "&bNight vision has been toggled &c&lOFF&b."),
	NO_NIGHT_VISION("bpnightvision.no-night-vision", "&cYou do not have night vision!"),
	HAS_NIGHT_VISION("bpnightvision.has-night-vision", "&cYou already have night vision!"),
	LIST("bpnightvision.list", "&fThe following players have night vision:"),
	LIST_EMPTY("bpnightvision.list-empty", "&fThere are no players that currently have night vision."),
	INVALID("bpnightvision.invalid", "&cInvalid subcommand! &fUse &b/nv help&f for help.");

	private String path, value;

	BPNVLang(String path, String value)
	{
		this.path = path;
		this.value = value;
	}

	/**
	 * Get the String message for the enum.
	 * @return value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Get the String path for the enum.
	 * (for future use in possible lang file)
	 * @return path
	 */
	public String getPath()
	{
		return path;
	}
}