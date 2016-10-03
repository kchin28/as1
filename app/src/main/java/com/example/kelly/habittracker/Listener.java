package com.example.kelly.habittracker;
/*
* Copyright (C) 2014 Abram Hindle abram.hindle@softwareprocess.ca
* Modified by : Kelly Chin, 2016
*
* An Interface to allow updates for consistent and dynamic/instant update of lists.
* No class in the project implements interface, it is solely used through anonymous classes
* */
public interface Listener {
    public void update();
}
