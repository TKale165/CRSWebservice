package com.project.webservice.crs.repository.impl;

import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.repository.CustomerRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CustomerRepoImpl implements CustomerRepo {
    @Autowired
    EntityManager entityManager;


    @Override
    public CustomerReg getCustByRegNum(String ppsn) {

        CustomerReg customerReg= entityManager.find(CustomerReg.class,ppsn);
        return customerReg;
    }


    public void  deleteCustByRegNum(String ppsn) {

        CustomerReg customerReg=entityManager.find(CustomerReg.class,ppsn);
        entityManager.remove(customerReg);
    }

    public void  saveCustByRegNum(CustomerReg customerReg) {


        entityManager.merge(customerReg);
    }
}
