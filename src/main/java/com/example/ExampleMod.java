package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.lwjgl.glfw.GLFW;

public class ExampleMod implements ModInitializer {
    public static boolean xrayEnabled = false;
    private static KeyBinding keyBinding;

    @Override
    public void onInitialize() {
        // Регистрация кнопки "X" для активации
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.xgen.xray", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_X, "category.xgen.mod"
        ));
    }
}
