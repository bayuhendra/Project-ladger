package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.ActivaTetapDTO;
import com.ledger.common.dto.finance.management.ActivaTetapDTOBuilder;
import com.ledger.domain.financial.management.ActivaTetap;
import com.ledger.domain.financial.management.ActivaTetapBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class ActivaTetapDTOAssembler implements IObjectAssembler<ActivaTetap, ActivaTetapDTO> {

    @Override
    public ActivaTetapDTO toDTO(ActivaTetap domainObject) {
        return new ActivaTetapDTOBuilder()
                .setUserID(domainObject.getUserID())
                .setActivaTetapID(domainObject.getActivaTetapID())
                .setJenisActiva(domainObject.getJenisActiva())
                .setNamaActivaTetap(domainObject.getNamaActivaTetap())
                .setHargaActivaTetap(domainObject.getHargaActivaTetap())
                .setLamaPemakaian(domainObject.getLamaPemakaian())
                .setJangkaWaktuPenyusutan(domainObject.getJangkaWaktuPenyusutan())
                .setPersenPenyusutan(domainObject.getPersenPenyusutan())
                .setTotalPenyusutan(domainObject.getTotalPenyusutan())
                .setStatus(domainObject.getStatus())
                .setAlamat(domainObject.getAlamat())
                .setSertifikat(domainObject.getSertifikat())
                .setNoSertifikat(domainObject.getNoSertifikat())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createActivaTetapDTO();
    }

    @Override
    public ActivaTetap toDomain(ActivaTetapDTO dtoObject) {
        return new ActivaTetapBuilder()
                .setUserID(dtoObject.getUserID())
                .setActivaTetapID(dtoObject.getActivaTetapID())
                .setJenisActiva(dtoObject.getJenisActiva())
                .setNamaActivaTetap(dtoObject.getNamaActivaTetap())
                .setHargaActivaTetap(dtoObject.getHargaActivaTetap())
                .setLamaPemakaian(dtoObject.getLamaPemakaian())
                .setJangkaWaktuPenyusutan(dtoObject.getJangkaWaktuPenyusutan())
                .setPersenPenyusutan(dtoObject.getPersenPenyusutan())
                .setTotalPenyusutan(dtoObject.getTotalPenyusutan())
                .setStatus(dtoObject.getStatus())
                .setAlamat(dtoObject.getAlamat())
                .setSertifikat(dtoObject.getSertifikat())
                .setNoSertifikat(dtoObject.getNoSertifikat())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createActivaTetap();
    }

    public List<ActivaTetap> toDomains(List<ActivaTetapDTO> arg0) {
        List<ActivaTetap> res = new ArrayList<>();
        for (ActivaTetapDTO t : arg0) {
            res.add(new ActivaTetapDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<ActivaTetapDTO> toDTOs(List<ActivaTetap> arg0) {
        List<ActivaTetapDTO> res = new ArrayList<>();
        for (ActivaTetap t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
