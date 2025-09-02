package com.example.dragonwings.client;

import com.example.dragonwings.DragonWingsMod;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class DragonWingsFeatureRenderer extends FeatureRenderer<PlayerEntity, PlayerEntityModel<PlayerEntity>> {

    private static final Identifier WINGS_TEXTURE =
            new Identifier(DragonWingsMod.MOD_ID, "textures/entity/dragon_wings.png");

    private final ModelPart leftWing;
    private final ModelPart rightWing;

    public DragonWingsFeatureRenderer(FeatureRendererContext<PlayerEntity, PlayerEntityModel<PlayerEntity>> context) {
        super(context);

        // 簡単な羽パーツ（矩形2枚）
        this.leftWing = new ModelPart(List.of(ModelPartBuilder.create().uv(0,0).cuboid(-20,0,0,20,30,1)), Map.of());
        this.rightWing = new ModelPart(List.of(ModelPartBuilder.create().uv(0,0).cuboid(0,0,0,20,30,1)), Map.of());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
                       PlayerEntity player, float limbAngle, float limbDistance, float tickDelta,
                       float customAngle, float headYaw, float headPitch) {

        matrices.push();
        matrices.translate(0.0, 0.0, 0.1); // 背中に配置

        var vertexConsumer = vertexConsumers.getBuffer(getRenderLayer(WINGS_TEXTURE));

        leftWing.render(matrices, vertexConsumer, light, getOverlay(player));
        rightWing.render(matrices, vertexConsumer, light, getOverlay(player));

        matrices.pop();
    }
}
