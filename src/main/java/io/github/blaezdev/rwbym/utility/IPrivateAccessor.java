/*
** 2016 Juni 19
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package io.github.blaezdev.rwbym.utility;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public interface IPrivateAccessor {
    
    Logger LOGGER = LogManager.getLogger();

    String[] ENTITYVILLAGER_WEALTH = new String[]{"wealth", "field_70956_bz"};
    
    default void setWealth(EntityVillager instance, int wealth) {
        try {
            ObfuscationReflectionHelper.setPrivateValue(EntityVillager.class, instance, wealth, ENTITYVILLAGER_WEALTH[1]);
        } catch (Exception ex) {
            LOGGER.error("setWealth() failed", ex);
        }
    }

    default int getWealth(EntityVillager instance) {
        try {
            return ObfuscationReflectionHelper.getPrivateValue(EntityVillager.class, instance, ENTITYVILLAGER_WEALTH[1]);
        } catch (Exception ex) {
            LOGGER.error("getWealth() failed", ex);
        }
        return 0;
    }
}
