package com.example.kwai_win;/* autogenerated by Processing revision 1281 on 2022-04-03 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;
import ddf.minim.analysis.FFT;
import controlP5.*;
import processing.sound.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class my_audio_visualizer extends PApplet {


PImage img;
Visualizer visualizer;
ControlPanel controlPanel;

boolean colorchange = true;
func3 func3;

ControlP5 cp5;
Minim minim;
//GLOBAL VARIABLES, I KNOW, IT'S MESSY :P
int controlPanelWidth;
int windowHeight;
int windowWidth;
int visualizerWidth;
int numFrames=100;
FFT fft;
//inputInput input;
AudioPlayer input;
boolean fade = true;
boolean go = true;
int ranges = 0;
int n = 0;
float incr1; 
float incr2;
float limit;
float h;
PFont myFont1;
float redcolor;
float bluecolor;
float greencolor;
PFont myFont2;
//Particle[] particles;
int bands = 256;

PathFinder[] paths;

public void setup() {
  /* size commented out by preprocessor */;
  background(25);
  cp5 = new ControlP5(this);
  System.out.println("Reset!");
  windowHeight = displayHeight;
  windowWidth = displayWidth;
  controlPanelWidth = displayWidth / 4;
  visualizerWidth = (displayWidth - controlPanelWidth);
  minim = new Minim(this);
  input = minim.loadFile("Limitless.mp3");
  input.play();
  //colorMode(HSB, 360, 100, 100, 100);
  noiseSeed(98);
  /* smooth commented out by preprocessor */;
  incr2 = TWO_PI/100 ;
  h = random(360);
  fft = new FFT(input.bufferSize(), input.sampleRate());
  fft.linAverages(bands);
  
  
  
  
  
  //particles = new Particle[fft.specSize()];
  //for (int i = 0; i < fft.specSize(); i++) {
  //  particles[i] = new Particle(i);
  //}
  /* size commented out by preprocessor */;
  img = loadImage("kwai_logo.jpg");
  visualizer = new Visualizer(windowHeight, windowWidth, visualizerWidth);
  controlPanel = new ControlPanel(visualizer, windowHeight, windowWidth, controlPanelWidth, cp5);
  func3 = new func3();
    
  paths = new PathFinder[1];
  paths[0] = new PathFinder();
  // Listens for ControlP5 events
  cp5.addCallback(new CallbackListener() {
    public void controlEvent(CallbackEvent event) {
      // event.getAction() == 1 for click
      if(event.getController().getName() == "pause" && event.getAction() == 1) {
        go = !go;
        input.pause();
        cp5.getController("pause").setCaptionLabel(go ? "Pause" : "Unpause");
        System.out.println(go);
        if(go == true){
          input.play();
        }
      } else if (event.getController().getName() == "reset" && event.getAction() == 1) {
        cp5.getController("amplitude").setValue(0.40f);
        cp5.getController("frequency").setValue(0.50f);
        cp5.getController("redcolor").setValue(100);
        cp5.getController("greencolor").setValue(100);
        cp5.getController("bluecolor").setValue(100);
        
      }
    }
  });
}
public void draw() {
  if(go) {
    visualizer.draw();
    controlPanel.draw();
  } else {
 
  }

}

 public void mouseReleased() {

  controlPanel.mouseEvent();
}
 public void stop() {
  super.stop();
}

public class Visualizer{
  float amplitudeMagnitude = 0.4f; // Default
  float frequencyMagnitude = 0.5f; // Default
  float adjustedAmplitudeMagnitude;
  float adjustedFrequencyMagnitude;
  float amplitude;
  float frequency;

  int visualizationIndex = 0; // Default
  int windowHeight;
  int windowWidth;
  int visualizerWidth;
  int time;
  int wait = 100;

  float[] angle;
  float[] y, x;

  int color1 = 0;
  int color2 = 255;
  int color3 = 255;

