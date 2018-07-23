package com.ngdroidapp;

import android.graphics.Canvas;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;

/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */

public class MenuCanvas extends BaseCanvas {

    public MenuCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        android.util.Log.i("MenuCanvas", "setup: ");
    }

    public void update() {
        GameCanvas mc = new GameCanvas(root);
        root.canvasManager.setCurrentCanvas(mc);
    }

    public void draw(Canvas canvas) {
    }

    public void keyPressed(int key) {
    }

    public void keyReleased(int key) {
    }

    public boolean backPressed() {
        return false;
    }

    public void touchDown(int x, int y, int id) {
    }

    public void touchMove(int x, int y, int id) {
    }

    public void touchUp(int x, int y, int id) {
    }

    public void surfaceChanged(int width, int height) {
    }

    public void surfaceCreated() {
    }

    public void surfaceDestroyed() {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void reloadTextures() {
    }

    public void showNotify() {
    }

    public void hideNotify() {
    }

}
