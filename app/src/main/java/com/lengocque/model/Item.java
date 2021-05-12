package com.lengocque.model;

public class Item {
    private String DateTime;
    private int EpochDateTime;
    private int WeatherIcon;

    private String IconPhrase;
    private Boolean HasPrecipitation,IsDaylight;
    private Temperature Temperature;
    private int PrecipitationProbability;
    private String MobileLink;
    private  String Link;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getEpochDateTime() {
        return EpochDateTime;
    }

    public void setEpochDateTime(int epochDateTime) {
        EpochDateTime = epochDateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public Boolean getHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(Boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public Boolean getDaylight() {
        return IsDaylight;
    }

    public void setDaylight(Boolean daylight) {
        IsDaylight = daylight;
    }

    public com.lengocque.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.lengocque.model.Temperature temperature) {
        Temperature = temperature;
    }

    public int getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        PrecipitationProbability = precipitationProbability;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
