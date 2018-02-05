package com.example.quent.sudoku;

public class vGrille {

    public double level;
    public int num;
    public int done;

    public vGrille(int lvl, int num) {
        this.level = lvl;
        this.num = num;
        this.done = (int)(Math.random()*100);
    }

}
