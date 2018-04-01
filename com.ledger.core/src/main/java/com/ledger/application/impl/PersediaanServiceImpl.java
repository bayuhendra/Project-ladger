package com.ledger.application.impl;

import com.ledger.common.application.finance.management.PersediaanService;
import com.ledger.common.dto.finance.management.PersediaanDTO;
import com.ledger.domain.financial.management.Persediaan;
import com.ledger.domain.financial.management.PersediaanBuilder;
import com.ledger.domain.financial.management.PersediaanRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.PersediaanDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class PersediaanServiceImpl implements PersediaanService {

    private PersediaanDTOAssembler persediaanDTOAssembler;
    private PersediaanRepository persediaanRepository;

    public void setPersediaanDTOAssembler(PersediaanDTOAssembler persediaanDTOAssembler) {
        this.persediaanDTOAssembler = persediaanDTOAssembler;
    }

    public void setPersediaanRepository(PersediaanRepository persediaanRepository) {
        this.persediaanRepository = persediaanRepository;
    }

    @Override
    public void SaveOrUpdate(PersediaanDTO persediaan) {
        Persediaan t = persediaanRepository.findByID(persediaan.getPersediaanID());

        if (t == null) {
            t = persediaanDTOAssembler.toDomain(persediaan);
        } else {
            Persediaan newPersediaan = persediaanDTOAssembler.toDomain(persediaan);
            t.assignNewPersediaan(newPersediaan);

        }
        persediaanRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(PersediaanDTO persediaan) {
        Persediaan p = persediaanDTOAssembler.toDomain(persediaan);
        persediaanRepository.deleteData(p);
    }

    @Override
    public PersediaanDTO getDummyData() {
        Persediaan persediaan = new PersediaanBuilder()
                .setPersediaanID("HT001")
                .setNamaPersediaan("TANAH")
                .setJenisPersediaan("BAHAN BAKU")
                .setJumlahPersediaan(5)
                .setHargaPersediaan(500000.0)
                .setTotalHargaPersediaan(250000.0)
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createPersediaan();
        return persediaanDTOAssembler.toDTO(persediaan);
    }

    @Override
    public PersediaanDTO findByID(String persediaanID) {
        Validate.notNull(persediaanRepository);
        Persediaan b = (Persediaan) persediaanRepository.findByID(persediaanID);
        if (b != null) {
            return persediaanDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public PersediaanDTO findByName(String namaPersediaan) {
        Validate.notNull(persediaanRepository);
        Persediaan b = (Persediaan) persediaanRepository.findByName(namaPersediaan);
        if (b != null) {
            return persediaanDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<PersediaanDTO> findAll() {
        Validate.notNull(persediaanRepository);
        List<Persediaan> listPersediaan = persediaanRepository.findAll();
        if (listPersediaan != null) {
            return (List<PersediaanDTO>) persediaanDTOAssembler.toDTOs(listPersediaan);
        }
        return null;
    }

    @Override
    public List<PersediaanDTO> findByParams(Map map) {
        Validate.notNull(persediaanRepository);
        List<Persediaan> listPersediaan = persediaanRepository.findByParams(map);
        if (listPersediaan != null) {
            return (List<PersediaanDTO>) persediaanDTOAssembler.toDTOs(listPersediaan);
        }
        return null;
    }

    @Override
    public List<PersediaanDTO> findByUserID(String userID) {
        Validate.notNull(persediaanRepository);
        List<Persediaan> listPersediaan = persediaanRepository.findByUserID(userID);
        if (listPersediaan != null) {
            return (List<PersediaanDTO>) persediaanDTOAssembler.toDTOs(listPersediaan);
        }
        return null;
    }

}
