package at.mes.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;


public class Rectangels extends BasicGame {
    private float x;
    private float y;
    private float cx;
    private float cy;
    private float c1x;
    private float c1y;
    private float speed;
    public enum Direction{RIGHT,LEFT,DOWN,UP}

    private Direction direction = Direction.RIGHT;

    public enum Directionc{UP, DOWN}
    private Directionc directionc = Directionc.UP;

    public enum Directionc1{RIGHT, LEFT}
    private Directionc1 directionc1 = Directionc1.RIGHT;

    public Rectangels(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 99;
        this.y =99;
        this.speed = 5.0f;
        this.cy =99;
        this.c1x = 99;

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        if (this.direction==Direction.RIGHT){
            this.x+=(float)delta/this.speed;
            if (this.x>650){
                this.direction = Direction.DOWN;
            }
        }

        if (this.direction==Direction.DOWN){
            this.y+=(float)delta/this.speed;
            if (this.y>450){
                this.direction=Direction.LEFT;
            }

        }
        if (this.direction==Direction.LEFT){
            this.x-=(float)delta/this.speed;
            if(this.x<50){
                this.direction = Direction.UP;
            }
        }
        if (this.direction==Direction.UP){
            this.y-=(float)delta/this.speed;
            if(this.y<50){
                this.direction = Direction.RIGHT;
            }
        }
        if (this.directionc==Directionc.DOWN){
            this.cy+=(float)delta/this.speed;
            if(this.cy>450){
                this.directionc = Directionc.UP;
            }
        }
        if (this.directionc==Directionc.UP){
            this.cy-=(float)delta/this.speed;
            if(this.cy<50){
                this.directionc = Directionc.DOWN;
            }
        }
        if (this.directionc1==Directionc1.RIGHT){
            this.c1x+=(float)delta/this.speed;
            if(this.c1x>650){
                this.directionc1 = Directionc1.LEFT;
            }
        }
        if (this.directionc1==Directionc1.LEFT){
            this.c1x-=(float)delta/this.speed;
            if(this.c1x<50){
                this.directionc1 = Directionc1.RIGHT;
            }
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x,this.y,100,100);
        graphics.drawOval(this.cx,this.cy,50,50);
        graphics.drawOval(this.c1x,this.c1y,50,50);



    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangels("Rectangels"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