  public Visualizer(int windowHeight, int windowWidth, int visualizerWidth) {
    this.windowHeight = windowHeight;
    this.windowWidth = windowWidth;
    this.visualizerWidth = visualizerWidth;
    time = millis(); // Current time
  }

  public void draw() {
    fft.forward(input.mix);
    //noStroke();
    img = loadImage("kwai_logo.jpg");
  //  pushStyle();
  //  colorMode(RGB, 360);   //REMOVE THIS OR NAH?
  //  if(fade) {
  //    noStroke();
  //    fill(0, 25);
  //    rect(0, 0, width, height);
  //} else {
  //  background(0);
  //}
  //popStyle();
  //fft.forward(input.mix);
    switch(visualizationIndex) {
      case 0:
        //fill(0, 0, 0);
        background(0);
        function1();
        break;
      case 1:
     //fill(0, 0, 0);
        //background(0);
        background(36);
        ellipseMode(CENTER);
        fill(255, 40);
        noStroke();
        smooth();
        function2();
        break;
      case 2:
      background(0);
        func3.draw();
        break;
      case 3:
      //fill(0, 0, 0);
      background(0);
        function4();
        break;
      default:
      background(0);
      function1();
    }
  }
  
  private void function1(){
  background(color(5,10,25));
  myFont1 = createFont("Lucida Calligraphy Italic", 32);
  myFont2 = createFont("Segoe Print", 32);
  textFont(myFont1,35);
  fill(255);
  textAlign(CENTER);
  text("Team",345,45);
  textFont(myFont1,45);
  text("K-Wai",345,85);
  textFont(myFont2,10);
  text("MEDITATION",345,100);
  textFont(myFont1,47);
  text("Audio",345,140);
  textFont(myFont2,65);
  text("Visualizer",345,205);
  stroke(255);
  strokeWeight(4);
  line(300,217,400,217);
  line(315,227,385,227);
  line(330,237,370,237);
  strokeWeight(1);
  line(305,93,313,93);
  line(295,96,313,96);
  line(305,99,313,99);
  line(376,93,385,93);
  line(376,96,395,96);
  line(376,99,385,99);
  strokeWeight(3);
  point(270,150);
  point(275,150);
  point(280,150);
  point(285,150);
  point(290,150);
  point(295,150);
  point(300,150);
  point(305,150);
  point(310,150);
  point(315,150);
  point(320,150);
  point(325,150);
  point(330,150);
  point(335,150);
  point(340,150);
  point(345,150);
  point(350,150);
  point(355,150);
  point(360,150);
  point(365,150);
  point(370,150);
  point(375,150);
  point(380,150);
  point(385,150);
  point(390,150);
  point(395,150);
  point(400,150);
  point(405,150);
  point(410,150);
  point(415,150);
  point(420,150);
  point(425,150);
  point(430,150);
  //-----------------------------
  //background(20);
  //colorMode(RGB, 255, redcolor, greencolor, bluecolor);
  image(img, (displayWidth-controlPanelWidth)/3,0);
  h += .1f;
  h = h % 360;
  limit =  map(mouseX, 0, width, PI/12, PI/7);
  fill(350);
  text(round(degrees(limit)), 15, 15);
  incr1 += 0.001f;
  for (float r = incr2; r < TWO_PI; r += incr2 ) { // r = 0; in Java (rounding issue?) 
    float ns = noise(incr1+r);
    float rads = map(ns, 0, 1, -limit, limit);

    float x = (width/2) + (60 * cos(r));
    float y = height/2 + (60 * sin(r));

    float sw = 0;
    if (rads <= 0) sw = map(rads, 0, -limit/3, 2, 0.1f);
    else sw = map(rads, 0, limit/3, 2, 0.1f) ;
    strokeWeight(abs(sw));
    stroke(redcolor, greencolor, bluecolor );
    pushMatrix();
    translate(x-300, y);
    rotate(r + PI/2);
    arm(30, rads);
    popMatrix();
  }
}
 public void arm(float len, float rds) {
  if (len > 5) {
    line(0, 0, 0, -len);
    translate(0, -len);
    rotate(rds);  
    arm(len*.9f, rds);
  }
}

public void function2(){
    //rect(0, 0, visualizerWidth, height);

    // Declarations & Instantiations
    float circleCount = 80;
    float centerPosX = visualizerWidth/2;
    float centerPosY = height/2;

    float diameter =  visualizerWidth * .04f;
    float radius  = diameter/2;
    float circ =  PI * diameter;
    float smallDiameter = (circ / circleCount);

    float angle, x, y;

    adjustedAmplitudeMagnitude = amplitudeMagnitude * 1000; // Max 5000
    adjustedFrequencyMagnitude = frequencyMagnitude * 25; // Max 50
    amplitude = (input.mix.get(1) * adjustedAmplitudeMagnitude);
    frequency = (fft.getBand(1) * adjustedFrequencyMagnitude);
    
    
    if(colorchange){
         color1 = PApplet.parseInt(redcolor);
         color2 = PApplet.parseInt(greencolor);
         color3 = PApplet.parseInt(bluecolor);
         colorchange = false;
    }
    

    fill(color1, color2, color3);

    // Fill Change Over Time
    if(millis() - time >= wait) {
      color1 += 10;
      color2 -= 5;

      // Resets
      if(color1 >= 255) { color1 = 0; }
      if(color2 <= 0) { color2 = 255; }
      if(color3 <= 0) { color3 = 255; }

      time = millis(); // Updates time
    }

    // Visualization
    for(int i = 1; i <= circleCount; ++i) {
      angle = i * TWO_PI / circleCount;
      x = centerPosX + cos(angle) * radius * amplitude;
      y = centerPosY + sin(angle) * radius * amplitude;
      ellipse(x, y, smallDiameter * frequency, smallDiameter * frequency);
    }
  }
  
