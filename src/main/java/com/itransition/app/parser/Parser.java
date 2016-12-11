package com.itransition.app.parser;

import com.itransition.app.main.Region;

public class Parser {
    public Region parseRegion(String regionAbbreviation){
        Region region;
        if(regionAbbreviation.equalsIgnoreCase("BY")){
            region = Region.BY;
        }else if(regionAbbreviation.equalsIgnoreCase("RUS")){
            region = Region.RUS;
        }else if(regionAbbreviation.equalsIgnoreCase("USA")) {
            region = Region.USA;
        }else throw new IllegalArgumentException("Error! Incorrect value of region...");
        return region;
    }

    public int parseIntegerNumber(String number){
        return Integer.parseInt(number);
    }

    public double parseDoubleNumber(String number){
        return  Double.parseDouble(number);
    }
}
