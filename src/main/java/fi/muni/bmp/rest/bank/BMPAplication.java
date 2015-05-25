/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.bmp.rest.bank;

import fi.muni.bmp.rest.socnet.Socnet;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author steveSK
 */
@ApplicationPath("/resources")
public class BMPAplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(BankResource.class);
        resources.add(Socnet.class);
        return resources;
    }
}
