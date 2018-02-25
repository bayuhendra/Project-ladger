package com.ledger.application.impl;

import com.ledger.common.application.finance.management.SaldoKasService;
import com.ledger.common.dto.finance.management.SaldoKasDTO;
import com.ledger.domain.financial.management.SaldoKas;
import com.ledger.domain.financial.management.SaldoKasBuilder;
import com.ledger.domain.financial.management.SaldoKasRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.SaldoKasDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class SaldoKasServiceImpl implements SaldoKasService {

    private SaldoKasDTOAssembler saldoKasDTOAssembler;
    private SaldoKasRepository saldoKasRepository;

    public void setSaldoKasDTOAssembler(SaldoKasDTOAssembler saldoKasDTOAssembler) {
        this.saldoKasDTOAssembler = saldoKasDTOAssembler;
    }

    public void setSaldoKasRepository(SaldoKasRepository saldoKasRepository) {
        this.saldoKasRepository = saldoKasRepository;
    }

    @Override
    public void SaveOrUpdate(SaldoKasDTO saldoKas) {
        SaldoKas t = saldoKasRepository.findByID(saldoKas.getSaldoKasID());

        if (t == null) {
            t = saldoKasDTOAssembler.toDomain(saldoKas);
        } else {
            SaldoKas newSaldoKas = saldoKasDTOAssembler.toDomain(saldoKas);
            t.assignNewSaldoKas(newSaldoKas);

        }
        saldoKasRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(SaldoKasDTO saldoKas) {
        SaldoKas p = saldoKasDTOAssembler.toDomain(saldoKas);
        saldoKasRepository.deleteData(p);
    }

    @Override
    public SaldoKasDTO getDummyData() {
        SaldoKas saldoKas = new SaldoKasBuilder()
                .setSaldoKasID("SD001")
                .setSaldoKas(2000000.0)
                .setSaldoBank(30000000.0)
                .setSaldoKasBank(50000000.0)
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createSaldoKas();
        return saldoKasDTOAssembler.toDTO(saldoKas);
    }

    @Override
    public SaldoKasDTO findByID(String saldoKasID) {
        Validate.notNull(saldoKasRepository);
        SaldoKas b = (SaldoKas) saldoKasRepository.findByID(saldoKasID);
        if (b != null) {
            return saldoKasDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<SaldoKasDTO> findAll() {
        Validate.notNull(saldoKasRepository);
        List<SaldoKas> listSaldoKas = saldoKasRepository.findAll();
        if (listSaldoKas != null) {
            return (List<SaldoKasDTO>) saldoKasDTOAssembler.toDTOs(listSaldoKas);
        }
        return null;
    }

    @Override
    public List<SaldoKasDTO> findByParams(Map map) {
        Validate.notNull(saldoKasRepository);
        List<SaldoKas> listSaldoKas = saldoKasRepository.findByParams(map);
        if (listSaldoKas != null) {
            return (List<SaldoKasDTO>) saldoKasDTOAssembler.toDTOs(listSaldoKas);
        }
        return null;
    }

    @Override
    public SaldoKasDTO findByUserID(String userID) {
        Validate.notNull(saldoKasRepository);
        SaldoKas saldoKas = saldoKasRepository.findByUserID(userID);
        if (saldoKas != null) {
            return saldoKasDTOAssembler.toDTO(saldoKas);
        }
        return null;
    }

}
