package org.springframework.social.xing.api;

import java.io.Serializable;

/**
 * Created by json2pojo
 */
public class Award implements Serializable {

	private static final long serialVersionUID = -2650314056830306979L;
	private String name;
	private Long dateAwarded;
	private String url;

	public String getName() {
		return name;
	}

	public Long getDateAwarded() {
		return dateAwarded;
	}

	public Object getUrl() {
		return url;
	}

}
