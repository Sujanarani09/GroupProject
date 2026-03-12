import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetAllBrandList {

	@JsonProperty("brands")
	private List<BrandsItem> brands;

	@JsonProperty("responseCode")
	private int responseCode;

	public List<BrandsItem> getBrands(){
		return brands;
	}

	public int getResponseCode(){
		return responseCode;
	}
}
