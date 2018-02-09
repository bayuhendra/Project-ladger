/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.interfaces.web.facade.dto.assembler.finance.management;

import com.ledger.common.dto.finance.management.PenjualanDTO;
import com.ledger.common.dto.finance.management.PenjualanDTOBuilder;
import com.ledger.domain.financial.management.Penjualan;
import com.ledger.domain.financial.management.PenjualanBuilder;
import com.ledger.shared.object.IObjectAssembler;
import com.ledger.shared.type.Kategori;
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
                .setNamaBarang(domainObject.getNamaBarang())
                .setKategoriPenjualan(domainObject.getKategoriPenjualan())
                .setJenisPenjualan(domainObject.getJenisPenjualan())
                .setJumlah(domainObject.getJumlah())
                .setDiskon(domainObject.getDiskon())
                .setTotal(domainObject.getTotal())
                .setTanggalTransaksiPenjualan(domainObject.getTanggalTransaksiPenjualan())
                .setStatusTransaksi(domainObject.getStatusTransaksi())
                .setCatatan(domainObject.getCatatan())
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
                .setNamaBarang(dtoObject.getNamaBarang())
                .setKategoriPenjualan(dtoObject.getKategoriPenjualan())
                .setJenisPenjualan(dtoObject.getJenisPenjualan())
                .setJumlah(dtoObject.getJumlah())
                .setDiskon(dtoObject.getDiskon())
                .setTotal(dtoObject.getTotal())
                .setTanggalTransaksiPenjualan(dtoObject.getTanggalTransaksiPenjualan())
                .setStatusTransaksi(dtoObject.getStatusTransaksi())
                .setCatatan(dtoObject.getCatatan())
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
