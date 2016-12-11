package com.itransition.app.resourses;

import com.itransition.app.error.ErrorCreator;
import com.itransition.app.main.Region;
import com.itransition.app.resourses.database.SqlProcedures;
import java.util.*;

public class DataManager {

    private final int MAX_INDEX = 20;

    public List<String> getTestRecords(Region region, int notesCount, double errorCount){
        List<String> notes = new ArrayList<String>(notesCount);
        List<StringBuilder> names = SqlProcedures.getNames(region, MAX_INDEX);
        List<StringBuilder> cities = SqlProcedures.getCities(region, MAX_INDEX);
        List<StringBuilder> addresses = SqlProcedures.getAddresses(region, MAX_INDEX);
        List<StringBuilder> phones = SqlProcedures.getPhones(region, MAX_INDEX);
        Random random = new Random();
        ErrorCreator errorCreator = new ErrorCreator();
        for(int i = 0; i < notesCount; i++){
            int index = random.nextInt(MAX_INDEX);
            StringBuilder note = new StringBuilder().append(names.get(index)).append(cities.get(index))
                    .append(addresses.get(index)).append(phones.get(index));
            notes.add(errorCreator.addError(note, errorCount).toString());
        }

        return notes;
    }
}
