package net.chizutosuto.highlandherd.entity.client;

import net.chizutosuto.highlandherd.entity.custom.HighlandCowEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class HighlandCowModel<T extends HighlandCowEntity> extends SinglePartEntityModel<T> {
    private final ModelPart main;

    public HighlandCowModel(ModelPart root) {
        this.main = root.getChild("Main");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("chest",
                ModelPartBuilder.create().uv(0, 0)
                        .cuboid(-8.0F, -22.0F, -7.8F, 17.0F, 14.0F, 22.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 25.0F, 0.0F, 0, 0, 0));

        ModelPartData main = root.addChild("Main",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0F, 24.0F, 0.0F, 0, 0, 0));

        main.addChild("Head",
                ModelPartBuilder.create()
                        .uv(0, 37).cuboid(-10.0F, -25.0F, -28.0F, 9.0F, 9.0F, 7.0F)
                        .uv(54, 51).cuboid(-9.0F, -21.0F, -30.0F, 7.0F, 4.0F, 2.0F)
                        .uv(21, 62).cuboid(-1.0F, -22.0F, -25.2F, 3.0F, 2.0F, 2.0F)
                        .uv(21, 54).cuboid(2.0F, -27.0F, -25.2F, 2.0F, 5.0F, 2.0F),
                ModelTransform.of(6.0F, -2.0F, 13.2F, 0, 0, 0));

        main.addChild("Legs2",
                ModelPartBuilder.create()
                        .uv(33, 51).cuboid(-1.0F, -7.0F, 9.0F, 5.0F, 8.0F, 5.0F)
                        .uv(54, 37).cuboid(-1.0F, -7.0F, -4.0F, 5.0F, 8.0F, 5.0F)
                        .uv(33, 37).cuboid(9.0F, -7.0F, 9.0F, 5.0F, 8.0F, 5.0F)
                        .uv(0, 54).cuboid(9.0F, -7.0F, -4.0F, 5.0F, 8.0F, 5.0F),
                ModelTransform.of(-6.0F, -1.0F, -1.8F, 0, 0, 0));

        main.addChild("Head2",
                ModelPartBuilder.create()
                        .uv(63, 58).cuboid(-1.0F, -22.0F, -25.2F, 3.0F, 2.0F, 2.0F)
                        .uv(54, 58).cuboid(-3.0F, -27.0F, -25.2F, 2.0F, 5.0F, 2.0F),
                ModelTransform.of(-6.0F, -2.0F, 13.2F, 0, 0, 0));

        root.addChild("bb_main",
                ModelPartBuilder.create()
                        .uv(63, 63).cuboid(-1.0F, -4.0F, 25.0F, 2.0F, 2.0F, 2.0F),
                ModelTransform.of(0.0F, 24.0F, 0.0F, 0, 0, 0));

        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Animation logic here, e.g.:
        // main.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public ModelPart getPart() {
        return main;
    }
}
