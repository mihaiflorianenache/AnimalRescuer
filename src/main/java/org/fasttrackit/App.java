package org.fasttrackit;

import java.io.IOException;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        Play play = new Play ();
        play.start ();
    }
}
