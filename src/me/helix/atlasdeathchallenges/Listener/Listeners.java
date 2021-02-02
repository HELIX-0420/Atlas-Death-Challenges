package me.helix.atlasdeathchallenges.Listener;

import me.helix.atlasdeathchallenges.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Listeners implements Listener {

    private Main main;
    public Listeners (Main main) {
        this.main = main;
    }

    public ArrayList<String> list = new ArrayList<String>();

    @EventHandler
    public void ReSpawn(PlayerRespawnEvent e) {
        Player p = (Player) e.getPlayer();

        //Random Challenge Generator (List)
        List RandomChallange = new ArrayList();
        for (String Challenges : main.getConfig().getStringList("ChallengeList")) {
            RandomChallange.add(Challenges);
        }

        Random r = new Random();
        //Sends Message on Players Screen
        final String message = (String) RandomChallange.get(r.nextInt(RandomChallange.size()));
        p.sendTitle(Main.color(main.getConfig().getString("Messages.ChallengeTitle")), Main.color(main.getConfig().getString("Messages.RandomList")).replace("%RandomList%",message), 10,90,10);
        p.getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 10, 10);
        //Sends to the Rest of the Server
        Bukkit.getServer().broadcastMessage(Main.color(main.getConfig().getString("Messages.ChallengeToServer").replace("%RandomList%", message).replace("%Player%", p.getDisplayName())));
    }

}
