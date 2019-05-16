package com.blueprintmc.nightvision;

public enum BPNVLang
{
	MUST_BE_PLAYER("bpnightvision.must-be-player", "&cYou must be a Player to use this command."),
	NO_PERMISSION("bpnightvision.no-permission", "&cYou do not have permission to use this command."),
	DEFAULT("bpnightvision.default", "&9Blueprint &6NightVision &fby jstnf v" + BPNightVision.VERSION + "\nUse &b/nv help&f for a list of commands."),
	HELP("bpnightvision.help",
			"&9Blueprint &6NightVision &fCommand Help\n&b/nv on&f - Toggle night vision on.\n&b/nv off&f - Toggle night vision off.\n&b/nvlist&f - List all players with night vision on."),
	ON("bpnightvision.on", "&fNight vision has been toggled &a&lON&f."),
	OFF("bpnightvision.off", "&fNight vision has been toggled &c&lOFF&f."),
	NO_NIGHT_VISION("bpnightvision.no-night-vision", "&cYou do not have night vision on!"),
	LIST("bpnightvision.list", "&fThe following players have night vision:"),
	LIST_EMPTY("bpnightvision.list-empty", "&fNo players currently have night vision."),
	INVALID("bpnightvision.invalid", "&cInvalid subcommand. &fUse &b/nv help&f for help.");

	private String path, value;

	BPNVLang(String path, String value)
	{
		this.path = path;
		this.value = value;
	}

	String getValue()
	{
		return value;
	}

	String getPath()
	{
		return path;
	}
}