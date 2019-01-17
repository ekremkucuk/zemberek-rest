package com.ekremkucuk.zemberekrest.model;

import java.util.List;

public class AnalyzeTurkishResponse {

    private String formatted;
    private List<String> stems;
    private List<String> lemmas;

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public List<String> getStems() {
        return stems;
    }

    public void setStems(List<String> stems) {
        this.stems = stems;
    }

    public List<String> getLemmas() {
        return lemmas;
    }

    public void setLemmas(List<String> lemmas) {
        this.lemmas = lemmas;
    }
}
