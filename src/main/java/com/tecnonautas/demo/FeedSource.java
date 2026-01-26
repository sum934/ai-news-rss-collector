package com.tecnonautas.demo;

public class FeedSource {
    private final String url;
    private final String fonte;

    public FeedSource(String url, String fonte) {
        this.url = url;
        this.fonte = fonte;
    }

    public String getUrl() {
        return url;
    }

    public String getFonte() {
        return fonte;
    }

}
