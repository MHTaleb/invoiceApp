package com.talcorpdz.spec.config.domain.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.talcorpdz.api.internal.rest.utils.DTOConverter;
import com.talcorpdz.domain.Tva;
import com.talcorpdz.domain.dto.DTOTva;

@Configuration
public class ConverterConfiguration {

	@Bean
	@Primary
	public DTOConverter defaultGenericConverter() {
		return e -> e ;
	}
	
	
	@Bean
	@Scope("prototype")
	public DTOConverter<Tva, Tva> defaultConverterTVA(){
		return tva -> tva;
	}
	
	@Bean
	@Scope("prototype")
	public DTOConverter<Tva, DTOTva> tvaConverterDtoTVA(){
		return tva -> new DTOTva(tva.getValue(),tva.getName(),tva.getRate());
	}
}