    private void function4(){
  //pushStyle();
  //colorMode(RGB, 360);   //REMOVE THIS OR NAH?
  //if (fade) {
  //  noStroke();
  //  fill(0, 25);
  //  rect(0, 0, width, height);
  //} else {
  //  background(0);
  //}
  //popStyle();
  //fft.forward(input.mix);
  //for (int i = 0; i < fft.specSize() - 1; i++) {
  //  particles[i].update(fft.getBand(i), input.mix.get(i*2));
  //  particles[i].render();
  //  particles[i].render();
  //}
    float angle,angle2,inc,waveX,waveY,a,x,y,w,x1,y1;
    float size;
    
    adjustedAmplitudeMagnitude = amplitudeMagnitude * 800; // Max 800
    adjustedFrequencyMagnitude = frequencyMagnitude * 800; // Max 800

    background(0);
    push();
    translate((width - controlPanelWidth) / 2, height / 2);
    rotate(frameCount * 0.002f);
    for (int i = 0; i < 1200; i++) {
        angle = sin(i + frameCount * 0.002f) * 10;
        angle2 = cos(i + frameCount * 0.004f) * 650;

        inc = 85;
        waveX = map(sin(frameCount * 0.01f), -1, 1, -inc, inc);
        waveY = map(cos(frameCount * 0.01f), -1, 1, -inc, inc);

        a = -394;
        x = sin(radians(i)) * (angle2 + a) + waveX;
        y = cos(radians(i)) * (angle2 + a) + waveY;

        w = 860;
        x1 = sin(radians(i)) * (w / angle);
        y1 = cos(radians(i)) * (w / angle);
  
        fill(redcolor, greencolor, bluecolor);
        circle(x, y, 1);
        size = map(sin(i * frameCount * 0.0002f), -1, 1, 0, 4);
        circle(x1, y1, size);
    }
    pop();
  }

