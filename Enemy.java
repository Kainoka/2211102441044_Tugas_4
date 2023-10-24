import greenfoot.*;

public class Enemy extends Actor {
    private int moveDistance = 5; // Jarak pergerakan musuh
    private int moveDirection = 1; // 1 berarti bergerak ke kanan, -1 berarti bergerak ke kiri
    private int currentFrame = 0; // Menyimpan frame animasi saat ini
    private GreenfootImage[] animationFrames; // Menyimpan semua frame animasi
    private int animationDelay = 10; // Atur penundaan animasi di sini

    public Enemy() {
        // Inisialisasi frame animasi
        animationFrames = new GreenfootImage[4]; // Ganti 4 dengan jumlah frame yang Anda miliki
        for (int i = 0; i < animationFrames.length; i++) {
            animationFrames[i] = new GreenfootImage("Bat" + i + ".png"); // Ganti "Bat" dengan prefix nama file gambar
        }
        setImage(animationFrames[currentFrame]);
    }

    public void act() {
        moveHorizontally();
        checkEdge();
        animate(); // Memanggil metode untuk mengatur animasi
    }

    public void moveHorizontally() {
        setLocation(getX() + (moveDirection * moveDistance), getY());
    }

    public void checkEdge() {
        if (isAtEdge()) {
            // Jika musuh mencapai tepi layar, balik arahnya
            moveDirection *= -1;
        }
    }

    public void animate() {
        if (currentFrame < animationFrames.length - 1) {
            currentFrame++;
        } else {
            currentFrame = 0;
        }
        setImage(animationFrames[currentFrame]);
        Greenfoot.delay(animationDelay); // Menambahkan penundaan untuk memperlambat animasi
    }
}
