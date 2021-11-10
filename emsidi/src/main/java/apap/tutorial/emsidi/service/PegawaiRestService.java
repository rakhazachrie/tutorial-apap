package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.List;

public interface PegawaiRestService {
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    List<PegawaiModel> retrieveListPegawai();
    PegawaiModel createPegawai(PegawaiModel pegawai);
    void deletePegawai(Long noPegawai);
    PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate);
}
