package com.github.wilwe21.gsad.dash;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.Keybinds;
import com.github.wilwe21.gsad.GsadAttributes;
import com.github.wilwe21.gsad.block.custom.blockEntity.dream.DreamBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class DashClient {

    private static final double DASH_SPEED = 1.0;
    private static final double HYPER_H_SPEED = 3.0;
    private static final double HYPER_V_SPEED = 0.5;
    private static final double SUPER_H_SPEED = 0.8;
    private static final double SUPER_V_SPEED = 1.0;
    private static final double BOUNCE_H_SPEED = 0.8;
    private static final double BOUNCE_V_SPEED = 1.5;

    private static boolean isOnCooldown = false;

    private static int groundCooldown = 0;
    private static int dashCooldown = 0;
    private static int dashes = 0;

    private static Vec3d dashDirection = null;

    private static boolean willHyper = false;
    private static boolean willSuper = false;
    private static boolean willBounce = false;
    private static Direction bounceDirection = null;

    public static void tick() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;

        // Refresh number of dashes
        if (!(player.getWorld().getBlockState(player.getBlockPos()).getBlock() instanceof DreamBlock)) {
            DreamBlock.MULTI = false;
        }
        if (canRefresh(player) && groundCooldown == 0) {
            groundCooldown = 4;
            refresh(player);
        }

        groundCooldown--;
        if (groundCooldown < 0) groundCooldown = 0;

        // Hyper
        if (willHyper) {
            willHyper = false;
            Vec3d hyperMotion = new Vec3d(
                    player.getRotationVector().x * HYPER_H_SPEED,
                    HYPER_V_SPEED,
                    player.getRotationVector().z * HYPER_H_SPEED
            );
            player.setVelocity(hyperMotion);
            dashCooldown = 0;
        }
        // Super
        if (willSuper) {
            willSuper = false;
            Vec3d superMotion = new Vec3d(
                    player.getRotationVector().x * SUPER_H_SPEED,
                    SUPER_V_SPEED,
                    player.getRotationVector().z * SUPER_H_SPEED
            );
            player.setVelocity(superMotion);
            dashCooldown = 0;
        }
        // Wall Bounce
        if (willBounce) {
            willBounce = false;
            if (bounceDirection != null) {
                player.setVelocity(bounceDirection.getDoubleVector().x * BOUNCE_H_SPEED, BOUNCE_V_SPEED, bounceDirection.getDoubleVector().z * BOUNCE_H_SPEED);
            } else {
                player.setVelocity(0, BOUNCE_V_SPEED, 0);
            }
            dashCooldown = 0;
        }

        // During Dash
        Dash:
        if (dashCooldown > 0) {
            dashCooldown--;

            // End Dash
            if (dashCooldown == 0) {
                Dash.removeDashing(player.getUuid());
                break Dash;
            }

            player.setVelocity(dashDirection.multiply(DASH_SPEED));

        }

        isOnCooldown = dashCooldown > 0 || dashes == 0;

        // Here is when the dash happens
        if (Keybinds.DASH_KEY.isPressed() && !isOnCooldown()) {
            Dash.setDashing(player.getUuid());

            // Set counter to duration of dash
            dashCooldown = 5;
            // Decrement the dash counter
            dashes--;

            dashDirection = player.getRotationVector();
        }
    }

    public static void reset() {
        dashes = 0;
        isOnCooldown = false;
        dashCooldown = 0;
    }

    public static void refresh(ClientPlayerEntity player) {
        dashes = (short) player.getAttributeValue(GsadAttributes.DASH_LEVEL);
    }

    private static boolean canRefresh(ClientPlayerEntity player) {
        return player.isOnGround();
    }

    public static boolean isOnCooldown() {
        return isOnCooldown;
    }
}