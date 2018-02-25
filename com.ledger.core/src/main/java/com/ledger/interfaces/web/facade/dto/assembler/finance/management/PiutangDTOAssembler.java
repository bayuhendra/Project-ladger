package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.PiutangDTO;
import com.ledger.common.dto.finance.management.PiutangDTOBuilder;
import com.ledger.domain.financial.management.Piutang;
import com.ledger.domain.financial.management.PiutangBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class PiutangDTOAssembler implements IObjectAssembler<Piutang, PiutangDTO> {

    @Override
    public PiutangDTO toDTO(Piutang domainObject) {
        return new PiutangDTOBuilder()
                .setUserID(domainObject.getUserID())
                .setPiutangID(domainObject.getPiutangID())
                .setNamaPiutang(domainObject.getNamaPiutang())
                .setJumlahPiutang(domainObject.getJumlahPiutang())
                .setStatus(domainObject.getStatus())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPiutangDTO();
    }

    @Override
    public Piutang toDomain(PiutangDTO dtoObject) {
        return new PiutangBuilder()
                .setUserID(dtoObject.getUserID())
                .setPiutangID(dtoObject.getPiutangID())
                .setNamaPiutang(dtoObject.getNamaPiutang())
                .setJumlahPiutang(dtoObject.getJumlahPiutang())
                .setStatus(dtoObject.getStatus())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPiutang();
    }

    public List<Piutang> toDomains(List<PiutangDTO> arg0) {
        List<Piutang> res = new ArrayList<>();
        for (PiutangDTO t : arg0) {
            res.add(new PiutangDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PiutangDTO> toDTOs(List<Piutang> arg0) {
        List<PiutangDTO> res = new ArrayList<>();
        for (Piutang t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
