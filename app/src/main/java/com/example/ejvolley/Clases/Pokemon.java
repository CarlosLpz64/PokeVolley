package com.example.ejvolley.Clases;

public class Pokemon {
    String name;
    String url;
    String pokenumero;
    String[] pokepartes;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNumero(){
        pokepartes = url.split("/");
        pokenumero = pokepartes[pokepartes.length-1];
        return pokenumero;
    }
}
