package com.ledger.application.impl;

import com.ledger.common.application.finance.management.OpeningBalanceFlagService;
import com.ledger.common.dto.finance.management.OpeningBalanceFlagDTO;
import com.ledger.domain.financial.management.OpeningBalanceFlag;
import com.ledger.domain.financial.management.OpeningBalanceFlagBuilder;
import com.ledger.domain.financial.management.OpeningBalanceFlagRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.OpeningBalanceFlagDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class OpeningBalanceFlagServiceImpl implements OpeningBalanceFlagService {

    private OpeningBalanceFlagDTOAssembler openingBalanceFlagDTOAssembler;
    private OpeningBalanceFlagRepository openingBalanceFlagRepository;

    public void setOpeningBalanceFlagDTOAssembler(OpeningBalanceFlagDTOAssembler openingBalanceFlagDTOAssembler) {
        this.openingBalanceFlagDTOAssembler = openingBalanceFlagDTOAssembler;
    }

    public void setOpeningBalanceFlagRepository(OpeningBalanceFlagRepository openingBalanceFlagRepository) {
        this.openingBalanceFlagRepository = openingBalanceFlagRepository;
    }

    @Override
    public void SaveOrUpdate(OpeningBalanceFlagDTO openingBalanceFlag) {
        OpeningBalanceFlag t = openingBalanceFlagRepository.findByID(openingBalanceFlag.getOpeningBalanceFlagID());

        if (t == null) {
            t = openingBalanceFlagDTOAssembler.toDomain(openingBalanceFlag);
        } else {
            OpeningBalanceFlag newOpeningBalanceFlag = openingBalanceFlagDTOAssembler.toDomain(openingBalanceFlag);
            t.assignNewOpeningBalanceFlag(newOpeningBalanceFlag);

        }
        openingBalanceFlagRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(OpeningBalanceFlagDTO openingBalanceFlag) {
        OpeningBalanceFlag p = openingBalanceFlagDTOAssembler.toDomain(openingBalanceFlag);
        openingBalanceFlagRepository.deleteData(p);
    }

    @Override
    public OpeningBalanceFlagDTO getDummyData() {
        OpeningBalanceFlag openingBalanceFlag = new OpeningBalanceFlagBuilder()
                .setOpeningBalanceFlagID("OPN001")
                .setIsFormSaldo(true)
                .setIsFormHutang(true)
                .setIsFormPiutang(true)
                .setIsFormPersediaan(true)
                .setIsFormActiva(true)
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createOpeningBalanceFlag();
        return openingBalanceFlagDTOAssembler.toDTO(openingBalanceFlag);
    }

    @Override
    public OpeningBalanceFlagDTO findByID(String openingBalanceFlagID) {
        Validate.notNull(openingBalanceFlagRepository);
        OpeningBalanceFlag b = (OpeningBalanceFlag) openingBalanceFlagRepository.findByID(openingBalanceFlagID);
        if (b != null) {
            return openingBalanceFlagDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<OpeningBalanceFlagDTO> findAll() {
        Validate.notNull(openingBalanceFlagRepository);
        List<OpeningBalanceFlag> listOpeningBalanceFlag = openingBalanceFlagRepository.findAll();
        if (listOpeningBalanceFlag != null) {
            return (List<OpeningBalanceFlagDTO>) openingBalanceFlagDTOAssembler.toDTOs(listOpeningBalanceFlag);
        }
        return null;
    }

    @Override
    public List<OpeningBalanceFlagDTO> findByParams(Map map) {
        Validate.notNull(openingBalanceFlagRepository);
        List<OpeningBalanceFlag> listOpeningBalanceFlag = openingBalanceFlagRepository.findByParams(map);
        if (listOpeningBalanceFlag != null) {
            return (List<OpeningBalanceFlagDTO>) openingBalanceFlagDTOAssembler.toDTOs(listOpeningBalanceFlag);
        }
        return null;
    }

    @Override
    public OpeningBalanceFlagDTO findByUserID(String userID) {
        Validate.notNull(openingBalanceFlagRepository);
        OpeningBalanceFlag openingBalanceFlag = openingBalanceFlagRepository.findByUserID(userID);
        if (openingBalanceFlag != null) {
            return openingBalanceFlagDTOAssembler.toDTO(openingBalanceFlag);
        }
        return null;
    }

}
