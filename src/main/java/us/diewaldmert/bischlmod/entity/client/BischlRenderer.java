package us.diewaldmert.bischlmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import us.diewaldmert.bischlmod.BischlMod;
import us.diewaldmert.bischlmod.entity.custom.BischlEntity;

public class BischlRenderer extends MobEntityRenderer<BischlEntity, BischlModel<BischlEntity>> {
    private static final Identifier TEXTURE = new Identifier(BischlMod.MOD_ID, "textures/entity/bischl.png");

    public BischlRenderer(EntityRendererFactory.Context context) {
        super(context, new BischlModel<>(context.getPart(ModModelLayers.BISCHL)), 0.6f);
    }

    @Override
    public Identifier getTexture(BischlEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BischlEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1.5f, 1.5f, 1.5f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
