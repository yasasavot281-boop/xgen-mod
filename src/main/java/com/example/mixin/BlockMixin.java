package com.example.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "shouldDrawSide", at = @At("HEAD"), cancellable = true)
    private static void onShouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos neighborPos, CallbackInfoReturnable<Boolean> info) {
        String name = state.getBlock().getTranslationKey();
        
        // Список всех руд и ценностей 1.21.4
        boolean isOre = name.contains("ore") // Все обычные руды
            || name.contains("debris")       // Древние обломки (Незерит)
            || name.contains("raw")          // Блоки необработанного железа/меди/золота
            || name.contains("emerald")      // Изумруды
            || name.contains("diamond")      // Алмазы
            || name.contains("coal")         // Уголь
            || name.contains("lapis")        // Лазурит
            || name.contains("redstone")     // Редстоун
            || name.contains("gilded")       // Позолоченный чернит
            || name.contains("chest")        // Сундуки (чтобы видеть лут)
            || name.contains("spawner");     // Спавнеры

        if (!isOre) {
            info.setReturnValue(false); // Прячем всё остальное (камень, землю, гравий)
        }
    }
}
