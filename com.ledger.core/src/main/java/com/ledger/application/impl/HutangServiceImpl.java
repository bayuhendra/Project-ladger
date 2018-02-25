package com.ledger.application.impl;

import com.ledger.common.application.finance.management.HutangService;
import com.ledger.common.dto.finance.management.HutangDTO;
import com.ledger.domain.financial.management.Hutang;
import com.ledger.domain.financial.management.HutangBuilder;
import com.ledger.domain.financial.management.HutangRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.HutangDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class HutangServiceImpl implements HutangService {

    private HutangDTOAssembler hutangDTOAssembler;
    private HutangRepository hutangRepository;

    public void setHutangDTOAssembler(HutangDTOAssembler hutangDTOAssembler) {
        this.hutangDTOAssembler = hutangDTOAssembler;
    }

    public void setHutangRepository(HutangRepository hutangRepository) {
        this.hutangRepository = hutangRepository;
    }

    @Override
    public void SaveOrUpdate(HutangDTO hutang) {
        Hutang t = hutangRepository.findByID(hutang.getHutangID());

        if (t == null) {
            t = hutangDTOAssembler.toDomain(hutang);
        } else {
            Hutang newHutang = hutangDTOAssembler.toDomain(hutang);
            t.assignNewHutang(newHutang);

        }
        hutangRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(HutangDTO hutang) {
        Hutang p = hutangDTOAssembler.toDomain(hutang);
        hutangRepository.deleteData(p);
    }

    @Override
    public HutangDTO getDummyData() {
        Hutang hutang = new HutangBuilder()
                .setHutangID("HT001")
                .setNamaHutang("TANAH")
                .setJumlahHutang(15000000.0)
                .setStatus("LUNAS")
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createHutang();
        return hutangDTOAssembler.toDTO(hutang);
    }

    @Override
    public HutangDTO findByID(String hutangID) {
        Validate.notNull(hutangRepository);
        Hutang b = (Hutang) hutangRepository.findByID(hutangID);
        if (b != null) {
            return hutangDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<HutangDTO> findAll() {
        Validate.notNull(hutangRepository);
        List<Hutang> listHutang = hutangRepository.findAll();
        if (listHutang != null) {
            return (List<HutangDTO>) hutangDTOAssembler.toDTOs(listHutang);
        }
        return null;
    }

    @Override
    public List<HutangDTO> findByParams(Map map) {
        Validate.notNull(hutangRepository);
        List<Hutang> listHutang = hutangRepository.findByParams(map);
        if (listHutang != null) {
            return (List<HutangDTO>) hutangDTOAssembler.toDTOs(listHutang);
        }
        return null;
    }

    @Override
    public List<HutangDTO> findByUserID(String userID) {
        Validate.notNull(hutangRepository);
        List<Hutang> listHutang = hutangRepository.findByUserID(userID);
        if (listHutang != null) {
            return (List<HutangDTO>) hutangDTOAssembler.toDTOs(listHutang);
        }
        return null;
    }

}
