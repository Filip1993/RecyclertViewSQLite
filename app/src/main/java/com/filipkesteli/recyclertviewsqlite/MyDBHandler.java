package com.filipkesteli.recyclertviewsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fkesteli on 23.6.2016..
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "osobaDB.db";
    private static final String TABLE_OSOBE = "osobe";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IME = "ime";
    public static final String COLUMN_PREZIME = "prezime";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE =
                "CREATE TABLE " + TABLE_OSOBE
                        + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY, "
                        + COLUMN_IME + " TEXT, "
                        + COLUMN_PREZIME + " TEXT"
                        + ");";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OSOBE);
        onCreate(db);
    }

    /**
     * Dodaj produkt metoda -> Dodaje se vrijednost unutar baze podataka
     */
    public void addOsoba(Osoba osoba) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_IME, osoba.get_ime());
        contentValues.put(COLUMN_PREZIME, osoba.get_prezime());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(TABLE_OSOBE, null, contentValues);
        sqLiteDatabase.close();
    }

    /**
     * Vrsta QUERY-ja -> Pronađi produkt -> Jedan od SELECT statementa -> Trazenje preko imena osobe
     */
    public Osoba findOsoba(String ime) {
        String query = "SELECT * FROM " + TABLE_OSOBE
                + " WHERE " + COLUMN_IME + " = " + ime;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        Osoba osoba = new Osoba(); //Instanciramo novi objekt osoba i za to koristimo defaultni konstruktor
        if (cursor.moveToFirst() == true) {
            cursor.moveToFirst();
            osoba.set_id(Integer.parseInt(cursor.getString(0)));
            osoba.set_ime(cursor.getString(1));
            osoba.set_prezime(cursor.getString(1));
            cursor.close();
        } else {
            osoba = null;
        }
        sqLiteDatabase.close();
        return osoba;
    }

    /**
     * Vrsta QUERY-ja -> Izbrisi product
     */
    public boolean deleteOsoba(String ime) {
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_OSOBE
                + " WHERE " + COLUMN_IME + " = " + ime;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        Osoba osoba = new Osoba();
        if (cursor.moveToFirst()) {
            osoba.set_id(Integer.parseInt(cursor.getString(0)));
            sqLiteDatabase.delete(TABLE_OSOBE, COLUMN_ID + " = ?", new String[]{String.valueOf(osoba.get_id())});
            cursor.close();
            result = true;
        }
        sqLiteDatabase.close();
        return result;
    }
}
