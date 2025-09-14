package io.papermc.paper.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NullMarked;

/**
 * PlayerTeleportFailEvent
 * A fallback event which is fired when the player.teleport() function is ran but the PlayerTeleportEvent is not fired.
 */
@NullMarked
public class PlayerTeleportFailEvent extends PlayerEvent {

    // The reason why the teleport failed.
    public enum FailReason {
        PLAYER_IS_VEHICLE,
        PLAYER_IS_PASSENGER,
        OTHER;
    }

    private static final HandlerList HANDLER_LIST = new HandlerList();
    private Location to;
    private FailReason reason;

    @ApiStatus.Internal
    public PlayerTeleportFailEvent(@NotNull Player player, @NotNull Location to, io.papermc.paper.event.player.PlayerTeleportFailEvent.FailReason reason) {
        super(player);
        this.to = to;
        this.reason = reason;
    }

    /**
     * @return Returns the location the player is currently at
     */
    public Location getFrom() {
        return this.getPlayer().getLocation();
    }

    /**
     * @return Returns the location the player is trying to be teleported to
     */
    public Location getTo() {
        return this.to;
    }

    /**
     * @return Returns the reason why the teleport failed
     */
    public io.papermc.paper.event.player.PlayerTeleportFailEvent.FailReason getReason() {
        return this.reason;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

}
