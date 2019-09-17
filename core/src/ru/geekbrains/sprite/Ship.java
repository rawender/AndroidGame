package ru.geekbrains.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.ExplosionPool;

public class Ship extends Sprite {

    protected Rect worldBounds;

    Vector2 v = new Vector2();
    Vector2 bulletV = new Vector2();
    float bulletHeight;

    BulletPool bulletPool;
    ExplosionPool explosionPool;
    TextureRegion[] bulletRegions;
    int damage;
    int hp;

    Sound shootSound;

    float reloadInterval;
    float reloadTimer;

    private float damageAnimateTimer;

    Ship() {
    }

    Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        this.pos.mulAdd(v, delta);
        damageAnimateTimer += delta;
        float damageAnimateInterval = 0.1f;
        if (damageAnimateTimer >= damageAnimateInterval) {
            frame = 0;
        }
    }

    public void damage(int damage) {
        frame = 1;
        damageAnimateTimer = 0f;
        hp -= damage;
        if (hp <= 0) {
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        boom();
    }

    void shoot() {
        Bullet bullets = bulletPool.obtain();
        bullets.set(this, bulletRegions, pos, bulletV, bulletHeight, worldBounds, damage);
        shootSound.play();
    }

    private void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(this.getHeight() * 2f, this.pos);
    }

    public int getHp() {
        return hp;
    }

    public Vector2 getV() {
        return v;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

