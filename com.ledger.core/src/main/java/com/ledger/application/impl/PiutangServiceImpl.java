package com.ledger.application.impl;

import com.ledger.common.application.finance.management.PiutangService;
import com.ledger.common.dto.finance.management.PiutangDTO;
import com.ledger.domain.financial.management.Piutang;
import com.ledger.domain.financial.management.PiutangBuilder;
import com.ledger.domain.financial.management.PiutangRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.PiutangDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class PiutangServiceImpl implements PiutangService {

    private PiutangDTOAssembler piutangDTOAssembler;
    private PiutangRepository piutangRepository;

    public void setPiutangDTOAssembler(PiutangDTOAssembler piutangDTOAssembler) {
        this.piutangDTOAssembler = piutangDTOAssembler;
    }

    public void setPiutangRepository(PiutangRepository piutangRepository) {
        this.piutangRepository = piutangRepository;
    }

    @Override
    public void SaveOrUpdate(PiutangDTO piutang) {
        Piutang t = piutangRepository.findByID(piutang.getPiutangID());

        if (t == null) {
            t = piutangDTOAssembler.toDomain(piutang);
        } else {
            Piutang newPiutang = piutangDTOAssembler.toDomain(piutang);
            t.assignNewPiutang(newPiutang);

        }
        piutangRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(PiutangDTO piutang) {
        Piutang p = piutangDTOAssembler.toDomain(piutang);
        piutangRepository.deleteData(p);
    }

    @Override
    public PiutangDTO getDummyData() {
        Piutang piutang = new PiutangBuilder()
                .setPiutangID("PT001")
                .setNamaPiutang("TANAH")
                .setJumlahPiutang(15000000.0)
                .setStatus("LUNAS")
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createPiutang();
        return piutangDTOAssembler.toDTO(piutang);
    }

    @Override
    public PiutangDTO findByID(String piutangID) {
        Validate.notNull(piutangRepository);
        Piutang b = (Piutang) piutangRepository.findByID(piutangID);
        if (b != null) {
            return piutangDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<PiutangDTO> findAll() {
        Validate.notNull(piutangRepository);
        List<Piutang> listPiutang = piutangRepository.findAll();
        if (listPiutang != null) {
            return (List<PiutangDTO>) piutangDTOAssembler.toDTOs(listPiutang);
        }
        return null;
    }

    @Override
    public List<PiutangDTO> findByParams(Map map) {
        Validate.notNull(piutangRepository);
        List<Piutang> listPiutang = piutangRepository.findByParams(map);
        if (listPiutang != null) {
            return (List<PiutangDTO>) piutangDTOAssembler.toDTOs(listPiutang);
        }
        return null;
    }

    @Override
    public List<PiutangDTO> findByUserID(String userID) {
        Validate.notNull(piutangRepository);
        List<Piutang> listPiutang = piutangRepository.findByUserID(userID);
        if (listPiutang != null) {
            return (List<PiutangDTO>) piutangDTOAssembler.toDTOs(listPiutang);
        }
        return null;
    }

}
