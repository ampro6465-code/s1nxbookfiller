package net.minecraft.client.gui.widget;

import net.minecraft.text.Text;

import java.util.function.Consumer;

public class ButtonWidget {
    public static Builder builder(Text message, Consumer<ButtonWidget> onPress) { return new Builder(); }

    public static class Builder {
        public Builder dimensions(int x, int y, int width, int height) { return this; }
        public ButtonWidget build() { return new ButtonWidget(); }
    }
}
