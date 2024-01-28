package com.voiture.voiture.connex;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConnex()throws Exception{
      Class.forName("org.postgresql.Driver");
      Connection co= DriverManager.getConnection("jdbc:postgresql://monorail.proxy.rlwy.net:31451/ventevoiture","postgres","G*cFA6E2cbea12A555233df316ffg3F4");
      return co;
}

}