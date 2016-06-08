package main;

import controller.Controller;
import model.Model;
import view.View;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Controller control = new Controller(new View(), new Model()) ;
        control.run();
    }
}