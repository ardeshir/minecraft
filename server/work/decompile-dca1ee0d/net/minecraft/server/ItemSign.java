package net.minecraft.server;

import javax.annotation.Nullable;

public class ItemSign extends ItemBlockWallable {

    public ItemSign(Item.Info item_info) {
        super(Blocks.SIGN, Blocks.WALL_SIGN, item_info);
    }

    protected boolean a(BlockPosition blockposition, World world, @Nullable EntityHuman entityhuman, ItemStack itemstack, IBlockData iblockdata) {
        boolean flag = super.a(blockposition, world, entityhuman, itemstack, iblockdata);

        if (!world.isClientSide && !flag && entityhuman != null) {
            entityhuman.openSign((TileEntitySign) world.getTileEntity(blockposition));
        }

        return flag;
    }
}