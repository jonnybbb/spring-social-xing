package org.springframework.social.xing.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class XingDate implements Serializable {

	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM";
	private static final String FALLBACK_DATE_FORMAT = "yyyy";

	private static final Log logger = LogFactory.getLog(XingDate.class);

	private static final long serialVersionUID = 6747607636067970948L;
	private Integer year;
	private Integer month;

	public XingDate(String dateString) {

		if (dateString != null && !dateString.trim().isEmpty()) {
            dateString = dateString.trim();
            if (DEFAULT_DATE_FORMAT.length() == dateString.length()) {
                try {
                    SimpleDateFormat format = new SimpleDateFormat(
                            DEFAULT_DATE_FORMAT);
                    Calendar cal = Calendar.getInstance();
                    Date date = format.parse(dateString);
                    cal.setTime(date);
                    month = cal.get(Calendar.MONTH) + 1; // MONTH is zero based
                    year = cal.get(Calendar.YEAR);
                } catch (ParseException e) {
                    logger.fatal("failed to parse date string " + dateString, e);
                }
            } else if (FALLBACK_DATE_FORMAT.length() == dateString.length()) {
                try {
                    SimpleDateFormat fallbackFormat = new SimpleDateFormat(
                            FALLBACK_DATE_FORMAT);
                    Calendar cal = Calendar.getInstance();
                    Date date = fallbackFormat.parse(dateString);
                    cal.setTime(date);
                    year = cal.get(Calendar.YEAR);
                } catch (ParseException e) {
                    logger.fatal("failed to parse date string " + dateString, e);
                }
            } else {
                logger.fatal("unknown date format: " + dateString);
            }

        }
    }

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}
}
