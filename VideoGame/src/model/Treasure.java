package model;

public class Treasure{
    private String name;
    private String imgUrl;
    private int giveScore;
    private int xPst;
    private int yPst;

    public Treasure (String name, String imgUrl,int giveScore,int xpst,int yPst){
        this.name=name;
        this.imgUrl=imgUrl;
        this.giveScore=giveScore;
        this.xPst=xpst;
        this.yPst=yPst;
    }

    public String getName() {
        return this.name;
    }
    public String getImgUrl() {
        return this.imgUrl;
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

    public void setName (String name){
        this.name=name;
    }
    public void setImgUrl (String imgUrl){
        this.imgUrl=imgUrl;
    }
    public void setGiveScore (int giveScore){
        this.giveScore=giveScore;
    }

    public String toString(){
        return "Treasure:"
        +"\nName: "+this.name
        +"\nImage: "+this.imgUrl
        +"\nScore: "+this.giveScore
        +"\nX position: "+this.xPst
        +"\nY position: "+this.yPst;
    }
}