  public void updateattributes(float amplitudeMagnitude, float frequencyMagnitude, float visualizationIndex) {
    this.amplitudeMagnitude = amplitudeMagnitude;
    this.frequencyMagnitude = frequencyMagnitude;
    this.visualizationIndex = (int) visualizationIndex;

  }
}


class PathFinder {

  PVector location;
  PVector velocity;
  float diameter;
  

  PathFinder() {
    location = new PVector(visualizerWidth/3, displayHeight/2);
    velocity = new PVector(0, -2);
    diameter = 40;
  }
  
  // 构造方法二：分枝
  PathFinder(PathFinder parent) {
    location = parent.location.get();
    velocity = parent.velocity.get();
    float area = PI*sq(parent.diameter/2);
    float newDiam = sqrt(area/2/PI)*2;
    diameter = newDiam;
    parent.diameter = newDiam;
  }

  public void update() {
    if (diameter>0.5f) {
      location.add(velocity);
      PVector bump = new PVector(random(-1, 1), random(-1, 1));  // 随机生长方向
      bump.mult(0.1f);
      velocity.add(bump);
      velocity.normalize();
      
      // 分枝的概率为 0.025
      if (random(0, 1)<0.025f) {
        paths = (PathFinder[]) append(paths, new PathFinder(this));
      }
    }
  }
}
public class ControlPanel {
  ControlP5 cp5;
  Visualizer visualizer;

  int windowHeight;
  int windowWidth;
  int controlPanelWidth;
  int controlPanelPosX;
  int elementsPosX;
  int buttonWidth;

  //color dimColor = color(35,35,35);
  //color highlightColor = color(0,151,244);
  
  int dimColor = color(0xFF000000);
  //color dimColor = color(25,25,50);
  
  
  int highlightColor = color(0,150,250);
  int highlightColor2 = color(25,25,50);
  
  int forBg = color(5,5,15);
  int forG = color(25,25,50);
  int forBut = color(90,90,137);

