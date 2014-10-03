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

int penThickness = 10;
int gb = 255;
int hn = 0;
int jm = 0;
SnowFlake [] blizzard = new SnowFlake[300];
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
    fill(gb,hn,jm);
    ellipse(mouseX,mouseY, penThickness,penThickness);
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
  if (key == '1'){
    penThickness = 10;
  }
  if (key == '2'){
    penThickness = 20;
  }
  if (key == '3'){
    penThickness = 30;
  }
  if (key == 'g'){
    gb = gb + 1;
    if(gb > 255){
      gb = 255;
    }
  }
  if (key == 'b'){
    gb = gb - 1;
    if(gb < 0){
      gb = 0;
    }
  }
  if (key == 'h'){
    hn = hn + 1;
    if(hn > 255){
      hn = 255;
    }
  }
  if (key == 'n'){
    hn = hn - 1;
    if(hn < 0){
      hn = 0;
    }
  }
  if (key == 'j'){
    jm = jm + 1;
    if(jm > 255){
      jm = 255;
    }
  }
  if (key == 'm'){
    jm = jm - 1;
    if(jm < 0){
      jm = 0;
    }
  }
}

class SnowFlake
{
  int xpos, ypos, wind;
  boolean moving;
  SnowFlake(int x, int y){
      xpos = x;
      ypos = y;
      moving = true;
      wind = 3;
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
    ellipse(xpos,ypos,7,8);
  }
  public void move(){
    if(moving == true){
      ypos = ypos + 1;
      xpos = xpos + (int)(Math.random()* wind) - 1;
      }
    if(keyPressed == true && key == 'a'){
      wind  = wind - 1;
    }
    if(keyPressed == true && key == 'd'){
      wind  = wind + 1;
    }
  }
  public void wrap(){
    if(ypos > 490){
      ypos = 0;
      xpos = (int)(Math.random() * 495) +1;
    }
    if(xpos < 5){
      ypos = ypos + (int)(Math.random()*3)-1;
      xpos = 494;
    }
    if(xpos > 495){
      ypos = ypos + (int)(Math.random()*3)-1;
      xpos = 6;
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
