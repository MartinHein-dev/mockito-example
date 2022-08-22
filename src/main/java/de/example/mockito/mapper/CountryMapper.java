package de.example.mockito.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import de.example.mockito.dto.CountryDto;
import de.example.mockito.restcountries.RestCountry;

@Component
public class CountryMapper {

	public CountryDto map(RestCountry restCountry) {
		CountryDto dto = new CountryDto();
		dto.setCommonName(restCountry.getName().getCommon());
		dto.setOfficialName(restCountry.getName().getOfficial());
		return dto;
	}
	
	public List<CountryDto> map(List<RestCountry> restCountryList) {
		List<CountryDto> dtoList = new ArrayList<>();
		for(RestCountry restCountry : restCountryList) {
			dtoList.add(map(restCountry));
		}
		return dtoList;
	}
}
