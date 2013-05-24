package com.patrimonio.plantillas.server.dao;

import org.springframework.stereotype.Repository;

import com.patrimonio.plantillas.shared.Customer;

@Repository("customerDAO")
public class CustomerDao extends JpaDao<Long, Customer>{
        

}