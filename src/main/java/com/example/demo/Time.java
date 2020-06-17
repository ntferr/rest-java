package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Arrays;
import java.util.List;

public class Time {    
    private int horas;    
    Calendar cal = Calendar.getInstance();
    
    public Time(int horas, int minutos, int segundos) {
        SimpleDateFormat sdf_horas = new SimpleDateFormat("HH");
        String str_horas;

        cal.set(Calendar.HOUR_OF_DAY, horas);
        cal.set(Calendar.MINUTE, minutos);
        cal.set(Calendar.SECOND, segundos);

        str_horas = sdf_horas.format(cal.getTime());
        horas = Integer.parseInt(str_horas);
        horas *= 3600;

    }

    public List<String> acessTime() {
        
        // 00:00 - 05:00
        if (horas < 18000) {
            return Arrays.asList("type=music", "&type=relaxation", "&type=recreational");
        }//05:00 - 08:00
        else if (horas < 28800) {
            return Arrays.asList("type=education");
        }//08:00 - 12:00
        else if (horas < 43200) {
            return Arrays.asList("type=busywork");
        }//12:00 - 14:00
        else if (horas < 50400) {
            return Arrays.asList("type=relaxation", "&type=education", "&type=social", "&type=recreation");
        }//14:00 - 18:00
        else if (horas < 64800) {
            return Arrays.asList("type=busywork");
        //18:00 - 23:59
        } else {
            return Arrays.asList("type=music", "&type=relaxation", "&type=recreation", "&type=social", "&type=education");
        }
    }
}