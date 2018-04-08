package com.ledger.application.impl;

import com.ledger.common.application.finance.management.ReturService;
import com.ledger.common.dto.finance.management.ReturDTO;
import com.ledger.domain.financial.management.Retur;
import com.ledger.domain.financial.management.ReturBuilder;
import com.ledger.domain.financial.management.ReturRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.ReturDTOAssembler;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class ReturServiceImpl implements ReturService {

    private ReturDTOAssembler returDTOAssembler;
    private ReturRepository returRepository;

    public void setReturDTOAssembler(ReturDTOAssembler returDTOAssembler) {
        this.returDTOAssembler = returDTOAssembler;
    }

    public void setReturRepository(ReturRepository returRepository) {
        this.returRepository = returRepository;
    }

    @Override
    public void SaveOrUpdate(ReturDTO retur) {
        Retur t = returRepository.findByID(retur.getReturID());

        if (t == null) {
            t = returDTOAssembler.toDomain(retur);
        } else {
            Retur newRetur = returDTOAssembler.toDomain(retur);
            t.assignNewDataRetur(newRetur);

        }
        returRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(ReturDTO retur) {
        Retur p = returDTOAssembler.toDomain(retur);
        returRepository.deleteData(p);
    }

    @Override
    public ReturDTO getDummyData() {
        Retur retur = new ReturBuilder()
                //                .setReturID("C1")
                //                .setNamaBarang("aa")
                //                .setKategoriRetur(Kategori.PEMBELIAN)
                //                .setJenisRetur(JenisBarang.ELETRONIK)
                //                .setJumlah(12)
                //                .setDiskon(3)
                //                .setTotal(4)
                //                .setTanggalTransaksiRetur(new Date())
                //                .setStatusTransaksi(StatusTransaksi.DONE)
                //                .setCatatan("catatan")
                //                .setCreatedBy("createdBy")
                //                .setCreatedDate(new Date())
                //                .setModifiedBy("aa")
                //                .setModifiedDate(new Date())
                .createRetur();
        return returDTOAssembler.toDTO(retur);
    }

    @Override
    public ReturDTO findByID(String returID) {
        Validate.notNull(returRepository);
        Retur b = (Retur) returRepository.findByID(returID);
        if (b != null) {
            return returDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<ReturDTO> findAll() {
        Validate.notNull(returRepository);
        return returDTOAssembler.toDTOs(returRepository.findAll());
    }

    @Override
    public List<ReturDTO> findByParams(Map map) {
        Validate.notNull(returRepository);
        List<Retur> listretur = returRepository.findByParams(map);
        if (listretur != null) {
            return (List<ReturDTO>) returDTOAssembler.toDTOs(listretur);
        }
        return null;
    }

}
