package com.filipkesteli.recyclertviewsqlite;

/**
 * Created by fkesteli on 23.6.2016..
 */
public class Osoba {

    private int _id;
    private String _ime;
    private String _prezime;

    public Osoba(int _id, String _ime, String _prezime) {
        this._id = _id;
        this._ime = _ime;
        this._prezime = _prezime;
    }

    public Osoba(String _ime, String _prezime) {

        this._ime = _ime;
        this._prezime = _prezime;
    }

    public Osoba() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_ime() {
        return _ime;
    }

    public void set_ime(String _ime) {
        this._ime = _ime;
    }

    public String get_prezime() {
        return _prezime;
    }

    public void set_prezime(String _prezime) {
        this._prezime = _prezime;
    }
}
