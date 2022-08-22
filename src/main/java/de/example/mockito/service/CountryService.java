package de.example.mockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.example.mockito.dto.CountryDto;
import de.example.mockito.mapper.CountryMapper;
import de.example.mockito.restcountries.RestCountriesClient;
import de.example.mockito.restcountries.RestCountry;

@Service
public class CountryService {
	
	@Autowired
	RestCountriesClient restCountiesClient;
	
	@Autowired
	CountryMapper countryMapper;

	public List<CountryDto> getAllCountries(String countryCodes) {
		List<RestCountry> restCountryList = this.restCountiesClient.findCountriesByCode(countryCodes);
		
		List<CountryDto> dtoList = this.countryMapper.map(restCountryList);
		return dtoList;
	}
	
}
