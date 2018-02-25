package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.PersediaanDTO;
import com.ledger.common.dto.finance.management.PersediaanDTOBuilder;
import com.ledger.domain.financial.management.Persediaan;
import com.ledger.domain.financial.management.PersediaanBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class PersediaanDTOAssembler implements IObjectAssembler<Persediaan, PersediaanDTO> {

    @Override
    public PersediaanDTO toDTO(Persediaan domainObject) {
        return new PersediaanDTOBuilder()
                .setUserID(domainObject.getUserID())
                .setPersediaanID(domainObject.getPersediaanID())
                .setNamaPersediaan(domainObject.getNamaPersediaan())
                .setJumlahPersediaan(domainObject.getJumlahPersediaan())
                .setJenisPersediaan(domainObject.getJenisPersediaan())
                .setHargaPersediaan(domainObject.getHargaPersediaan())
                .setTotalHargaPersediaan(domainObject.getTotalHargaPersediaan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPersediaanDTO();
    }

    @Override
    public Persediaan toDomain(PersediaanDTO dtoObject) {
        return new PersediaanBuilder()
                .setUserID(dtoObject.getUserID())
                .setPersediaanID(dtoObject.getPersediaanID())
                .setNamaPersediaan(dtoObject.getNamaPersediaan())
                .setJumlahPersediaan(dtoObject.getJumlahPersediaan())
                .setJenisPersediaan(dtoObject.getJenisPersediaan())
                .setHargaPersediaan(dtoObject.getHargaPersediaan())
                .setTotalHargaPersediaan(dtoObject.getTotalHargaPersediaan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPersediaan();
    }

    public List<Persediaan> toDomains(List<PersediaanDTO> arg0) {
        List<Persediaan> res = new ArrayList<>();
        for (PersediaanDTO t : arg0) {
            res.add(new PersediaanDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PersediaanDTO> toDTOs(List<Persediaan> arg0) {
        List<PersediaanDTO> res = new ArrayList<>();
        for (Persediaan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
