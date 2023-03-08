package metier;

import dao.IDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modele.Credit;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditMetier implements IMetierCredit{
    IDao<Credit,Long> creditDao;
   @Override
    public Credit calculer_Mensualite(Long idCredit) throws Exception {
        var credit = creditDao.trouverParId(idCredit);
        if (credit == null) {
            throw new Exception("L'id du credit est incorrecte::[Credit non trouvé]");
        } else{
                double taux = credit.getTaux_Mensuel();
                taux = taux / 1200;
                double capitale = credit.getCapitale_emprunte();
                int nbr_Mois = credit.getNbr_mois();
                double mensualite = (capitale * taux) / (1 - (Math.pow((1 + taux), -1 * nbr_Mois)));
                mensualite = Math.round(mensualite * 100) / 100;
                credit.setMensualite(mensualite);
                return credit;
            }

        }
    }
