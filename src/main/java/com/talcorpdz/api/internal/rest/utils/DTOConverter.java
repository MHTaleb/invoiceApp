package com.talcorpdz.api.internal.rest.utils;

public interface DTOConverter<T, D> {

	D toDto(T saved);
	
}
