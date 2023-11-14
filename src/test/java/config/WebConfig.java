package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("99.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://store.steampowered.com/")
    String getBaseUrl();

    @Key("remoteUrl")
    @DefaultValue("")
    String getRemoteUrl();

    @Key("selenoidAuth")
    @DefaultValue("")
    String getRemoteAuth();
}
