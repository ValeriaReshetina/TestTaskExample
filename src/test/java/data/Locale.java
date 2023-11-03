package data;

public enum Locale {
    ENGLISH ("English"),
    CZECH ("Čeština"),
    DEUTSCH ("Deutsch");

    private final String language;
    Locale(String value) {
        this.language = value;
    }

    public String getLanguage() {
        return language;
    }
}
