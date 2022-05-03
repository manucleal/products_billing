/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ecoitino
 */
public class DateUtils {
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }
}
