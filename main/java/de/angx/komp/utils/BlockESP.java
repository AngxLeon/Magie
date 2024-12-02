package de.angx.komp.utils;

import de.angx.komp.Main;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class BlockESP {

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (!Main.blockESPID.equals("")) {
            if (Main.blockESP) {
                for (int x = -40; x < 40; x++) {
                    for (int y = -90; y < 30; y++) {
                        for (int z = -40; z < 40; z++) {
                            BlockPos blockPos = new BlockPos(mc.thePlayer.posX + x, mc.thePlayer.posY + y, mc.thePlayer.posZ + z);
                            Block block = mc.theWorld.getBlockState(blockPos).getBlock();
                            int id = Integer.parseInt(Main.blockESPID);
                            Block block2 = Block.getBlockById(id);
                            if (block == block2) {
                                renderBlockOutline(blockPos);
                            }
                        }
                    }
                }
            }
        }
    }

    public void renderBlockOutline(BlockPos pos) {
        double x = pos.getX() - mc.getRenderManager().viewerPosX;
        double y = pos.getY() - mc.getRenderManager().viewerPosY;
        double z = pos.getZ() - mc.getRenderManager().viewerPosZ;
        AxisAlignedBB box = new AxisAlignedBB(x, y, z, x + 1, y + 1, z + 1);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.color(0.0F, 1.0F, 0.0F, 0.8F);
        for (int i = 0; i < 2; i++) {
            RenderGlobal.drawSelectionBoundingBox(box.expand(0.005 * i, 0.005 * i, 0.005 * i));
        }
        GlStateManager.color(0.0F, 1.0F, 0.0F, 0.3F);
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}
