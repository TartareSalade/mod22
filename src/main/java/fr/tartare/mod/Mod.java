package fr.tartare.mod;

import fr.tartare.mod.commands.modCommand;
import fr.tartare.mod.managers.EventsManager;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.invvk.actionbar.abstraction.AbstractActionBar;


import java.util.ArrayList;
import java.util.UUID;

public final class Mod extends JavaPlugin {

    private static Mod instance;

    public ArrayList<UUID> moderateurs = new ArrayList<>();
    @Override
    public void onEnable() {
        instance = this;

        new EventsManager().registers();
        getCommand("mod").setExecutor(new modCommand());
    }


    public static Mod getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin off");
    }


}
