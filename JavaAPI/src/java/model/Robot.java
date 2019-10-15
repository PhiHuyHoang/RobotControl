package model;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author I352015
 */
public class Robot {
    int id;
    String name;

    public Robot(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public static List<Robot> robotList()
    {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Robot tempRobot = new Robot(i,"Robot number " + Integer.toString(i));
            robots.add(tempRobot);
        }
        return robots;
    }
}
