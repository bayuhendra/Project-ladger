package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.PenjualanDTO;
import com.ledger.common.dto.finance.management.PenjualanDTOBuilder;
import com.ledger.domain.financial.management.Penjualan;
import com.ledger.domain.financial.management.PenjualanBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class PenjualanDTOAssembler implements IObjectAssembler<Penjualan, PenjualanDTO> {

    @Override
    public PenjualanDTO toDTO(Penjualan domainObject) {
        return new PenjualanDTOBuilder()
                .setPenjualanID(domainObject.getPenjualanID())
                .setUserID(domainObject.getUserID())
                .setNamaBarang(domainObject.getNamaBarang())
                .setJenisBarang(domainObject.getJenisBarang())
                .setSatuan(domainObject.getSatuan())
                .setJumlah(domainObject.getJumlah())
                .setDiskon(domainObject.getDiskon())
                .setHargaBarang(domainObject.getHargaBarang())
                .setTotalHarga(domainObject.getTotalHarga())
                .setHargaPokokPenjualan(domainObject.getHargaPokokPenjualan())
                .setPendapatanUsaha(domainObject.getPendapatanUsaha())
                .setTanggalPenjualan(domainObject.getTanggalPenjualan())
                .setBuktiPenjualan(domainObject.getBuktiPenjualan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPenjualanDTO();
    }

    @Override
    public Penjualan toDomain(PenjualanDTO dtoObject) {
        return new PenjualanBuilder()
                .setPenjualanID(dtoObject.getPenjualanID())
                .setUserID(dtoObject.getUserID())
                .setNamaBarang(dtoObject.getNamaBarang())
                .setJenisBarang(dtoObject.getJenisBarang())
                .setSatuan(dtoObject.getSatuan())
                .setJumlah(dtoObject.getJumlah())
                .setDiskon(dtoObject.getDiskon())
                .setHargaBarang(dtoObject.getHargaBarang())
                .setTotalHarga(dtoObject.getTotalHarga())
                .setHargaPokokPenjualan(dtoObject.getHargaPokokPenjualan())
                .setPendapatanUsaha(dtoObject.getPendapatanUsaha())
                .setTanggalPenjualan(dtoObject.getTanggalPenjualan())
                .setBuktiPenjualan(dtoObject.getBuktiPenjualan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPenjualan();
    }

    public List<Penjualan> toDomains(List<PenjualanDTO> arg0) {
        List<Penjualan> res = new ArrayList<>();
        for (PenjualanDTO t : arg0) {
            res.add(new PenjualanDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PenjualanDTO> toDTOs(List<Penjualan> arg0) {
        List<PenjualanDTO> res = new ArrayList<>();
        for (Penjualan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
