package fr.tartare.mod.commands;

import fr.tartare.mod.Mod;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class modCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Tu dois être un joueur pour faire cette commande !");
        }

        Player player = (Player) sender;

        if(Mod.getInstance().moderateurs.contains(player.getUniqueId())){
            Mod.getInstance().moderateurs.remove(player.getUniqueId());
            player.getInventory().clear();
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Vous avez quitté le mode modération");
            /*
            TODO inv
             */
            return false;
        }
        Mod.getInstance().moderateurs.add(player.getUniqueId());
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Vous êtes en mode modérateur");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.LIGHT_PURPLE+ "Vous êtes en mode modérateur"));
        // Trouver une bonne api pour action bar
        /*
        TODO inv save
         */

        return false;
    }
}
