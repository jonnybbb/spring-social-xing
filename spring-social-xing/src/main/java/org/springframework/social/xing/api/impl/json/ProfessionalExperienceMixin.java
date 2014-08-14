package org.springframework.social.xing.api.impl.json;

import java.util.List;

import org.springframework.social.xing.api.Award;
import org.springframework.social.xing.api.Company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ProfessionalExperienceMixin {

	@JsonProperty("companies")
	private List<Company> companies;
	/**
	 * deprecated by xing since "2014-05-08"
	 */
	@Deprecated
	@JsonProperty("non_primary_companies")
	private List<Company> nonPrimaryCompanies;
	@JsonProperty("awards")
	private List<Award> awards;
	@JsonProperty("primary_company")
	private Company primaryCompany;

}
