package de.example.mockito.restcountries;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "restcountriesclient", url = "https://restcountries.com/v3.1/alpha")
public interface RestCountriesClient {

	@GetMapping(consumes = {"application/json"})
	public List<RestCountry> findCountriesByCode(
			@RequestParam("codes") String codes
			);

}
