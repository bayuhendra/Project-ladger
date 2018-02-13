/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.application.impl;

import com.ledger.common.application.finance.management.PembelianService;
import com.ledger.common.dto.finance.management.PembelianDTO;
import com.ledger.domain.financial.management.Pembelian;
import com.ledger.domain.financial.management.PembelianBuilder;
import com.ledger.domain.financial.management.PembelianRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.PembelianDTOAssembler;
import com.ledger.shared.status.StatusTransaksi;
import com.ledger.shared.type.JenisBarang;
import com.ledger.shared.type.Kategori;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class PembelianServiceImpl implements PembelianService {

    private PembelianDTOAssembler pembelianDTOAssembler;
    private PembelianRepository pembelianRepository;

    public void setPembelianDTOAssembler(PembelianDTOAssembler pembelianDTOAssembler) {
        this.pembelianDTOAssembler = pembelianDTOAssembler;
    }

    public void setPembelianRepository(PembelianRepository pembelianRepository) {
        this.pembelianRepository = pembelianRepository;
    }

    @Override
    public void SaveOrUpdate(PembelianDTO pembelian) {
        Pembelian t = pembelianRepository.findByID(pembelian.getPembelianID());

        if (t == null) {
            t = pembelianDTOAssembler.toDomain(pembelian);
        } else {
            Pembelian newPembelian = pembelianDTOAssembler.toDomain(pembelian);
            t.assignNewDataPembelian(newPembelian);

        }
        pembelianRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(PembelianDTO pembelian) {
        Pembelian p = pembelianDTOAssembler.toDomain(pembelian);
        pembelianRepository.deleteData(p);
    }

    @Override
    public PembelianDTO getDummyData() {
        Pembelian pembelian = new PembelianBuilder()
                .setPembelianID("C1")
                .setNamaBarang("aa")
                .setKategoriPembelian(Kategori.PEMBELIAN)
                .setJenisPembelian(JenisBarang.ELETRONIK)
                .setJumlah(12)
                .setDiskon(3)
                .setTotal(4)
                .setTanggalTransaksiPembelian(new Date())
                .setStatusTransaksi(StatusTransaksi.DONE)
                .setCatatan("catatan")
                .setCreatedBy("createdBy")
                .setCreatedDate(new Date())
                .setModifiedBy("aa")
                .setModifiedDate(new Date())
                .createPembelian();
        return pembelianDTOAssembler.toDTO(pembelian);
    }

    @Override
    public PembelianDTO findByID(String pembelianID) {
        Validate.notNull(pembelianRepository);
        Pembelian b = (Pembelian) pembelianRepository.findByID(pembelianID);
        if (b != null) {
            return pembelianDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<PembelianDTO> findAll() {
        Validate.notNull(pembelianRepository);
        return pembelianDTOAssembler.toDTOs(pembelianRepository.findAll());
    }

    @Override
    public List<PembelianDTO> findByParams(Map map) {
        Validate.notNull(pembelianRepository);
        List<Pembelian> listpembelian = pembelianRepository.findByParams(map);
        if (listpembelian != null) {
            return (List<PembelianDTO>) pembelianDTOAssembler.toDTOs(listpembelian);
        }
        return null;
    }

}
