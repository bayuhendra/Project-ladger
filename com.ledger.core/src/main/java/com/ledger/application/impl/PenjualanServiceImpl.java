/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.application.impl;

import com.ledger.common.application.finance.management.PenjualanService;
import com.ledger.common.dto.finance.management.PenjualanDTO;
import com.ledger.domain.financial.management.Penjualan;
import com.ledger.domain.financial.management.PenjualanBuilder;
import com.ledger.domain.financial.management.PenjualanRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.PenjualanDTOAssembler;
import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.Jenis;
import com.ledger.shared.type.Kategori;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class PenjualanServiceImpl implements PenjualanService {

    private PenjualanDTOAssembler penjualanDTOAssembler;
    private PenjualanRepository penjualanRepository;

    public void setPenjualanDTOAssembler(PenjualanDTOAssembler penjualanDTOAssembler) {
        this.penjualanDTOAssembler = penjualanDTOAssembler;
    }

    public void setPenjualanRepository(PenjualanRepository penjualanRepository) {
        this.penjualanRepository = penjualanRepository;
    }

    @Override
    public void SaveOrUpdate(PenjualanDTO penjualan) {
        Penjualan t = penjualanRepository.findByID(penjualan.getPenjualanID());

        if (t == null) {
            t = penjualanDTOAssembler.toDomain(penjualan);
        } else {
            Penjualan newPenjualan = penjualanDTOAssembler.toDomain(penjualan);
            t.assignNewDataPenjualan(newPenjualan);

        }
        penjualanRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(PenjualanDTO penjualan) {
        Penjualan p = penjualanDTOAssembler.toDomain(penjualan);
        penjualanRepository.deleteData(p);
    }

    @Override
    public PenjualanDTO getDummyData() {
        Penjualan penjualan = new PenjualanBuilder()
                .setPenjualanID("C1")
                .setNamaBarang("aa")
                .setKategoriPenjualan(Kategori.KATEGORI1)
                .setJenisPenjualan(Jenis.JENIS1)
                .setJumlah(12)
                .setDiskon(3)
                .setTotal(4)
                .setTanggalTransaksiPenjualan(new Date())
                .setStatusTransaksi(StatusTransaksi.STATUS1)
                .setCatatan("catatan")
                .setCreatedBy("createdBy")
                .setCreatedDate(new Date())
                .setModifiedBy("aa")
                .setModifiedDate(new Date())
                .createPenjualan();
        return penjualanDTOAssembler.toDTO(penjualan);
    }

    @Override
    public PenjualanDTO findByID(String penjualanID) {
        Validate.notNull(penjualanRepository);
        Penjualan b = (Penjualan) penjualanRepository.findByID(penjualanID);
        if (b != null) {
            return penjualanDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<PenjualanDTO> findAll() {
        Validate.notNull(penjualanRepository);
        return penjualanDTOAssembler.toDTOs(penjualanRepository.findAll());
    }

    @Override
    public List<PenjualanDTO> findByParams(Map map) {
        Validate.notNull(penjualanRepository);
        List<Penjualan> listpenjualan = penjualanRepository.findByParams(map);
        if (listpenjualan != null) {
            return (List<PenjualanDTO>) penjualanDTOAssembler.toDTOs(listpenjualan);
        }
        return null;
    }

}