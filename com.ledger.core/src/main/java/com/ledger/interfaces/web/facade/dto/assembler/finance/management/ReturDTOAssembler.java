package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.ReturDTO;
import com.ledger.common.dto.finance.management.ReturDTOBuilder;
import com.ledger.domain.financial.management.Retur;
import com.ledger.domain.financial.management.ReturBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class ReturDTOAssembler implements IObjectAssembler<Retur, ReturDTO> {

    @Override
    public ReturDTO toDTO(Retur domainObject) {
        return new ReturDTOBuilder()
                .setReturID(domainObject.getReturID())
                .setUserID(domainObject.getUserID())
                .setTransaksiID(domainObject.getTransaksiID())
                .setNamaBarang(domainObject.getNamaBarang())
                .setJenisRetur(domainObject.getJenisRetur())
                .setSatuan(domainObject.getSatuan())
                .setJumlah(domainObject.getJumlah())
                .setHargaBarang(domainObject.getHargaBarang())
                .setTotalHarga(domainObject.getTotalHarga())
                .setTanggalRetur(domainObject.getTanggalRetur())
                .setTipePembayaran(domainObject.getTipePembayaran())
                .setBuktiPembelian(domainObject.getBuktiPembelian())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createReturDTO();
    }

    @Override
    public Retur toDomain(ReturDTO dtoObject) {
        return new ReturBuilder()
                .setReturID(dtoObject.getReturID())
                .setUserID(dtoObject.getUserID())
                .setTransaksiID(dtoObject.getTransaksiID())
                .setNamaBarang(dtoObject.getNamaBarang())
                .setJenisRetur(dtoObject.getJenisRetur())
                .setSatuan(dtoObject.getSatuan())
                .setJumlah(dtoObject.getJumlah())
                .setHargaBarang(dtoObject.getHargaBarang())
                .setTotalHarga(dtoObject.getTotalHarga())
                .setTanggalRetur(dtoObject.getTanggalRetur())
                .setTipePembayaran(dtoObject.getTipePembayaran())
                .setBuktiPembelian(dtoObject.getBuktiPembelian())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createRetur();
    }

    public List<Retur> toDomains(List<ReturDTO> arg0) {
        List<Retur> res = new ArrayList<>();
        for (ReturDTO t : arg0) {
            res.add(new ReturDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<ReturDTO> toDTOs(List<Retur> arg0) {
        List<ReturDTO> res = new ArrayList<>();
        for (Retur t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
