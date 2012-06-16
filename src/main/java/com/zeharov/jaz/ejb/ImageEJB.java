package com.zeharov.jaz.ejb;

import com.zeharov.jaz.domain.Image;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Named
public class ImageEJB {
    
    @PersistenceContext(unitName = "com.zeharov.jaz_Zeharov_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;
    
    public void delete(Image image) {
        image = em.merge(image);
        em.remove(image);
    }
 
    public void persist(Image image) {
        em.merge(image);
    }
    
    public List<Image> getImages() {
        return em.createQuery("select img from Image img").getResultList();
    }
}
