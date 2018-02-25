package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.HutangDTO;
import com.ledger.common.dto.finance.management.HutangDTOBuilder;
import com.ledger.domain.financial.management.Hutang;
import com.ledger.domain.financial.management.HutangBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class HutangDTOAssembler implements IObjectAssembler<Hutang, HutangDTO> {

    @Override
    public HutangDTO toDTO(Hutang domainObject) {
        return new HutangDTOBuilder()
                .setUserID(domainObject.getUserID())
                .setHutangID(domainObject.getHutangID())
                .setNamaHutang(domainObject.getNamaHutang())
                .setJumlahHutang(domainObject.getJumlahHutang())
                .setStatus(domainObject.getStatus())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createHutangDTO();
    }

    @Override
    public Hutang toDomain(HutangDTO dtoObject) {
        return new HutangBuilder()
                .setUserID(dtoObject.getUserID())
                .setHutangID(dtoObject.getHutangID())
                .setNamaHutang(dtoObject.getNamaHutang())
                .setJumlahHutang(dtoObject.getJumlahHutang())
                .setStatus(dtoObject.getStatus())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createHutang();
    }

    public List<Hutang> toDomains(List<HutangDTO> arg0) {
        List<Hutang> res = new ArrayList<>();
        for (HutangDTO t : arg0) {
            res.add(new HutangDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<HutangDTO> toDTOs(List<Hutang> arg0) {
        List<HutangDTO> res = new ArrayList<>();
        for (Hutang t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
