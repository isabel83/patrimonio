package com.patrimonio.plantillas.server.dao;

import org.springframework.stereotype.Repository;

import com.patrimonio.plantillas.shared.User;

@Repository("userDAO")
public class UserDao extends JpaDao<Long, User>{
        

}