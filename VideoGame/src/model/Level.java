package model;

public class Level{
    private int number;
    private int requiredScore;
    private Dificult dificult;
    private Treasure [] treasures;
    private Enemy [] enemies;

    public Level (int number, int requiredScore){
        this.number=number;
        this.requiredScore=requiredScore;
        this.dificult=Dificult.values()[1];
        this.treasures=new Treasure [50];
        this.enemies=new Enemy [50];
    }

    public int getNumber() {
        return this.number;
    }
    public int getRequiredScore() {
        return this.requiredScore;
    }
    public Dificult getDificult() {
        return this.dificult;
    }

    public void setDificult (int dificult){
        this.dificult=Dificult.values()[dificult];
    }


    public boolean addEnemyToLevel(Enemy enemy){
        
        for (int i = 0;i<enemies.length;i++){
            if (enemies[i]!=null){
                if (enemies[i].getName().equals(enemy.getName())){
                    return false;
                }
            }   
        }
        for (int j = 0 ; j<enemies.length;j++){
            if (enemies[j]==null){
                enemies[j]=enemy;
                return true;
            }
        }
        return false;
    }


    public int counterEnemiesScore (){
        int total=0;

        for (int i = 0; i<enemies.length;i++){
            if (enemies[i]!=null){
                total+=enemies[i].getGiveScore();
            }
        }

        return total;
    }

    public boolean addTreasureToLevel (Treasure treasure){
        for (int i = 0;i<treasures.length;i++){
            if (treasures[i]==null){
                treasures[i]=treasure;
                return true;
            }
        }
        return false;
    }

    public int counterTreasuresScore (){
        int total=0;

        for (int i = 0;i<treasures.length;i++){
            if (treasures[i]!=null){
                total+=treasures[i].getGiveScore();
            }
        }

        return total;
    }

    public String allTreasuresAndEnemies (){
        String message = "\n";
        int treaNum=0;
        int enemNum=0;

        for (int k = 0;k<treasures.length;k++ ){
            if (treasures[k]!=null){
                treaNum++;
            }
        }
        for (int l = 0;l<enemies.length;l++){
            if (enemies[l]!=null){
                enemNum++;
            }
        }

        if (treaNum>0){
            message="There are the tresures:\n";
            for (int i = 0; i<treasures.length;i++){
                if (treasures[i]!=null){
                    message+=(i+1)+". "+treasures[i].getName()+"\n";
                }
            }
        }else{
           message="There are not treasures\n"; 
        }

        if (enemNum>0){
            message+="There are the enemies:\n";
            for (int j = 0; j>enemies.length;j++){
                if (enemies[j]!=null){
                    message+=(j+1)+". "+enemies[j].getName()+" Type: "+enemies[j].getType()+"\n";
                }
            }
        }else {
            message+="There are not enemies\n";
        }

        return message;
    }

    public int tresureRepeats (Treasure treasure){
        int repeats=0;
        for (int i =0;i<treasures.length;i++){

            if (treasures[i]!=null){
                if (treasures[i].equals(treasure)){
                    repeats++;
                }
            }

        }
        return repeats;
    }

    public int countEnemiesTYpe (int type){
        int counter=0;
        Type newType = Type.values()[type];
        for (int i = 0; i>enemies.length;i++){
            if (enemies[i]!=null){
                if (newType.equals(enemies[i].getType())){
                    counter++;
                }
            }
        }

        return counter;
    }

    public boolean searchEnemy (Enemy enemy){

        for (int i = 0;i<enemies.length;i++){
            if (treasures[i]!=null){
                if (enemies[i].equals(enemy)){
                    return true;
                }
            }
        }

        return false;

    }

    public String toString (){
        return "Level "
        +"\nNumber: "+this.number
        +"\nRequired score to pass this level: "+ this.requiredScore
        +"\nDificult: "+this.dificult;
    }
}