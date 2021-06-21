package com.drawboard.draw.Board;

public class Canvas {
    private String[][] canvas;
    private int height;
    private int width;
    private String color;

    public Canvas() {

    }

    public void init() {
        canvas = new String[height+2][width+2];

        for(int i=0;i<(height+2);i++) {
            for(int j=0;j<(width+2);j++) {
                if(i == 0 || i == (height+1))
                    canvas[i][j] = "-";
                else if(j == 0 || j == (width+1))
                    canvas[i][j] = "|";
                else
                    canvas[i][j] = " ";
            }
        }


    }

    public void display()
    {
        for(int i=0;i<(height+2);i++) {
            for(int j=0;j<(width+2);j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public String getCellColor(int x, int y)
    {
        return this.canvas[y][x];
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return this.color;
    }


    public void draw(int x1, int y1, int x2, int y2)
    {
        int temp = 0;
        //vertical
        if(x1 == x2) {
            if(y1>y2){
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            for(int i = y1;i<=y2;i++)
                canvas[i][x1] = "x";
        }
        //horizontal
        if(y1 == y2) {
            if(x1>x2){
                temp = x1;
                x2 = x1;
                x1 = temp;
            }
            for(int i = x1;i<=x2;i++) {
                canvas[y1][i] = "x";
            }
        }
    }

    public void fill(int x, int y, String overlap) {
        if(!canvas[y][x].equals(overlap))
            return;

        canvas[y][x] = color;
        fill(x+1, y, overlap);
        fill(x-1, y, overlap);
        fill(x, y+1, overlap);
        fill(x, y-1, overlap);

//        fill(x+1, y+1, overlap);
//        fill(x+1, y-1, overlap);
//        fill(x-1, y+1, overlap);
//        fill(x-1, y-1, overlap);

    }
}
