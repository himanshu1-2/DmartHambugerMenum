
package com.example.dmarthambugermenu.model;

import com.google.gson.annotations.Expose;



public class MenuDynamicsObject {

    @Expose
    private HamburgerMenu hamburgerMenu;

    public HamburgerMenu getHamburgerMenu() {
        return hamburgerMenu;
    }

    public void setHamburgerMenu(HamburgerMenu hamburgerMenu) {
        this.hamburgerMenu = hamburgerMenu;
    }

}
