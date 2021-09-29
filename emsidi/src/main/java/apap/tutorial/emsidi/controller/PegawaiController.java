package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;

@Controller
public class PegawaiController {

    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    CabangService cabangService;

    @GetMapping("pegawai/add/{noCabang}")
    public String addPegawaiForm(@PathVariable Long noCabang, Model model){
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("pegawai/add")
    public String addPegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ) {
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }

    @GetMapping("pegawai/update/{noPegawai}")
    public String updatePegawaiForm(
            @PathVariable Long noPegawai,
            Model model
    ) {
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        model.addAttribute("pegawai", pegawai);
        return "form-update-pegawai";
    }

    @PostMapping("pegawai/update")
    public String updatePegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ) {
        LocalTime timenow = LocalTime.now();
        CabangModel cabang = pegawai.getCabang();
        LocalTime waktuBuka = cabang.getWaktuBuka();
        LocalTime waktuTutup = cabang.getWaktuTutup();
        int val = timenow.compareTo(waktuBuka);
        int val2 = timenow.compareTo(waktuTutup);
        if(val < 0 || val2 > 0){
            pegawaiService.updatePegawai(pegawai);
            model.addAttribute("noPegawai", pegawai.getNoPegawai());
            return "update-cabang";

        }
        else {
            return "errorMsgUpdate";
        }

    }

    @GetMapping("pegawai/delete/{noPegawai}")
    public String deletePegawaiForm(
            @PathVariable Long noPegawai,
            Model model
    ){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        model.addAttribute("pegawai", pegawai);

        LocalTime timenow = LocalTime.now();
        CabangModel cabang = pegawai.getCabang();
        LocalTime waktuBuka = cabang.getWaktuBuka();
        LocalTime waktuTutup = cabang.getWaktuTutup();
        int val = timenow.compareTo(waktuBuka);
        int val2 = timenow.compareTo(waktuTutup);
        if(val < 0 || val2 > 0){
            pegawaiService.deletePegawai(pegawai);
            return "delete-pegawai";

        }
        else {
            return "errorMsgDelete";
        }

    }
}

