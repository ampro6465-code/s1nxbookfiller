package com.s1nx.bookfiller.mixin.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.BookEditScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Random;

@Mixin(BookEditScreen.class)
public abstract class BookEditScreenMixin extends Screen {
    private static final int PAGE_COUNT = 100;
    private static final int CHARS_PER_PAGE = 256;
    private static final String RANDOM_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{};:,.<>/?";
    private static final Random RANDOM = new Random();

    @Shadow
    private List<String> pages;

    @Shadow
    private int currentPage;

    @Shadow
    private boolean dirty;

    @Shadow
    protected abstract void updateButtons();

    protected BookEditScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void s1nxbookfiller$addFillButton(CallbackInfo ci) {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Fill 100 Pages"), button -> this.s1nxbookfiller$fillBook())
                .dimensions(this.width / 2 - 100, 4, 200, 20)
                .build());
    }

    private void s1nxbookfiller$fillBook() {
        this.pages.clear();
        for (int page = 0; page < PAGE_COUNT; page++) {
            this.pages.add(s1nxbookfiller$randomPage());
        }

        this.currentPage = 0;
        this.dirty = true;
        this.updateButtons();
    }

    private static String s1nxbookfiller$randomPage() {
        StringBuilder builder = new StringBuilder(CHARS_PER_PAGE);
        for (int character = 0; character < CHARS_PER_PAGE; character++) {
            builder.append(RANDOM_CHARACTERS.charAt(RANDOM.nextInt(RANDOM_CHARACTERS.length())));
        }
        return builder.toString();
    }
}
