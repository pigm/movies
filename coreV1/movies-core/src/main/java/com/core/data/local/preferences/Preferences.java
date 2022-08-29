package com.core.data.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public abstract class Preferences implements IPreferences {
    protected SharedPreferences sharedPref;
    protected SharedPreferences.Editor edit;

    public Preferences(Context context) {
        sharedPref = context.getSharedPreferences(getName(), Context.MODE_PRIVATE);
        edit = sharedPref.edit();
    }

    @Override
    public void clear() {
        edit.clear().commit();
    }

    public void remove(Enum key) {
        edit.remove(key.name());
        save();
    }

    /**
     * Save all the changes in the preference
     */
    @Override
    public void save() {
        edit.commit();
        edit.apply();
    }

    /**
     * Save a the value to the preference with that key
     *
     * @param key
     * @param value
     */
    @Override
    public void save(Enum key, int value) {
        edit.putInt(key.name(), value);
        save();
    }

    @Override
    public void save(Enum key, String value) {
        edit.putString(key.name(), value);
        save();
    }

    @Override
    public void save(Enum key, boolean value) {
        edit.putBoolean(key.name(), value);
        save();
    }

    @Override
    public void save(Enum key, long value) {
        edit.putLong(key.name(), value);
        save();
    }

    public void save(Enum key, Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        edit.putString(key.name(), json);
        save();
    }


    public String getEntity(Enum key) {
        return sharedPref.getString(key.name(), "");
    }

    /**
     * If you need to return a different default response then
     * override this method with yor implementation
     *
     * @param key
     * @return
     */
    @Override
    public int getInt(Enum key) {
        return getInt(key, -1);
    }

    protected int getInt(Enum key, int defaultValue) {
        return sharedPref.getInt(key.name(), defaultValue);
    }

    /**
     * If you need to return a different default response then
     * override this method with yor implementation
     *
     * @param key
     * @return
     */
    @Override
    public String getString(Enum key) {
        return getString(key, "");
    }


    /**
     * Returns the value of the key or the default value
     *
     * @param key
     * @return
     */
    protected String getString(Enum key, String defaultValue) {
        return sharedPref.getString(key.name(), defaultValue);
    }

    /**
     * If you need to return a different default response then
     * override this method with yor implementation
     *
     * @param key
     * @return
     */
    @Override
    public boolean getBool(Enum key) {
        return sharedPref.getBoolean(key.name(), false);
    }

    @Override
    public long getLong(Enum key) {
        return sharedPref.getLong(key.name(), 0);
    }


}
