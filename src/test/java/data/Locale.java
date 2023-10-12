package data;

public enum Locale {
    ENGLISH ("English"),
    RUSSIAN ("Russian"),
    DEUTSCH ("Deutsch");

    private final String language;
    Locale(String value) {
        this.language = value;
    }

    public String getLanguage() {
        return language;
    }
}
