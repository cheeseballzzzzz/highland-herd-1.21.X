package net.chizutosuto.highlandherd.entity.client;


import net.chizutosuto.highlandherd.HighlandHerd;
import net.chizutosuto.highlandherd.entity.custom.HighlandCowEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;


// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
    public class HighlandCowModel extends EntityModel<HighlandCowEntity>
{

        public static final EntityModelLayer HIGHLAND_COW = new EntityModelLayer(Identifier.of(HighlandHerd.MOD_ID, "highland_cow"), "main");


        private final ModelPart Cow;
        private final ModelPart Head;



        public HighlandCowModel(ModelPart root) {
            this.Cow = root.getChild("Cow");
            this.Head = this.Cow.getChild("Head");
        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData Cow = modelPartData.addChild("Cow", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

            ModelPartData Head = Cow.addChild("Head", ModelPartBuilder.create().uv(0, 37).cuboid(-10.0F, -25.0F, -28.0F, 9.0F, 9.0F, 7.0F, new Dilation(0.0F))
                    .uv(54, 51).cuboid(-9.0F, -21.0F, -30.0F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F))
                    .uv(21, 62).cuboid(-1.0F, -22.0F, -25.2F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(21, 54).cuboid(2.0F, -27.0F, -25.2F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -1.0F, 13.2F));

            ModelPartData Legs2 = Cow.addChild("Legs2", ModelPartBuilder.create().uv(54, 37).cuboid(-1.0F, -7.0F, -4.0F, 5.0F, 8.0F, 5.0F, new Dilation(0.0F))
                    .uv(33, 37).cuboid(9.0F, -7.0F, 9.0F, 5.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -1.0F, -1.8F));

            ModelPartData Head2 = Cow.addChild("Head2", ModelPartBuilder.create().uv(63, 58).cuboid(-1.0F, -22.0F, -25.2F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(54, 58).cuboid(-3.0F, -27.0F, -25.2F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -2.0F, 13.2F));

            ModelPartData Legs1 = Cow.addChild("Legs1", ModelPartBuilder.create().uv(33, 51).cuboid(-7.0F, -8.0F, 7.2F, 5.0F, 8.0F, 5.0F, new Dilation(0.0F))
                    .uv(0, 54).cuboid(3.0F, -8.0F, -5.8F, 5.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData chest = Cow.addChild("chest", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -22.0F, -7.8F, 17.0F, 14.0F, 22.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));
            return TexturedModelData.of(modelData, 128, 128);
        }
        @Override
        public void setAngles(HighlandCowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        }
        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
            Cow.render(matrices, vertexConsumer, light, overlay, color);
        }

        @Override
        public ModelPart getPart() {
            return Cow;
        }
    }

