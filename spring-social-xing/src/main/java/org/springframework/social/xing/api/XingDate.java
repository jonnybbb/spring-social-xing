package org.springframework.social.xing.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class XingDate implements Serializable {

    private static final Log logger = LogFactory.getLog(XingDate.class);

    private static final long serialVersionUID = 6747607636067970948L;
    private Integer year;
    private Integer month;


    public XingDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            Calendar cal = Calendar.getInstance();
            Date date = format.parse(dateString);
            cal.setTime(date);
            month = cal.get(Calendar.MONTH) + 1; // MONTH is zero based
            year = cal.get(Calendar.YEAR);
        } catch (ParseException e) {
            logger.fatal("failed to parse date string " + dateString, e);
        }
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }
}
