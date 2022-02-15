package com.talcorpdz.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talcorpdz.api.internal.rest.GenericRestController;
import com.talcorpdz.domain.Tva;
import com.talcorpdz.domain.dto.DTOTva;

@RestController
@RequestMapping("/api/tva")
public class TVAController extends GenericRestController<Tva,DTOTva>{

}
