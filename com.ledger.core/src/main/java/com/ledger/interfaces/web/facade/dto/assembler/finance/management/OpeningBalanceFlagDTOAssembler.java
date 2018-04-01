package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.OpeningBalanceFlagDTO;
import com.ledger.common.dto.finance.management.OpeningBalanceFlagDTOBuilder;
import com.ledger.domain.financial.management.OpeningBalanceFlag;
import com.ledger.domain.financial.management.OpeningBalanceFlagBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class OpeningBalanceFlagDTOAssembler implements IObjectAssembler<OpeningBalanceFlag, OpeningBalanceFlagDTO> {

    @Override
    public OpeningBalanceFlagDTO toDTO(OpeningBalanceFlag domainObject) {
        return new OpeningBalanceFlagDTOBuilder()
                .setUserID(domainObject.getUserID())
                .setOpeningBalanceFlagID(domainObject.getOpeningBalanceFlagID())
                .setIsFormSaldo(domainObject.isIsFormSaldo())
                .setIsFormHutang(domainObject.isIsFormHutang())
                .setIsFormPiutang(domainObject.isIsFormPiutang())
                .setIsFormPersediaan(domainObject.isIsFormPersediaan())
                .setIsFormActiva(domainObject.isIsFormActiva())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createOpeningBalanceFlagDTO();
    }

    @Override
    public OpeningBalanceFlag toDomain(OpeningBalanceFlagDTO dtoObject) {
        return new OpeningBalanceFlagBuilder()
                .setUserID(dtoObject.getUserID())
                .setOpeningBalanceFlagID(dtoObject.getOpeningBalanceFlagID())
                .setIsFormSaldo(dtoObject.isIsFormSaldo())
                .setIsFormHutang(dtoObject.isIsFormHutang())
                .setIsFormPiutang(dtoObject.isIsFormPiutang())
                .setIsFormPersediaan(dtoObject.isIsFormPersediaan())
                .setIsFormActiva(dtoObject.isIsFormActiva())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createOpeningBalanceFlag();
    }

    public List<OpeningBalanceFlag> toDomains(List<OpeningBalanceFlagDTO> arg0) {
        List<OpeningBalanceFlag> res = new ArrayList<>();
        for (OpeningBalanceFlagDTO t : arg0) {
            res.add(new OpeningBalanceFlagDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<OpeningBalanceFlagDTO> toDTOs(List<OpeningBalanceFlag> arg0) {
        List<OpeningBalanceFlagDTO> res = new ArrayList<>();
        for (OpeningBalanceFlag t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
