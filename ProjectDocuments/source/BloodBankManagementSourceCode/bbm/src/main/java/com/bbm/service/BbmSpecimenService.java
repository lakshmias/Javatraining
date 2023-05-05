package com.bbm.service;

import com.bbm.entity.Specimen;

public interface BbmSpecimenService {
	public Specimen addSpecimen(Specimen bbmSpecimen);
	public Specimen findSpecimentByOID(Long OID);
}
