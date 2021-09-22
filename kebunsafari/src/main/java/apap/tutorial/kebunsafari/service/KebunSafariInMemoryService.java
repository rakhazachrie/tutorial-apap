package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService {
    private List<KebunSafariModel> listKebunSafari;

    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList() {
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari) {
        KebunSafariModel temp = null;
        for(int i=0; i< listKebunSafari.size(); i++){
            String id = listKebunSafari.get(i).getIdKebunSafari();
            if(id.equals(idKebunSafari)){
                temp = listKebunSafari.get(i);
            }
        }
        return temp;
    }

}