  public ControlPanel(Visualizer visualizer, int windowHeight, int windowWidth, int controlPanelWidth, ControlP5 cp5) {
    this.visualizer = visualizer;
    this.cp5 = cp5;

    this.windowHeight = windowHeight;
    this.windowWidth = windowWidth;
    this.controlPanelWidth = controlPanelWidth;

    controlPanelPosX = this.windowWidth - this.controlPanelWidth;
    elementsPosX = controlPanelPosX + 30;
    buttonWidth = (controlPanelWidth - 75) / 2; // Half of element width - margin(15)

    cp5.setFont(new ControlFont(createFont("Arial", 10),10));

    // AmplitudeMagnitude
    cp5.addSlider("amplitude")
      .setLabel("")
      .setColorForeground(highlightColor)
      .setColorActive(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition(controlPanelPosX + 30, 160)
      .setRange(0, 1)
      .setWidth(controlPanelWidth - 60) // 2x margin
      .setValue(0.40f); // Default

    // FrequencyMagnitude
    cp5.addSlider("frequency")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition(controlPanelPosX + 30, 255)
      .setRange(0, 1)
      .setWidth(controlPanelWidth - 60) // 2x margin
      .setValue(0.50f); // Default
      
          //red color
    cp5.addSlider("redcolor")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition(controlPanelPosX + 30, 370)
      .setRange(0, 255)
      .setWidth(controlPanelWidth - 500) // 2x margin
      .setValue(100); // Default
      
     cp5.addSlider("greencolor")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition(controlPanelPosX + 240, 370)
      .setRange(0, 255)
      .setWidth(controlPanelWidth - 500) // 2x margin
      .setValue(100); // Default
      
      
    cp5.addSlider("bluecolor")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition(controlPanelPosX + 450, 370)
      .setRange(0, 255)
      .setWidth(controlPanelWidth - 500) // 2x margin
      .setValue(100); // Default

    // Visualization
    RadioButton radioButton = cp5.addRadioButton("radioButton");
    radioButton
        .setColorBackground(dimColor)
        .setPosition(elementsPosX, 450)
        .setColorForeground(0xFF2B2B2B)
        .setColorActive(highlightColor)
        .setSize(25, 25)
        .setItemsPerRow(1)
        .setSpacingRow(10)
        .setLabelPadding(20, 20)
        .addItem("Welcome", 0)
        .addItem("Function # 1", 1)
        .addItem("Function # 2", 2)
        .addItem("Function # 3", 3)
        .activate(0);
  
    DropdownList droplist = cp5.addDropdownList("Music Changer");
    droplist
        .setColorBackground(dimColor)
        .setPosition(elementsPosX+200, 460)
        .setColorForeground(0xFF2B2B2B)
        //.setSize(120,25)
        .setColorActive(highlightColor)
        .setOpen(false)
        .addItem("Choice # 1", 1)
        .addItem("Choice # 2", 2)
        .addItem("Choice # 3", 3)
        .addItem("Choice # 4", 4)
        .addItem("Choice # 5", 5);
    // Buttons
    Button pause = cp5.addButton("pause");
    pause
      .activateBy(ControlP5.RELEASE)
      .setLabel("Pause")
      .setColorActive(highlightColor)
      .setColorBackground(highlightColor)
      .setColorForeground(highlightColor)
      .setPosition(elementsPosX, windowHeight - 130) // 60(margin) - 40(height)
      .setSize(buttonWidth, 40)
      .setValue(128);
    Button reset = cp5.addButton("reset");
    reset
      .activateBy(ControlP5.RELEASE)
      .setLabel("Reset")
      .setColorActive(highlightColor)
      .setColorBackground(highlightColor)
      .setColorForeground(highlightColor)
      .setPosition(elementsPosX + buttonWidth + 15, windowHeight - 130) // 60(margin) - 40(height)
      .setSize(buttonWidth, 40)
      .setValue(128);

    // Button style
    Label pauseLabel = pause.getCaptionLabel();
    pauseLabel.align(CENTER, CENTER);

    Label resetLabel = reset.getCaptionLabel();
    resetLabel.align(CENTER, CENTER);
  }


  public void draw() {

    // Background
    //fill(49, 49, 49);
    //fill(60,60,60);
    fill(5,5,15);
    rect(controlPanelPosX, 0, controlPanelWidth, windowHeight);

    /* Text (margin: 60, 30) */

    // Title
    textAlign(CENTER);
    textSize(24);
    fill(255, 255, 255);
    
//image(img, controlPanelPosX, 0,controlPanelWidth,100);
    text("K-WAi-audioVisualizer", controlPanelPosX + (controlPanelWidth/2), 60);

    // Subhead
    textAlign(LEFT);
    fill(206, 206, 206);

    textSize(16);
    text("Amplitude Magnifier", elementsPosX, 120);
    textSize(12);
    text("Magnify the amplitude of the audio", elementsPosX, 140);

    textSize(16);
    text("Frequency Magnifier", elementsPosX, 215);
    textSize(12);
    text("Magnify the frequency of the audio", elementsPosX, 235);


    textSize(16);
    text("Color Selector", elementsPosX, 315);
    textSize(12);
    text("Change the color of the visualizations!", elementsPosX, 335);
    
    textSize(14);
    fill(255,0,0);
    text("RED",elementsPosX+50,365);
    
    fill(0,255,0);
    text("GREEN", elementsPosX+250,365);
    
    fill(0,0,255);
    text("BLUE", elementsPosX+470, 365);
    
    
    fill(0xFFFFFFFF);
    textSize(16);
    text("Visualization Selector", elementsPosX, 410);
    textSize(12);
    text("Visualize music", elementsPosX, 435);
    
    textSize(16);
    text("Music Selector",elementsPosX + 200, 410);
    textSize(12);
    text("Pick the music of your choice", elementsPosX + 200, 435);

    textSize(16);
    text("Instructions", elementsPosX, 610);
    textSize(12);
    text("- Choose the audio of your choice!", elementsPosX, 630);
    text("- Choose one of the visualizer functions", elementsPosX, 650);
    text("- Play around with the colors!", elementsPosX, 670);
    text("- Play around with the amplitude and/or frequency of the audio ", elementsPosX, 690);
    text("- Sit back and enjoy :) ", elementsPosX, 710);

  }

  /* Updates values without needing refresh */
  public void mouseEvent() {
    float amplitudeMagnitude = cp5.get(Slider.class, "amplitude").getValue();
    float frequencyMagnitude = cp5.get(Slider.class, "frequency").getValue();
    float visualizationIndex = cp5.get(RadioButton.class, "radioButton").getValue();
    float redcolor = cp5.get(Slider.class, "redcolor").getValue();
    float greencolor = cp5.get(Slider.class, "greencolor").getValue();
    float bluecolor = cp5.get(Slider.class, "bluecolor").getValue();
    visualizer.updateattributes(amplitudeMagnitude, frequencyMagnitude, visualizationIndex);
  }
}
public class func3{
int ranges = 100;
public void draw() {
  background(0);
  noFill();
  //fill(redcolor, greencolor, bluecolor);
  strokeWeight(2);

  for (int i = 0; i < ranges; i++) {
    float paint = map(i, 0, ranges, 0, 255);
    stroke(paint);    
    beginShape();
    for (int x = -10; x < width - controlPanelWidth; x += 20) {
            fill(redcolor, greencolor, bluecolor);
            float n = noise(x * 0.001f, i * 0.01f, frameCount * 0.02f);
            float y = map(n, 0, 1, 0, height);
            vertex(x, y);
    }
    endShape();
    
  }
  
}
}

////CREDIT TO WINTER TREE:
////https://openprocessing.org/sketch/592358
//public class tree{
//int numFrames=100;
//PathFinder[] paths;

//public void setup() {
//  fullScreen(P3D);
//  background(36);
//  ellipseMode(CENTER);
//  fill(255, 40);
//  noStroke();
//  smooth();

//  paths = new PathFinder[1];
//  paths[0] = new PathFinder();
//}

//public void draw() {
//  for (int j=0; j<8; j++) {
//    for (int i=0; i<paths.length; i++) {
//      PVector loc = paths[i].location;
//      float diam = paths[i].diameter;
//      ellipse(loc.x, loc.y, diam, diam);
//      paths[i].update();
//    }
//  }
  
//  //saveFrame("t###.gif");
//  //if (frameCount==numFrames)
//  //  exit();
//}

//}
//public class PathFinder extends tree {

//  // 属性包括：位置、速度、直径
//  PVector location;
//  PVector velocity;
//  float diameter;
  
//  // 构造方法一：主干
//  PathFinder() {
//    location = new PVector(width/2, height);
//    velocity = new PVector(0, -2);
//    diameter = 40;
//  }
  
//  // 构造方法二：分枝
//  PathFinder(PathFinder parent) {
//    location = parent.location.get();
//    velocity = parent.velocity.get();
//    float area = PI*sq(parent.diameter/2);
//    float newDiam = sqrt(area/2/PI)*2;
//    diameter = newDiam;
//    parent.diameter = newDiam;
//  }

//  void update() {
//    if (diameter>0.5) {
//      location.add(velocity);
//      PVector bump = new PVector(random(-1, 1), random(-1, 1));  // 随机生长方向
//      bump.mult(0.1);
//      velocity.add(bump);
//      velocity.normalize();
      
//      // 分枝的概率为 0.025
//      if (random(0, 1)<0.025) {
//        paths = (PathFinder[]) append(paths, new PathFinder(this));
//      }
//    }
//  }
//}


  public void settings() { fullScreen(P3D);
smooth(); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "my_audio_visualizer" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
