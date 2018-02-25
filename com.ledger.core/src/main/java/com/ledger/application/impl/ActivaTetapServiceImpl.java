package com.ledger.application.impl;

import com.ledger.common.application.finance.management.ActivaTetapService;
import com.ledger.common.dto.finance.management.ActivaTetapDTO;
import com.ledger.domain.financial.management.ActivaTetap;
import com.ledger.domain.financial.management.ActivaTetapBuilder;
import com.ledger.domain.financial.management.ActivaTetapRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.ActivaTetapDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class ActivaTetapServiceImpl implements ActivaTetapService {

    private ActivaTetapDTOAssembler activaTetapDTOAssembler;
    private ActivaTetapRepository activaTetapRepository;

    public void setActivaTetapDTOAssembler(ActivaTetapDTOAssembler activaTetapDTOAssembler) {
        this.activaTetapDTOAssembler = activaTetapDTOAssembler;
    }

    public void setActivaTetapRepository(ActivaTetapRepository activaTetapRepository) {
        this.activaTetapRepository = activaTetapRepository;
    }

    @Override
    public void SaveOrUpdate(ActivaTetapDTO activaTetap) {
        ActivaTetap t = activaTetapRepository.findByID(activaTetap.getActivaTetapID());

        if (t == null) {
            t = activaTetapDTOAssembler.toDomain(activaTetap);
        } else {
            ActivaTetap newActivaTetap = activaTetapDTOAssembler.toDomain(activaTetap);
            t.assignNewActivaTetap(newActivaTetap);

        }
        activaTetapRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(ActivaTetapDTO activaTetap) {
        ActivaTetap p = activaTetapDTOAssembler.toDomain(activaTetap);
        activaTetapRepository.deleteData(p);
    }

    @Override
    public ActivaTetapDTO getDummyData() {
        ActivaTetap activaTetap = new ActivaTetapBuilder()
                .setActivaTetapID("HT001")
                .setNamaActivaTetap("TANAH")
                .setHargaActivaTetap(15000000.0)
                .setLamaPemakaian(2)
                .setJangkaWaktuPenyusutan(5)
                .setPersenPenyusutan(5)
                .setTotalPenyusutan(500000)
                .setStatus("LUNAS")
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createActivaTetap();
        return activaTetapDTOAssembler.toDTO(activaTetap);
    }

    @Override
    public ActivaTetapDTO findByID(String activaTetapID) {
        Validate.notNull(activaTetapRepository);
        ActivaTetap b = (ActivaTetap) activaTetapRepository.findByID(activaTetapID);
        if (b != null) {
            return activaTetapDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<ActivaTetapDTO> findAll() {
        Validate.notNull(activaTetapRepository);
        List<ActivaTetap> listActivaTetap = activaTetapRepository.findAll();
        if (listActivaTetap != null) {
            return (List<ActivaTetapDTO>) activaTetapDTOAssembler.toDTOs(listActivaTetap);
        }
        return null;
    }

    @Override
    public List<ActivaTetapDTO> findByParams(Map map) {
        Validate.notNull(activaTetapRepository);
        List<ActivaTetap> listActivaTetap = activaTetapRepository.findByParams(map);
        if (listActivaTetap != null) {
            return (List<ActivaTetapDTO>) activaTetapDTOAssembler.toDTOs(listActivaTetap);
        }
        return null;
    }

    @Override
    public List<ActivaTetapDTO> findByUserID(String userID) {
        Validate.notNull(activaTetapRepository);
        List<ActivaTetap> listActivaTetap = activaTetapRepository.findByUserID(userID);
        if (listActivaTetap != null) {
            return (List<ActivaTetapDTO>) activaTetapDTOAssembler.toDTOs(listActivaTetap);
        }
        return null;
    }

}
