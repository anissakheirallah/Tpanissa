package dao.daoVolatile;

import dao.IDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modele.Credit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor

public class CreditDao implements IDao<Credit,Long> {

    public static Set<Credit> BDCredits(){
        return new HashSet<Credit>(
                Arrays.asList(
                new Credit( 1L,30000.0,120,
                        2.5,"Amine",0.0),
                new Credit(2L,850000.0,240,
                        2.5,"Tarek",0.0),
                new Credit(3L,020000.0,830,
                        1.5,"Sarah",0.0),
                new Credit(4L,065000.0,860,
                        2.0,"Anissa",0.0)
        ));
    }
    @Override
    public Credit trouverParId(Long id){
        System.out.println("[DAO- DS volatile] trouver le Credit n:"+id);
        return  BDCredits()
                .stream()
                .filter(credit -> credit.getId()==id)
                .findFirst()
                .orElse(null);
    }


}
