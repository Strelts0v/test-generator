package com.itransition.app.resourses.database;

import com.itransition.app.main.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlProcedures {

    private final static String COLUMN_NAME= "name";
    private final static String COLUMN_CITY= "city";
    private final static String COLUMN_INDEX= "index_city";
    private final static String COLUMN_ADDRESS= "address";
    private final static String COLUMN_PHONE= "phone";

    public static List<StringBuilder> getNames(Region region, int count){
        String query = "SELECT " + COLUMN_NAME + " FROM names_" + toTableFormat(region)
                + " ORDER BY " + COLUMN_NAME + " LIMIT " + count;
        ResultSet data = DatabaseDriver.getInstance().getRecords(query);
        List<StringBuilder> names = new ArrayList<StringBuilder>(count);
        try {
            while (data.next()) {
                names.add(new StringBuilder(data.getString(COLUMN_NAME)).append("; "));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return names;
    }

    public static List<StringBuilder> getCities(Region region, int count){
        String query = "SELECT " + COLUMN_CITY + ", " + COLUMN_INDEX + " FROM cities_" + toTableFormat(region) +
                " ORDER BY " + COLUMN_CITY + ", " + COLUMN_INDEX + " LIMIT " + count;
        ResultSet data = DatabaseDriver.getInstance().getRecords(query);
        List<StringBuilder> names = new ArrayList<StringBuilder>(count);
        try {
            while (data.next()) {
                names.add(new StringBuilder(data.getString(COLUMN_INDEX)
                        + "; " + data.getString(COLUMN_CITY) + ", "));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return names;
    }

    public static List<StringBuilder> getAddresses(Region region, int count){
        String query = "SELECT " + COLUMN_ADDRESS + " FROM addresses_" + toTableFormat(region)
                + " ORDER BY " + COLUMN_ADDRESS + " LIMIT " + count;
        ResultSet data = DatabaseDriver.getInstance().getRecords(query);
        List<StringBuilder> names = new ArrayList<StringBuilder>(count);
        try {
            while (data.next()) {
                names.add(new StringBuilder(data.getString(COLUMN_ADDRESS)).append("; "));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return names;
    }

    public static List<StringBuilder> getPhones(Region region, int count){
        String query = "SELECT " + COLUMN_PHONE + " FROM phones_" + toTableFormat(region)
                + " ORDER BY " + COLUMN_PHONE + " LIMIT " + count;
        ResultSet data = DatabaseDriver.getInstance().getRecords(query);
        List<StringBuilder> names = new ArrayList<StringBuilder>(count);
        try {
            while (data.next()) {
                names.add(new StringBuilder(data.getString(COLUMN_PHONE)).append(";"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return names;
    }

    private static String toTableFormat(Region region){
        return region.toString().toLowerCase();
    }
}
