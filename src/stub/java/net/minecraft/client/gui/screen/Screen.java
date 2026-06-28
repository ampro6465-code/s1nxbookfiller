package net.minecraft.client.gui.screen;

import net.minecraft.text.Text;

public class Screen {
    protected int width;
    protected int height;

    protected Screen(Text title) {}

    protected <T> T addDrawableChild(T drawableElement) { return drawableElement; }
}
