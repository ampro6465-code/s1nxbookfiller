# s1nxBookFiller

A client-side Fabric mod for Minecraft 1.21.1.

When you open a **Book and Quill**, the edit screen gets a **Fill 100 Pages** button. Pressing it replaces the book contents with 100 pages of random characters, marks the book as changed, and leaves the normal Minecraft book screen to save/sync the data when you close or sign the book.

## Build

```bash
gradle build
```

The mod jar is generated at `build/libs/s1nxbookfiller-1.0.0.jar`.

> Note: this repository includes small compile-only stub classes under `src/stub/java` so the project can be built in environments where Fabric's Maven repository is blocked. Those stubs are not packaged into the final mod jar.
