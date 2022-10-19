package model;

public class VideoGameController{
    
    private Player [] players;
    private Treasure [] treasures;
    private Enemy [] enemies;
    private Level [] levels;

    public VideoGameController (){
        this.players=new Player [20];
        this.treasures=new Treasure [50];
        this.enemies= new Enemy [25];
        this.levels=new Level [10];
    }

    /**
     * Desc: This method generate a level. For this required the number ("id") and the score necesary to pass the level.  
     * @param number int. This param is the number or "id" of the level
     * @param requiredScore int. This param is the score necesary to pass the level 
     * Post:The level wiil be generated. 
     */
    public void generateLevels (int number, int requiredScore){
        Level level = new Level(number, requiredScore);

        for (int i = 0;i<levels.length;i++){
            if (levels[i]==null){
                levels[i]=level;
            }
        }
    }

    /**
     * Desc: This method register a player in the system. For this, uses the constructor method fro Player class 
     * and saves the new player in players array
     * @param name String. This param is the name of player
     * @param nicKName string. This param is the nickname of the player. The nickname cannot repeat in the videoGame
     * @return boolean. It depence of if the accion was make or not
     * Post:The player will be registered
     */
    public boolean createPlayer (String name, String nicKName){

        Player newPlayer = new Player(name, nicKName);
        boolean veryfyNick=true;

        for (int j=0;j<players.length;j++){
            if(players[j]!=null){
                if((players[j].getNickName()).equals(nicKName)==true){
                    veryfyNick=false;
                }
            }
        }
        if(veryfyNick){
            
            for (int i=0;i<players.length;i++){
                if (players[i]==null){
                    players[i]=newPlayer;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Desc: This method  makes a list with all names of players. For this, it walks all players array 
     * and it is getting and concatenating the names in a string.  
     * @return String. This string has all names of the players registered
     * Post:The String that returned will be ready to use 
     */

    public String showPlayers (){
        String message = "\n";

        for (int i=0;i<players.length;i++){
            if(players[i]!=null){
                message+=(i+1)+". "+players[i].getNickName()+"\n";
            }
        }

        return message;
    }

    /**
     * Desc: This method register an enemy in the system. For this it uses the constructor method from Enemy class and save the
     * new enemy in the enemies array. 
     * @param name String. This is the name of new enemy 
     * @param type int. This is the position of type at enum Type
     * @param removeScore int. this is the score that enemy will remove player if thisone lose against it. 
     * @param giveScore int. This is the score taht enemy will give players if thisone beat it
     * @param xPst int. this is the x cordinate of the new enemy
     * @param yPst int. This is the y cordinate of the new enemy
     * @return boolean. It depence of if the accion was make or not
     * Post: The enemy should will be registered
     */
    public boolean createEnemy (String name, int type, int removeScore, int giveScore, int xPst, int yPst){
        Enemy enemy = new Enemy(name, type, removeScore, giveScore, xPst, yPst);

        for (int i = 0;i<enemies.length;i++){
            if (enemies[i]==null){
                enemies[i]=enemy;
                return true;
            }
        }
        
        return false;
    }

    /**
     * Desc: This method  makes a list with all names and types of enemies. For this, it walks all enemmies array 
     * and it is getting and concatenating the names in a string.  
     * @return String. This string has all names of the enemies registered
     * Post:The String that returned will be ready to use 
     */

    public String showEnemies (){
        String message="\n";

        for (int i = 0; i<enemies.length;i++){
            if (enemies[i]!=null){
                message+=(i+1)+". "+enemies[i].getName()+" type: "+enemies[i].getType()+"\n";
            }
        }

        return message;
    }

    /**
     * Desc: This method saves an enemy in a enemies array of level. For this it requires the number of level and the position of enemy
     * in enemies array.  
     * @param position int. This is the position of the enemy in enemies array of controller
     * @param level int. This is the number or "id" of the level
     * @return boolean. It depence of if the accion was make or not
     * Pre: The system must has enemies registered 
     * Post: The enemy should will be added to the level. 
     */

    public boolean addEnemyToLevel (int position, int level){
        if(enemies[position] == null || levels[level] == null) return false; 
        if ((levels[level].addEnemyToLevel(enemies[position]))){
            updateLevelDificult(level);
            return true;
        }

        return false ;
    }

    /**
     * Desc: This method register an treasure in the system. For this it uses the constructor method from Treasure class and save the
     * new teasure in the enemies array. 
     * @param name String. this is the name of new treasure
     * @param imageUrl Strig. This is the url of an image of the new treasure
     * @param giveScore int. This are the points that the user will get if find this treasure
     * @param xPst int. this is the x cordinate of the new treasure
     * @param yPst int. this is the y cordinate of the new treasure
     * @return boolean. It depence of if the accion was make or not
     * Post: The treasure should will be registered
     */

    public boolean createTreasure (String name, String imageUrl, int giveScore, int xPst, int yPst){
        Treasure treasure = new Treasure(name, imageUrl, giveScore, xPst, yPst);

        for (int i = 0;i<treasures.length;i++){
            if (treasures[i]==null){
                treasures[i]=treasure;
                return true;
            }
        }
        return false;
    }

    /**
     * Desc: This method  makes a list with all names of treasures. For this, it walks all treasures array 
     * and it is getting and concatenating the names in a string.  
     * @return String. This string has all names of the treasures registered
     * Post:The String that returned will be ready to use 
     */

    public String showTreasures (){
        String message = "\n";
        
        for (int i =0 ;i<treasures.length;i++){
            if (treasures[i]!=null){
                message+=(i+1)+". "+treasures[i].getName()+"\n";
            }
        }

        return message;
    }

    /**
     * Desc: This method saves an treasure in a treasures array of level. For this it requires the number of level and the position of treasure
     * in treasures array.  
     * @param position int. This is the position of the treasure in treasures array for controller
     * @param level int. this is the number or "id" of the level
     * @param reps int. This is the number of the same treasures the user would like add to the level
     * @return boolean. It depence of if the accion was make or not
     * Pre: The system must has treasures registered 
     * Post: The treasure should will be added to the level. 
     */

    public boolean addTreasureToLevel (int position, int level, int reps ){

        int counter=0;

        for (int i =1; i<=reps;i++){
          if (levels[level].addTreasureToLevel(treasures[position])){
            counter++;
          }
        }

        if (counter==reps){
            return true;
        }

        return false;
    }

    /**
     * Desc: This method update the dificult of the level. The dificult depence of the score that enemies and reasure give. 
     * @param level int. this is the number or "id" of the level that the method is evaluating
     * Pre: The level must have the ten levels intializated. 
     * Post: The level dificult will be updated. 
     */
    public void updateLevelDificult (int level){
        int treaLevel = levels[level].counterTreasuresScore();
        int enemLevel = levels[level].counterEnemiesScore();

        if (treaLevel>enemLevel){
            levels[level].setDificult(2);
        }else if (treaLevel==enemLevel){
            levels[level].setDificult(1);
        }else {
            levels[level].setDificult(0);
        }

    }

    /**
     * Desc: This method add or remove score to playere. For this, the method just needs the position of player in 
     * players array  and the score that is adding or removing. 
     * @param position int. This is the position of player in the players array
     * @param points int. This is the score that will be operated whit the player score
     * Pre: The system must has players registered
     * Post: The player score will be modified
     */
    public void modifyScoreToPlayer (int position, int points){
        
        int score=players[position].getScore();
        score+=points;
        players[position].setScore(score);
    }

    /**
     * Desc: This method increase level of player if the player has the points necesary to pass the levels entered.   
     * @param position int. This is the position of player in players array.
     * @param leveles int. This id the number of level that user would like up the player
     * @return boolean. It depence of if the accion was make or not
     * Pre: The system must has players registered and the ten levels initialized 
     * Post: If player have the necesary score, The player will be in the level entered
     */

    public boolean increaseLevelOfPlayer (int position, int leveles){

        int playerScore=players[position].getScore();
        int scoreRequired=0;
        for (int i =0; i<leveles;i++) {
            if (levels[i]!=null){
                scoreRequired += levels[i].getRequiredScore();
            }
        }

        if (playerScore>=scoreRequired){
            players[position].setLevel(leveles);
            return true;
        }

        return false;
    }

    /**
     * Desc: This methos makes a String with all treasures and enemies for a level entered
     * @param position int. This es number or "id" of the level that the user would like knows what enemies an treasures have the level. 
     * @return String. This String has a mesage whit treasures an enemies or the message: "There are not enemies and treasures in this level"
     * Pre: The system must has the ten levels intializated
     * Post: The String will be ready to show to player
     */

    public String allTreasuresAndEnemies (int position){
        return levels[position].allTreasuresAndEnemies();
    }

    /**
     * Desc: This method counts how many times a treasure repeats in all levels
     * @param position int. This is the position of the treasure tha user would like know how many times is repeated the treasure in the levels
     * @return int. The number of repeats of the treasure in all levels
     * Pre: The system must has the ten levels initializated
     * Post: The int whit the number repeas will be ready to show to the user
     */
    
    public int treasureRpeats (int position){
        int repeats = 0;

        for (int i = 0;i<levels.length;i++){
            if (levels[i]!=null){
                repeats+=levels[i].tresureRepeats(treasures[position]);
            }
        }

        return repeats;
    }

    /**
     * Desc: This method counts how many enemies of a type entered there are in the levels 
     * @param type int. this is the number of position of the type in the enumu Type
     * @return String. This String have a message with the number of enemies that the game has for a type entered
     * Pre: The system must has the ten levels initializated
     * Post: The String will be ready to show to the user
     */

    public String counterEnemiesType (int type){
        int counter = 0;

        for (int i = 0;i<levels.length;i++){
            if (levels[i]!=null){
                counter+=levels[i].countEnemiesTYpe(type);
            }
        }

        return "\nThere are "+counter+" enemies of a "+Type.values()[type]+" type";
    }

    /**
     * Desc: This method search a return the most repeated treasure in the levels. For this count the repeats of the all
     * treasures an counts the repeats.  
     * @return String. The treasure most repeated in the levels
     * Pre: The system mus have the ten levels initializated
     * Post: The String should have the most repeated treasure for show to the user 
     */

    public String mostRepetedTreasure (){

        String treasure="";
        int actuallyTreasure=0;
        int nextTreasure = 0;

        for (int j = 0;j<treasures.length;j++){
            if (treasures[j]!=null){
                for (int i = 0;i<levels.length;i++){
                    if (levels[i]!=null){
                        nextTreasure=levels[i].tresureRepeats(treasures[j]);
                    }
                }
            }
            if (nextTreasure>actuallyTreasure){
                actuallyTreasure=nextTreasure;
                treasure=treasures[j].toString();
            }

        }

        return treasure;
    }

    /**
     * Desc: This method avaluates what enemy gives more score if you beat it. For this the method is evaluanting 
     * all enemies until find the enemy that give more score
     * @return String. In this String there are the enemy and its level. 
     * Pre: The system must has the ten levels initializated and enemies registered
     * Post: The String will be ready to show to the user 
     */

    public String enemyGivesMore (){

        Enemy enemy=null;
        int actualScore=0;
        int nextScore=0;
        int level=0;

        for (int i = 0;i<enemies.length;i++){
            if (enemies[i]!=null){
                nextScore=enemies[i].getGiveScore();
            }

            if (nextScore>actualScore){
                actualScore=nextScore;
                enemy=enemies[i];
            }
        }

        for (int j = 0;j<levels.length;j++){
            if (levels[j]!=null){
                if(levels[j].searchEnemy(enemy)){
                    level=j+1;
                }
            }
        }

        return "The enemy tha gives more score if you beat it is:"
                +"\n"+enemy.toString()
                +"\nThe enemi is in the level "+level;
    }
    /**
     * Desc: This method convert all names of enemies in char array and count the consonants
     * @return int. the number of consonants in the all names of enemies
     * Pre:The system must have enemies registered
     * Post:The number is ready to show to the user
     */

    public int consonants (){
        int total = 0;
        char a ='a';
        char e ='e';
        char ii ='i';
        char o ='o';
        char u ='u';
        

        for (int i = 0;i<enemies.length;i++){
            if (enemies[i]!=null){
                String name = enemies[i].getName();
                char [] names = name.toCharArray();
                for (int j = 0;j<names.length;j++){
                    if (names[j]!=a&&names[j]!=e&&names[j]!=ii&&names[j]!=o&&names[j]!=u){
                        total++;
                    }
                }
            }
        }

        return total;
    }

    /**
     * Desc: This method organice the player array by upward score of players
     * Pre:The system Must have players registered
     * Post: The player array will be organiced upwardly by score of players
     */
    public void organicePlayers (){
        Player player;

        for (int i= 0;i<players.length;i++){
            if (players[i]!=null){
                for (int j=0;j>players.length-1;j++){
                    if (players[j]!=null){
                        if (players[j].getScore()<players[j+1].getScore()){
                            player=players[j];
                            players[j]=players[j+1];
                            players[j+1]=player;
                        }
                    }
                }
            }
        }
    }

    /**
     * Desc: This method calls the organucePlayers() method and makes a String with the first five player of the array 
     * @return String. This String have the first 5 player in the array
     * Pre:The system must has players registered
     * Post:The String will be ready to show to the user 
     */

    public String topFive (){
        organicePlayers();
        String message = "\n";

        for (int i = 0;i<5;i++){
            if (players[i]!=null){
                message+=players[i].toString()+"\n";
            }
        }

        return message;
    }
}