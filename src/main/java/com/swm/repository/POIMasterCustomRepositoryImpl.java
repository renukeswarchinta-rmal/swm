package com.swm.repository;

import com.swm.entity.City;
import com.swm.entity.POIMaster;
import com.swm.entity.WardMaster;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class POIMasterCustomRepositoryImpl implements  POIMasterCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<POIMaster> searchByAllFields(String ownerName, String holding_no, String plot_no, String
                                             guardian_name, String mobile_number, String property_address,
                                             String cityName, String pinCode, String rfId, String qrCode,
                                             String wardNumber,Integer pageNo,Integer pageSize) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<POIMaster> poiMasterCriteriaQuery = cb.createQuery(POIMaster.class);
        Root<POIMaster> poiMasterRoot = poiMasterCriteriaQuery.from(POIMaster.class);
        List<Predicate> predicates = new ArrayList<>();

        if(ownerName != null){
            predicates.add(cb.like(poiMasterRoot.get("owner_name"), "%" + ownerName + "%"));
        }
        if(holding_no != null){
            predicates.add(cb.like(poiMasterRoot.get("holding_no"), "%" + holding_no + "%"));
        }
        if(plot_no != null){
            predicates.add(cb.like(poiMasterRoot.get("plot_no"), "%" + plot_no + "%"));
        }
        if(guardian_name != null){
            predicates.add(cb.like(poiMasterRoot.get("guardian_name"), "%" + guardian_name + "%"));
        }
        if(rfId != null){
            predicates.add(cb.like(poiMasterRoot.get("rfId"), "%" + rfId + "%"));
        }
        if(qrCode != null){
            predicates.add(cb.like(poiMasterRoot.get("qrCode"), "%" + qrCode + "%"));
        }
        if(mobile_number != null){
            predicates.add(cb.like(poiMasterRoot.get("mobile_number"), "%" + mobile_number + "%"));
        }
        Join<POIMaster, WardMaster> wardMaster = poiMasterRoot.join("wardMaster");
        if(wardNumber != null){
            predicates.add(cb.equal(wardMaster.get("wardNumber"), wardNumber ));
        }
        Join<POIMaster, City> city = poiMasterRoot.join("city");

        if(cityName != null){
            predicates.add(cb.equal(city.get("id"), cityName ));
        }
        poiMasterCriteriaQuery.select(poiMasterRoot)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        //poiMasterCriteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        TypedQuery<POIMaster> typedQuery = entityManager.createQuery(poiMasterCriteriaQuery);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(pageSize);

        return typedQuery.getResultList();


    }

    private void addRestrictionIfNotNull(Criteria criteria, String propertyName, Object value) {
        if (value != null) {
            criteria.add(Restrictions.eq(propertyName, value));
        }
    }
}
