package ru.words;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fourth_Screen implements  Screen{
    button btn;
    button btn2;
    button btn3;
    button btn4;
    button btn5;
    button btn6;
    Main main;
    private Texture d12,bk,book,box;
    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;
    String img;
    public int volumes;
    private KeyBoard keyboard;
    BitmapFont font70;
    String text,word;
    int times = 6;
    public List<String> myList,ifn;

    public Music oiia;
    public fourth_Screen(Main main){
        this.main = main;
        
        font70 = new BitmapFont(Gdx.files.internal("stylo90gray.fnt"));
        keyboard = new KeyBoard(font70, 900, 900, 9);
        volumes = main.volume;
        oiia = main.cl;
        myList = new ArrayList<>();
        word = main.word;
        text = main.word;
        batch = main.batch;
        camera = main.camera;
        touch = main.touch;
        font = main.font;
        btn6 = new button(font,"Назад",0,1600);
        btn = new button(font,"second_screen",150,1000);
        btn2 = new button(font,"first_screen",150,1300);
        btn3 = new button(font,"third_screen",150,700);
        btn4 = new button(font,"fourth_screen",150,400);
        d12 = new Texture("bg.jpg");
        box = new Texture("box.png");
        bk = new Texture("back.png");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(touch);
            if(touch.y> 1500 && touch.y < 1600 && touch.x > 0 && touch.x < 100){
                oiia.play();
                oiia.setVolume(((float)(main.volume)/9)/ 100);
                myList = ifn;
                times = 6;
                main.setScreen(main.justScreen);
            }

        }
        batch.setProjectionMatrix(camera.combined);
        keyboard.start();
        batch.begin();

        batch.draw(d12,0,0,900,1600);

        batch.draw(bk,0,1500,100,100);
        keyboard.draw(batch);
        if  (Gdx.input.justTouched()){
            if (keyboard.touch(touch.x, touch.y)){
                text = keyboard.getEnglishText().toUpperCase();
                keyboard.zeroText();
                times -= 1;
                myList.add(text);

            }
        }



        if (myList != ifn){
            for (int i = 0; i < myList.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (myList.get(i).charAt(j) == main.word.charAt(j)){
                        img = "green.png";
                        book = new Texture(img);
                        batch.draw(book,200 + 100 * j,1400 - 100 * (i),100,100);

                    } else {
                        if(main.word.contains(String.valueOf(myList.get(i).charAt(j)))){
                            img = "yellow.png";
                            book = new Texture(img);
                            batch.draw(book,200 + 100 * j,1400 - 100 * (i),100,100);
                        }
                        else{
                            img = "gray.png";
                            book = new Texture(img);
                            batch.draw(book,200 + 100 * j,1400 - 100 * (i),100,100);
                        }
                    }

                               }
            }
            for (int i = myList.size(); i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    batch.draw(box,200 + 100 * j,1400 - 100 * (i),100,100);            }
            }
            for (int i = 0; i < myList.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    img = myList.get(i).charAt(j) + ".png";
                    book = new Texture(img);
                    batch.draw(book,200 + 100 * j ,1400 - (100 * i),100,100);

                }
            }
        }
        else{
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    batch.draw(box,200 + 100 * j,900 + 100 * i,100,100);            }
            }
        }





        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        keyboard.dispose();
        d12.dispose();
        bk.dispose();
        book.dispose();
        oiia.dispose();
        batch.dispose();
        box.dispose();

    }
}
