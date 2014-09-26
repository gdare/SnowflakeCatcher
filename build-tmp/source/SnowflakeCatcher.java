import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] blizzard = new SnowFlake[200];
public void setup()
{
  size(500,500);
  noStroke();
  background(0);
  for(int i = 0; i < blizzard.length; i++){
    blizzard[i] = new SnowFlake((int)(Math.random() *490)+1,(int)(Math.random() * 500) +1);
  }
}
public void draw(){
  
  for(int i = 0; i < blizzard.length; i++){
    blizzard[i].blackBox();
    blizzard[i].erase();
    blizzard[i].lookDown();
    blizzard[i].move();
    blizzard[i].wrap();
    blizzard[i].show();
  }
}
public void mouseDragged(){
  if(mousePressed == true && mouseButton == LEFT){
    fill(255,0,0);
    ellipse(mouseX,mouseY, 10,10);
    }
    if(mousePressed == true && mouseButton == RIGHT){
      fill(0);
      ellipse(mouseX,mouseY, 25,25);
    }
}
public void keyPressed(){
  if (key == 'r'){
    fill(0);
    rect(0,0,500,500);
  }
}

class SnowFlake
{
  int xpos, ypos;
  boolean moving;
  SnowFlake(int x, int y){
      xpos = x;
      ypos = y;
      moving = true;
  }
  public void show(){
    
    fill(255);
    ellipse(xpos,ypos,5,5);
  }
  public void lookDown(){
    if(get (xpos,ypos+5) != color(0)){
      moving = false;
    }
    else{
      moving = true;
    }
  }
  public void erase(){
    fill(0);
    ellipse(xpos,ypos,8,8);
  }
  public void move(){
    if(moving == true){
      ypos = ypos + 1;
    }
  }
  public void wrap(){
    if(ypos > 490){
      ypos = 0;
      xpos = (int)(Math.random() * 500) +1;
    }
  }
  public void blackBox(){
    fill(0);
    rect(0, 485, 500,20);
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
