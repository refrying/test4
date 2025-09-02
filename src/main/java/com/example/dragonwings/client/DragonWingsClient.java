package com.example.dragonwings.client;

import com.example.dragonwings.DragonWingsMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.entity.EntityType;

public class DragonWingsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, renderer, helper) -> {
            if (entityType == EntityType.PLAYER) {
                renderer.addFeature(new DragonWingsFeatureRenderer(renderer));
            }
        });
    }
}
