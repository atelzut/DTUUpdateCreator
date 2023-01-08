package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Utils {
    public static Date getDatefromTimestampString(String datainizioattivita) {


        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm:ss,SSSSSSSSS");
            Date parsedDate = dateFormat.parse(datainizioattivita);
            return new Date((new java.sql.Timestamp(parsedDate.getTime())).getTime());
        } catch (Exception e) { //this generic but you can control another types of exception
            throw new RuntimeException(e);
        }
       // return null;
    }

    public static java.util.Date getDateFromString(String datafineattivita) {
        try {
            if (datafineattivita != "null") {
                return new SimpleDateFormat("dd-MMM-yyyy").parse(datafineattivita);
            } else
                return null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static void UpdateCreator(List<DbElement> list, BufferedWriter writer) throws IOException {
        String a = "update dtutalloggioprivato_aud_backup set attivodal = '%s' where idObj=%s and rev=%s;\n";
        Collections.sort(list);

        Date dia = list.get(0).getDataInizioAttivita();
        boolean change = false;
        for (DbElement d : list) {
            if (change) {
                dia = d.getDataInizioAttivita();
                change = false;
            }
            String str= String.format(a, dateFormatter(dia), d.getIdObj(), d.getRev());
            writer.write(str);
            System.out.println(str);
            if (d.getDatafineAttivita() != null) {
                change = true;
            }

        }
    }

    private static Object dateFormatter(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        return formatter.format(date);
    }

}
