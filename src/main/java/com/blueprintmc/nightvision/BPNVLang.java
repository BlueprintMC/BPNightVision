package com.blueprintmc.nightvision;

public enum BPNVLang
{
    DEFAULT("bpnightvision.default", "&9Blueprint &6NightVision &fby jstnf\nUse &b/nv help&f for a list of commands."),
    HELP("bpnightvision.help", "&9Blueprint &6NightVision &fCommand Help\n&b/nv on&f - Toggle night vision on.\n&b/nv off&f - Toggle night vision off.\n&b/nv list&f - List all players with night vision on."),
    ON("bpnightvision.on", "&fNight vision has been toggled &a&lON&f."),
    OFF("bpnightvision.off", "&fNight vision has been toggled &c&lOFF&f."),
    LIST("bpnightvision.list", "&fThe following players have night vision on:"),
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