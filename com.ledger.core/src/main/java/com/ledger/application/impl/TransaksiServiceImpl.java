package com.ledger.application.impl;

import com.ledger.common.application.finance.management.TransaksiService;
import com.ledger.common.dto.finance.management.TransaksiDTO;
import com.ledger.domain.financial.management.Transaksi;
import com.ledger.domain.financial.management.TransaksiBuilder;
import com.ledger.domain.financial.management.TransaksiRepository;
import com.ledger.interfaces.web.facade.dto.assembler.finance.management.TransaksiDTOAssembler;
import com.ledger.shared.type.Kategori;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class TransaksiServiceImpl implements TransaksiService {

    private TransaksiDTOAssembler transaksiDTOAssembler;
    private TransaksiRepository transaksiRepository;

    public void setTransaksiDTOAssembler(TransaksiDTOAssembler transaksiDTOAssembler) {
        this.transaksiDTOAssembler = transaksiDTOAssembler;
    }

    public void setTransaksiRepository(TransaksiRepository transaksiRepository) {
        this.transaksiRepository = transaksiRepository;
    }

    @Override
    public void SaveOrUpdate(TransaksiDTO transaksi) {
        Transaksi t = transaksiRepository.findByID(transaksi.getTransaksiID());

        if (t == null) {
            t = transaksiDTOAssembler.toDomain(transaksi);
        } else {
            Transaksi newTransaksi = transaksiDTOAssembler.toDomain(transaksi);
            t.assignNewDataTransaksi(newTransaksi);

        }
        transaksiRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(TransaksiDTO transaksi) {
        Transaksi p = transaksiDTOAssembler.toDomain(transaksi);
        transaksiRepository.deleteData(p);
    }

    @Override
    public TransaksiDTO getDummyData() {
        Transaksi transaksi = new TransaksiBuilder()
                //                .setTransaksiID("TRANSAKSI001")
                //                .setNamaProduk("TANAH")
                //                .setKategoriTransaksi(Kategori.PEMBELIAN)
                //                .setJenisBarang("NON ELEKTRONIK")
                //                .setHarga(12000)
                //                .setDiskon(3)
                //                .setTotal(4)
                //                .setTanggalTransaksi(new Date())
                //                .setStatusTransaksi("DONE")
                //                .setJenisPembayaran("KREDIT")
                //                .setDeskripsi("catatan")
                //                .setCreatedBy("SYSTEM")
                //                .setCreatedDate(new Date())
                //                .setModifiedBy("SYSTEM")
                //                .setModifiedDate(new Date())
                .createTransaksi();
        return transaksiDTOAssembler.toDTO(transaksi);
    }

    @Override
    public TransaksiDTO findByID(String transaksiID) {
        Validate.notNull(transaksiRepository);
        Transaksi b = (Transaksi) transaksiRepository.findByID(transaksiID);
        if (b != null) {
            return transaksiDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<TransaksiDTO> findAll() {
        Validate.notNull(transaksiRepository);
        return transaksiDTOAssembler.toDTOs(transaksiRepository.findAll());
    }

    @Override
    public List<TransaksiDTO> findByParams(Map map) {
        Validate.notNull(transaksiRepository);
        List<Transaksi> listTransaksi = transaksiRepository.findByParams(map);
        if (listTransaksi != null) {
            return (List<TransaksiDTO>) transaksiDTOAssembler.toDTOs(listTransaksi);
        }
        return null;
    }

    @Override
    public List<TransaksiDTO> findByUserID(String userID) {
        Validate.notNull(transaksiRepository);
        List<Transaksi> listTransaksi = transaksiRepository.findByUserID(userID);
        if (listTransaksi != null) {
            return (List<TransaksiDTO>) transaksiDTOAssembler.toDTOs(listTransaksi);
        }
        return null;
    }

}
