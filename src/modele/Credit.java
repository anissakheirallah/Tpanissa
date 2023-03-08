package modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
    private  Long id;
    private Double capitale_emprunte;
    private Integer nbr_mois;
    private Double taux_Mensuel;
    private String nom_demandeur;
    private Double mensualite;
@Override
public String toString(){
    var creditStr="=============================================================\n";
        creditStr+= "=>Crédit n "+getId()+"                                     \n";
        creditStr+= "=>Nom du demandeur de crédit : "+getNom_demandeur()+"       \n";
        creditStr+="=============================================================\n";
        creditStr+=" =>Capitale Emprinté    :"+getCapitale_emprunte()+"DH        \n";
        creditStr+=" =>Nombre de mois         :"+getNbr_mois()+" mois            \n";
        creditStr+=" =>Taux mensual           :"+getTaux_Mensuel()+"%            \n";
        creditStr+="=============================================================\n";
        creditStr+="=>Mensualité         :"+(getMensualite()==0.0?
                                     "NON-CALCULE":getMensualite()+"Dh/mois")+ "\n";
       creditStr+="=============================================================\n";
       return creditStr;
}
}
