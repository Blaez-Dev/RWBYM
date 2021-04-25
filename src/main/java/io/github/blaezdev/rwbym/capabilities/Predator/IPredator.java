package io.github.blaezdev.rwbym.capabilities.Predator;

import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nullable;

public interface IPredator
{
    int getKills();

    /**
     * Sets the player's kill count of predator perk
     * @param player the player to set, the data will be synced if
     *               it is not null
     * @param amount the amount of kills to set
     */
    void setKills(@Nullable EntityPlayer player, int amount);

    /**
     * Increment on the player's kill count of predator perk
     * @param player the player to set, the data will be synced if
     *               it is not null
     */
    void increaseKills(@Nullable EntityPlayer player);

    /**
     * Increase on the player's kill count of predator perk
     * @param player the player to set, the data will be synced if
     *               it is not null
     * @param amount the amount of kills to increase
     */
    void increaseKills(@Nullable EntityPlayer player, int amount);

    /**
     * Gets the damage multiplier of the player based
     * on the kills of the predator perk
     * Default 3x damage per 10k take downs
     */
    float getBonusDamageMultiplier();
}
