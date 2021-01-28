package com.swm.repository;

import com.swm.entity.POIMaster;
import com.swm.entity.WardMaster;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
                                             String wardNumber) {
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

        poiMasterCriteriaQuery.select(poiMasterRoot)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        //poiMasterCriteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(poiMasterCriteriaQuery).getResultList();


    }

    private void addRestrictionIfNotNull(Criteria criteria, String propertyName, Object value) {
        if (value != null) {
            criteria.add(Restrictions.eq(propertyName, value));
        }
    }
}
