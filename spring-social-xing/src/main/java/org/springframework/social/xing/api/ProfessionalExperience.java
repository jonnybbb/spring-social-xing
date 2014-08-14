package org.springframework.social.xing.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by json2pojo
 */
public class ProfessionalExperience implements Serializable {

	private static final long serialVersionUID = -2093383150432795268L;
	@Deprecated
	private List<Company> nonPrimaryCompanies;
	private List<Company> companies;
	private Company primaryCompany;
	private List<Award> awards;

	/**
	 * deprecated by xing since "2014-05-08"
	 */
	@Deprecated
	public List<Company> getNonPrimaryCompanies() {
		return nonPrimaryCompanies;
	}
	
	public List<Company> getCompanies() {
		return companies;
	}

	public Company getPrimaryCompany() {
		return primaryCompany;
	}

	public List<Award> getAwards() {
		return awards;
	}

}
