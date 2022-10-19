package model;

public class Player{
    private String name;
    private String nickName;
    private int score;
    private int lives;
    private int level;

    public Player (String name, String nickName){
        this.name=name;
        this.nickName=nickName;
        this.score=10;
        this.lives=5;
        this.level=1;
    }

    public String getName() {
        return this.name;
    }
    public String getNickName() {
        return this.nickName;
    }
    public int getScore() {
        return this.score;
    }
    public int getLives() {
        return this.lives;
    }
    public int getLevel() {
        return this.level;
    }


    public void setName (String name){
        this.name=name;
    }
    public void setNickName (String nickName){
        this.nickName=nickName;
    }
    public void setScore (int score){
        this.score=score;
    }
    public void setlives (int lives){
        this.lives=lives;
    }
    public void setLevel (int level){
        this.level=level;
    }


    public String toString (){
        return "Player:"
        +"\nName: "+this.name
        +"\nNickName: "+this.nickName
        +"\nScore: "+this.score
        +"\nlives: "+this.lives
        +"\nActually level: "+this.level;
    }
}