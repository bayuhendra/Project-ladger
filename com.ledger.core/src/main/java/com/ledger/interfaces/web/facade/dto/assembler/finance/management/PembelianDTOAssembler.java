/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                .setNamaBarang(domainObject.getNamaBarang())
                .setKategoriPembelian(domainObject.getKategoriPembelian())
                .setJenisPembelian(domainObject.getJenisPembelian())
                .setJumlah(domainObject.getJumlah())
                .setDiskon(domainObject.getDiskon())
                .setTotal(domainObject.getTotal())
                .setTanggalTransaksiPembelian(domainObject.getTanggalTransaksiPembelian())
                .setStatusTransaksi(domainObject.getStatusTransaksi())
                .setCatatan(domainObject.getCatatan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .createPembelianDTO();
    }

    @Override
    public Pembelian toDomain(PembelianDTO dtoObject) {
        return new PembelianBuilder()
                .setPembelianID(dtoObject.getPembelianID())
                .setNamaBarang(dtoObject.getNamaBarang())
                .setKategoriPembelian(dtoObject.getKategoriPembelian())
                .setJenisPembelian(dtoObject.getJenisPembelian())
                .setJumlah(dtoObject.getJumlah())
                .setDiskon(dtoObject.getDiskon())
                .setTotal(dtoObject.getTotal())
                .setTanggalTransaksiPembelian(dtoObject.getTanggalTransaksiPembelian())
                .setStatusTransaksi(dtoObject.getStatusTransaksi())
                .setCatatan(dtoObject.getCatatan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy()).createPembelian();
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
