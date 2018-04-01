package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.SaldoKasDTO;
import com.ledger.common.dto.finance.management.SaldoKasDTOBuilder;
import com.ledger.domain.financial.management.SaldoKas;
import com.ledger.domain.financial.management.SaldoKasBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class SaldoKasDTOAssembler implements IObjectAssembler<SaldoKas, SaldoKasDTO> {

    @Override
    public SaldoKasDTO toDTO(SaldoKas domainObject) {
        return new SaldoKasDTOBuilder()
                .setUserID(domainObject.getUserID())
                .setSaldoKasID(domainObject.getSaldoKasID())
                .setSaldoKas(domainObject.getSaldoKas())
                .setSaldoBank(domainObject.getSaldoBank())
                .setSaldoLabaRugi(domainObject.getSaldoLabaRugi())
                .setModalDisetor(domainObject.getModalDisetor())
                .setSaldoKasBank(domainObject.getSaldoKasBank())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createSaldoKasDTO();
    }

    @Override
    public SaldoKas toDomain(SaldoKasDTO dtoObject) {
        return new SaldoKasBuilder()
                .setUserID(dtoObject.getUserID())
                .setSaldoKasID(dtoObject.getSaldoKasID())
                .setSaldoKas(dtoObject.getSaldoKas())
                .setSaldoBank(dtoObject.getSaldoBank())
                .setSaldoLabaRugi(dtoObject.getSaldoLabaRugi())
                .setModalDisetor(dtoObject.getModalDisetor())
                .setSaldoKasBank(dtoObject.getSaldoKasBank())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createSaldoKas();
    }

    public List<SaldoKas> toDomains(List<SaldoKasDTO> arg0) {
        List<SaldoKas> res = new ArrayList<>();
        for (SaldoKasDTO t : arg0) {
            res.add(new SaldoKasDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<SaldoKasDTO> toDTOs(List<SaldoKas> arg0) {
        List<SaldoKasDTO> res = new ArrayList<>();
        for (SaldoKas t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
