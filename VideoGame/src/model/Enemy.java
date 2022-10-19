package model;

public class Enemy{
    private String name;
    private Type enemyType;
    private int removeScore;
    private int giveScore;
    private int xPst;
    private int yPst;

    public Enemy (String name, int enemyType, int removeScore,int giveScore,int xPst, int yPst){
        this.name=name;
        this.enemyType=Type.values()[enemyType-1];
        this.removeScore=removeScore;
        this.giveScore=giveScore;
        this.xPst=xPst;
        this.yPst=yPst;
    }

    public String getName() {
        return this.name;
    }
    public int getRemoveScore() {
        return this.removeScore;
    }
    public int getGiveScore() {
        return this.giveScore;
    }
    public int getXPst() {
        return this.xPst;
    }
    public int getYPst() {
        return this.yPst;
    }
    public Type getType (){
        return this.enemyType;
    }


    public void setName (String name){
        this.name=name;
    }
    public void setRemoveScore (int removeScore){
        this.removeScore=removeScore;
    }
    public void setGiveScore (int giveScore){
        this.giveScore=giveScore;
    }

    public String toString(){
        return "Treasure:"
        +"\nName: "+this.name
        +"\nType: "+this.enemyType
        +"\nScore:"
        +"\n-If you beat the enemy "+this.giveScore
        +"-If you don't beat the enemy "+this.removeScore
        +"X position: "+this.xPst
        +"Y position: "+this.yPst;
    }
}