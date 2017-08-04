package org.bukkit.event.entity;

import java.util.Map;

import com.google.common.base.Function;
import org.bukkit.entity.Entity;
import org.bukkit.event.EntityAction;

/**
 * Called when an entity is damaged by an entity
 */
public class EntityDamageByEntityEvent extends EntityDamageEvent implements EntityAction {
    private final Entity damager;

    @Deprecated
    public EntityDamageByEntityEvent(final Entity damager, final Entity damagee, final DamageCause cause, final double damage) {
        super(damagee, cause, damage);
        this.damager = damager;
    }

    public EntityDamageByEntityEvent(final Entity damager, final Entity damagee, final DamageCause cause, final Map<DamageModifier, Double> modifiers, final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        super(damagee, cause, modifiers, modifierFunctions);
        this.damager = damager;
    }

    /**
     * Returns the entity that damaged the defender.
     *
     * @return Entity that damaged the defender.
     */
    public Entity getDamager() {
        return damager;
    }

    @Override
    public Entity getActor() {
        return getDamager();
    }
}
