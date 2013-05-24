package com.patrimonio.plantillas.server;


public class InfoServiceImpl {
//  @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
    public String helloWorld(String name) {

            System.out.println("InfoServiceImpl => helloWorld()");
            
            return name + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }

}
