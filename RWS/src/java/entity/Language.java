/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Language {
    private String language;
    private String spoken;
    private String written;

    public Language(String language, String spoken, String written) {
        this.language = language;
        this.spoken = spoken;
        this.written = written;
    }

    public String getLanguage() {
        return language;
    }

    public String getSpoken() {
        return spoken;
    }

    public String getWritten() {
        return written;
    }     
}