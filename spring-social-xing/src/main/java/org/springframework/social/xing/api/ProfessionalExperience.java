package org.springframework.social.xing.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by json2pojo
 */
public class ProfessionalExperience implements Serializable {

	private static final long serialVersionUID = -2093383150432795268L;
	private List<Company> nonPrimaryCompanies;
	private Company primaryCompany;
	private List<Award> awards;

	public List<Company> getNonPrimaryCompanies() {
		return nonPrimaryCompanies;
	}

	public Company getPrimaryCompany() {
		return primaryCompany;
	}

	public List<Award> getAwards() {
		return awards;
	}

}
