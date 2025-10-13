package org.jcr;
import org.jcr.dbManager.DbManager;
import org.jcr.entities.Persona;
import org.jcr.entities.Sucursal;


public class Main {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        dbManager.getEntityManager();

        Persona p1 = dbManager.searchById(Persona.class,1D);
        p1.setEdadPersona(20);
        p1.setNombrePersona("Ignacio Wuilloud");

        dbManager.insert(p1);
        System.out.println("Persona 1: "+p1.getNombrePersona());

        Sucursal s1 = new Sucursal();
        s1.setNombre("Sucursal 1");
        s1.addTrabajador(p1);
        dbManager.insert(s1);
        System.out.println("Sucursal agregada");

        dbManager.close();
    }
}