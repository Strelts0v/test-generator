package com.itransition.app.main;

import com.itransition.app.parser.Parser;
import com.itransition.app.resourses.DataManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Region region = parser.parseRegion(args[0]);
        int notesCount = parser.parseIntegerNumber(args[1]);
        double errorCount = parser.parseDoubleNumber(args[2]);
        /*Region region = parser.parseRegion("USA");
        int notesCount = parser.parseIntegerNumber("100");
        double errorCount = parser.parseDoubleNumber("0.5");*/
        DataManager dataManager = new DataManager();
        List<String> records = dataManager.getTestRecords(region, notesCount, errorCount);
        for(String str: records){
            System.out.println(str);
        }

    }
}
