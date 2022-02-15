package com.talcorpdz.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talcorpdz.api.internal.rest.GenericRestController;
import com.talcorpdz.domain.MProduct;
import com.talcorpdz.domain.Tva;

@RestController
@RequestMapping("/api/product")
public class MProductController extends GenericRestController<Tva,Tva>{

}
