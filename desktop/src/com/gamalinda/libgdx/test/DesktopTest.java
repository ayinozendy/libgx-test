package com.gamalinda.libgdx.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopTest {
    public static void main( String[] args ) {
        LwjglApplicationConfiguration cf = new LwjglApplicationConfiguration();
        cf.title = "Libgdx Test - Desktop";
        cf.useGL20 = true;
        cf.width = 800;
        cf.height = 480;
        cf.resizable = false;

        new LwjglApplication( new MainApp(), cf );
    }
}