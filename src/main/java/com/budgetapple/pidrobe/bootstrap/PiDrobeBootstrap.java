package com.budgetapple.pidrobe.bootstrap;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.bootstrap.core.CategoryBootstrap;
import com.budgetapple.pidrobe.bootstrap.core.ItemBootstrap;
import com.budgetapple.pidrobe.core.utils.IO;


import java.io.IOException;

/**
 * Created by Miguel Cardoso on 10/09/2017.
 */
public class PiDrobeBootstrap {
    public static void main(String[] args) {
        System.out.println("Bootstrapping Demo application 2016(c) data");

        new PiDrobeBootstrap().execute();

        try {
            IO.writeToBinFile("PiDrobe", PiDrobe.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void execute() {
        new CategoryBootstrap();
        new ItemBootstrap();
    }
}
