package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Qualifier("menuServiceImpl")
    @Autowired
    private MenuService menuService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model) {
        List<String> temp = new ArrayList<>();
        temp.add(" ");
        List<MenuModel> allMenu = menuService.getListMenu();
        model.addAttribute("cabang", new CabangModel());
        model.addAttribute("allMenu", allMenu);
        model.addAttribute("temp", temp);

        return "form-add-cabang";
    }

    @GetMapping("/cabang/add/menu")
    public String addCabangForm(Model model, List<String> temp){
        List<MenuModel> allMenu = menuService.getListMenu();
        model.addAttribute("cabang", new CabangModel());
        model.addAttribute("allMenu", allMenu);
        model.addAttribute("temp", temp);

        return "form-add-cabang";
    }

    @GetMapping("/addmenu")
    public String addMenuCabang(
            @RequestParam(value="temp") List<String> temp, Model model
    ){
        temp.add(" ");
        return addCabangForm(model, temp);
    }

    @GetMapping("/removemenu")
    public String removeMenuCabang(
            @RequestParam(value="temp") List<String> temp, Model model
    ){
        temp.remove(temp.size() -1 );
        return addCabangForm(model, temp);
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.addCabang(cabang);
        List<MenuModel> allMenu = menuService.getListMenu();
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model) {
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value="noCabang") Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("listMenu", cabang.getListMenu());

        return "view-cabang";
    }

    @GetMapping("cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @GetMapping("/cabang/viewallbyname")
    public String listCabangByName(Model model) {
        List<CabangModel> listCabang = cabangService.getCabangListOrderByName();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("cabang/delete/{noCabang}")
    public String deleteCabangForm(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        LocalTime timenow = LocalTime.now();
        LocalTime waktuBuka = cabang.getWaktuBuka();
        LocalTime waktuTutup = cabang.getWaktuTutup();
        int val = timenow.compareTo(waktuBuka);
        int val2 = timenow.compareTo(waktuTutup);

        if((cabang.getListPegawai().size() == 0) && (val < 0 || val2 > 0)){
            model.addAttribute("cabang", cabang);
            cabangService.deleteCabang(cabang);
            return "delete-cabang";
        }
        else{
            return "errorMsgListNull";
        }

    }
}

