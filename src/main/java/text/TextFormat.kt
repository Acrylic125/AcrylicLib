package com.acrylic.text

/**
 * TextFormat are common colour and fonts that can
 * be used to modify text.
 */
enum class TextFormat(s: String) {

    //Colors
    DARK_RED("38;5;124m"),
    RED("38;5;196m"),
    ORANGE("38;5;202m"),
    GOLD("38;5;172m"),
    YELLOW("38;5;184m"),
    LIME("38;5;49m"),
    LIGHT_GREEN("38;5;46m"),
    LIGHT_BLUE("38;5;38m"),
    AQUA("38;5;24m"),
    BLUE("38;5;21m"),
    MAGENTA("38;5;165m"),
    PURPLE("38;5;91m"),
    WHITE("38;5;255m"),
    LIGHT_GRAY("38;5;243m"),
    GRAY("38;5;239m"),
    DARK_GRAY("38;5;236m"),
    BLACK("38;5;233m"),

    //Fonts
    RESET("0m"),
    BOLD("1m"),
    UNDERLINE("4m"),
    REVERSED("7m"),
    STRIKETHROUGH("9m"),
    ITALIC("3m"),

    ;

    private val format : String = "\u001B[$s"

    /** Converts to ASCII format **/
    fun getFormat() : String {
        return format
    }



}