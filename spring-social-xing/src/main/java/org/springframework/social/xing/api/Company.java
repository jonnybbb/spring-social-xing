package org.springframework.social.xing.api;

import java.io.Serializable;

public class Company implements Serializable {

	private static final long serialVersionUID = 8680835034881540914L;
	private String id;
	private String industry;
	private String companySize;
	private XingDate endDate;
	private String tag;
	private String name;
	private String url;
	private CareerLevel careerLevel;
	private String title;
	private XingDate beginDate;
	private String description;
    private FormOfEmployment formOfEmployment;
    private Boolean untilNow;

	public String getId() {
		return id;
	}

	public String getIndustry() {
		return industry;
	}

	public String getCompanySize() {
		return companySize;
	}

	public XingDate getEndDate() {
		return endDate;
	}

	public String getTag() {
		return tag;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public CareerLevel getCareerLevel() {
		return careerLevel;
	}

	public String getTitle() {
		return title;
	}

	public XingDate getBeginDate() {
		return beginDate;
	}

	public String getDescription() {
		return description;
	}

    public FormOfEmployment getFormOfEmployment() {
        return formOfEmployment;
    }
    
    public Boolean getUntilNow() {
		return untilNow;
	}
}
