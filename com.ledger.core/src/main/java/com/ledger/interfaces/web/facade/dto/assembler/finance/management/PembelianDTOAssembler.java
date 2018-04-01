package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.PembelianDTO;
import com.ledger.common.dto.finance.management.PembelianDTOBuilder;
import com.ledger.domain.financial.management.Pembelian;
import com.ledger.domain.financial.management.PembelianBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class PembelianDTOAssembler implements IObjectAssembler<Pembelian, PembelianDTO> {

    @Override
    public PembelianDTO toDTO(Pembelian domainObject) {
        return new PembelianDTOBuilder()
                .setPembelianID(domainObject.getPembelianID())
                .setUserID(domainObject.getUserID())
                .setNamaBarang(domainObject.getNamaBarang())
                .setJenisBarang(domainObject.getJenisBarang())
                .setSatuan(domainObject.getSatuan())
                .setJumlah(domainObject.getJumlah())
                .setDiskon(domainObject.getDiskon())
                .setHargaBarang(domainObject.getHargaBarang())
                .setTotalHarga(domainObject.getTotalHarga())
                .setTanggalPembelian(domainObject.getTanggalPembelian())
                .setTipePembayaran(domainObject.getTipePembayaran())
                .setBuktiPembelian(domainObject.getBuktiPembelian())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPembelianDTO();
    }

    @Override
    public Pembelian toDomain(PembelianDTO dtoObject) {
        return new PembelianBuilder()
                .setPembelianID(dtoObject.getPembelianID())
                .setUserID(dtoObject.getUserID())
                .setNamaBarang(dtoObject.getNamaBarang())
                .setJenisBarang(dtoObject.getJenisBarang())
                .setSatuan(dtoObject.getSatuan())
                .setJumlah(dtoObject.getJumlah())
                .setDiskon(dtoObject.getDiskon())
                .setHargaBarang(dtoObject.getHargaBarang())
                .setTotalHarga(dtoObject.getTotalHarga())
                .setTanggalPembelian(dtoObject.getTanggalPembelian())
                .setTipePembayaran(dtoObject.getTipePembayaran())
                .setBuktiPembelian(dtoObject.getBuktiPembelian())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPembelian();
    }

    public List<Pembelian> toDomains(List<PembelianDTO> arg0) {
        List<Pembelian> res = new ArrayList<>();
        for (PembelianDTO t : arg0) {
            res.add(new PembelianDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PembelianDTO> toDTOs(List<Pembelian> arg0) {
        List<PembelianDTO> res = new ArrayList<>();
        for (Pembelian t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
