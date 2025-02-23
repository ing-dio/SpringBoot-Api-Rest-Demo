package com.example.demo.Configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ExternalizedConfigurations {
    private String name;
    private String version;
    private String language;
    private String country;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "ExternalizedConfigurations: " + "\n" +
               "name: " + getName() + "\n" +
               "version: " + getVersion() + "\n" +
               "language: " + getLanguage() + "\n" +
               "country: " + getCountry();
    }
}
