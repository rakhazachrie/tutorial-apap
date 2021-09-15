package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam (value="id", required = true) String idKebunSafari,
            @RequestParam (value="nama", required = true) String namaKebunSafari,
            @RequestParam (value="alamat", required = true) String alamat,
            @RequestParam (value="noTelepon", required = true) String noTelepon,
            Model model
    ){
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        kebunSafariService.addKebunSafari(kebunSafari);

        model.addAttribute("kebunSafari", kebunSafari);

        return "add-kebun-safari";
    }
    @RequestMapping("/")
    public String listKebunSafari(Model model){
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
        model.addAttribute("listKebunSafari", listKebunSafari);
        return "get-all-kebun-safari";
    }
    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value="id", required = true) String idKebunSafari, Model model){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", kebunSafari);
        return "detail-kebun-safari";
    }
    // Latihan 1
    @RequestMapping("/kebun-safari/view/{idKebunSafari}")
    public String viewKebunSafariById(@PathVariable("idKebunSafari") String idKebunSafari, Model model){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", kebunSafari);
        if (kebunSafari == null){
            return "error-page";
        }
        return "detail-kebun-safari";
    }
    // Latihan 2
    @RequestMapping("/kebun-safari/update/{idKebunSafari}")
    public String updateTelpKebunSafari(@PathVariable("idKebunSafari") String idKebunSafari,
                                        @RequestParam(value="noTelepon", required=true) String noTelepon,
                                        Model model
    ){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        if (kebunSafari == null){
            return "error-page";
        }
        kebunSafari.setNoTelepon(noTelepon);
        model.addAttribute("kebunSafari", kebunSafari);
        return "update-no-telp-kebunSafari";
    }
    // Latihan 3
    @RequestMapping("/kebun-safari/delete/{idKebunSafari}")
    public String deleteKebunSafari(@PathVariable("idKebunSafari") String idKebunSafari, Model model){
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        if(kebunSafari == null){
            return "error-page";
        }
        model.addAttribute("kebunSafari", kebunSafari);
        for (int i=0; i<listKebunSafari.size(); i++){
            if(listKebunSafari.get(i).getIdKebunSafari().equals(kebunSafari.getIdKebunSafari())){
                listKebunSafari.remove(i);
                return "delete-kebun-safari";
            }
        }
        return "delete-kebun-safari";
    }


}
