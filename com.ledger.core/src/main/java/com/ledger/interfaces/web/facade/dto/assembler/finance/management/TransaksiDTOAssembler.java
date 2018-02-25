/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.TransaksiDTO;
import com.ledger.common.dto.finance.management.TransaksiDTOBuilder;
import com.ledger.domain.financial.management.Transaksi;
import com.ledger.domain.financial.management.TransaksiBuilder;
import com.ledger.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class TransaksiDTOAssembler implements IObjectAssembler<Transaksi, TransaksiDTO> {

    @Override
    public TransaksiDTO toDTO(Transaksi domainObject) {
        return new TransaksiDTOBuilder()
                .setTransaksiID(domainObject.getTransaksiID())
                .setUserIDTransaksi(domainObject.getUserID())
                .setNamaProduk(domainObject.getNamaProduk())
                .setKategoriTransaksi(domainObject.getKategoriTransaksi())
                .setJenisBarang(domainObject.getJenisBarang())
                .setHarga(domainObject.getHarga())
                .setDiskon(domainObject.getDiskon())
                .setTotal(domainObject.getTotal())
                .setTanggalTransaksi(domainObject.getTanggalTransaksi())
                .setStatusTransaksi(domainObject.getStatusTransaksi())
                .setDeskripsi(domainObject.getDeskripsi())
                .setJenisPembayaran(domainObject.getJenisPembayaran())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createTransaksiDTO();
    }

    @Override
    public Transaksi toDomain(TransaksiDTO dtoObject) {
        return new TransaksiBuilder()
                .setTransaksiID(dtoObject.getTransaksiID())
                .setUserID(dtoObject.getUserID())
                .setNamaProduk(dtoObject.getNamaProduk())
                .setKategoriTransaksi(dtoObject.getKategoriTransaksi())
                .setJenisBarang(dtoObject.getJenisBarang())
                .setHarga(dtoObject.getHarga())
                .setDiskon(dtoObject.getDiskon())
                .setTotal(dtoObject.getTotal())
                .setTanggalTransaksi(dtoObject.getTanggalTransaksi())
                .setStatusTransaksi(dtoObject.getStatusTransaksi())
                .setDeskripsi(dtoObject.getDeskripsi())
                .setJenisPembayaran(dtoObject.getJenisPembayaran())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createTransaksi();
    }

    public List<Transaksi> toDomains(List<TransaksiDTO> arg0) {
        List<Transaksi> res = new ArrayList<>();
        for (TransaksiDTO t : arg0) {
            res.add(new TransaksiDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<TransaksiDTO> toDTOs(List<Transaksi> arg0) {
        List<TransaksiDTO> res = new ArrayList<>();
        for (Transaksi t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
