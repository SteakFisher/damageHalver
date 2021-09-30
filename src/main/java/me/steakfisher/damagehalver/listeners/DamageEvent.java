package me.steakfisher.damagehalver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;



public class DamageEvent implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        EntityType damagedPlayer = event.getEntityType();
        if (damagedPlayer == EntityType.PLAYER){

            double playerDamage = event.getDamage();
            playerDamage/=2;

            for(Player players : Bukkit.getServer().getOnlinePlayers()) {

                double blockedDamage = players.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD);
                blockedDamage*=2;
                playerDamage = playerDamage - blockedDamage;
                double playerHealth = players.getHealth();
                double newHealth = playerHealth - playerDamage;
                if(newHealth < 0){
                    players.setHealth(0);
                }else {
                    players.setHealth(newHealth);
                }
                event.setDamage(0);

            }

        }
    }

}
