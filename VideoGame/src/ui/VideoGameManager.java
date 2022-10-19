package ui;
import model.VideoGameController;
import java.util.Scanner;
import java.lang.Math;

public class VideoGameManager {

    public static Scanner sc = new Scanner(System.in);
    public static int enemies =0;
    public static int treasures=0;
    public static int players=0;
    public static VideoGameController controller = new VideoGameController();

    public static void main (String [] args){

        System.out.println("Welcome to VideoGame");
        configLevel();
        menu();
        System.out.println("See you later");

    }
    /**
     * Desc:This method config the ten levels in the game. For this it question to user
     * the required score to pass each level. 
     */
    public static void configLevel (){

        int score;

        for (int i = 1; i<=10;i++){
            System.out.println("How many points do you need to pass level "+i);
            score=sc.nextInt();
            controller.generateLevels(i, score);
        }
    } 

    /**
     * Desc:This method show to the user all options that can do. The method get the number of the option 
     * and call the methot necesary or just do the action. 
     * Pre:The levels must be registered
     */

    public static void menu (){

        boolean start = false;
        int variable;

        while (!start){
            System.out.println("What do you wish to do?"
            +"\n1.Register player"
            +"\n2.Create enemy"
            +"\n3.Create treasure"
            +"\n4.Modify score to player"
            +"\n5.Increase level to player"
            +"\n6.Asociate menu"
            +"\n7.Show the treasures and enemies for a level"
            +"\n8.Count treasure repeats at the game"
            +"\n9.Count enemies of a type"
            +"\n10.Most repeated treasure"
            +"\n11.Show the enemy that gives more score"
            +"\n12.How many consonants are there in the enemy names?"
            +"\n13.Show top of players"
            +"\n14.exit");

            variable=sc.nextInt();
            if (variable==1){
                createPlayer();
                players++;
            }else if (variable==2){
                createEnemy();
                enemies++;
            }else if (variable==3){
                createTreasure();
                treasures++;
            }else if (variable==4){
                if (players>0){
                    modifyScoreToPlayer();
                }else {
                    System.out.println("There is not players registered");
                }
            }else if (variable==5){
                if (players>0){
                    increaseLevelOfPlayer();
                }else {
                    System.out.println("There are not players registered yet");
                }
            }else if (variable==6){
                asociateMenu();
            }else if (variable==7){ 
                if (treasures>0 && enemies>0){
                    allTreasuresAndEnemies();
                }else {
                    System.out.println("There are not treasures or enemies in the game");
                }
            }else if (variable==8){
                if (treasures > 0){
                    treasureRepeats();
                }else {
                    System.out.println("There are not treasures in the game");
                }
            }else if (variable==9){
                if (enemies>0){
                    countEnemyType();
                }else {
                    System.out.println("There are not enemies registered yet");
                }
            }else if (variable==10){
                if (treasures>0){
                    mostRepeatedTreasure();
                }else{
                    System.out.println("There are not treasures registered yet");
                }
            }else if (variable==11) {
                if (enemies>0){
                    enemyGivesMore();
                }else {
                    System.out.println("There are not enemies registered yet");
                }
            }else if (variable==12){
                if (enemies>0){
                    consonants();
                }else{
                    System.out.println("There are not enemies registered yet");
                }
            }else if (variable==13){
                if(players>0){
                    topFive();
                }else{
                    System.out.println("There are not players registered yet");
                }
            }else if (variable==14){
                addEnemyToLevel();
            }else {
                start=true;
            }
        }
    }

    /**
     * Desc:This metod ask all instances necesary to register a player. In all cases the system just need the name and nickname.
     * After this method calls the method createPlayer() from controller class to finsh registration.
     * Post:The player will be registered
     */

    public static void createPlayer (){
        System.out.println("Enter the name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter the NickName");
        String nickName = sc.nextLine();

        if (controller.createPlayer(name, nickName)){
            System.out.println("The player "+nickName+" was created");
            players++;
        }else {
            System.out.println("Error");
        }
    }

    /**
     * Desc: This method ask all instances necesary to register an enemy and generate randomly the 
     * coordinates for the enemy. After, this method calls the method create enemy() from controller class
     * to finish registration
     * Post:The enemy willbe registered. 
    */

    public static void createEnemy (){
        System.out.println("Enter the enemy name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Choose one type:"
        +"\n1. OGRE"
        +"\n2. ABSTRACT"
        +"\n3. BOSS"
        +"\n4. MAGIC");
        int type = sc.nextInt();
        System.out.println("How many points will it remove you if you lose aganist it");
        int removeScore = sc.nextInt();
        System.out.println("How many points will it give you if you win against it");
        int giveScore = sc.nextInt();
        int xPst = (int)(Math.random()*1281+1);
        int yPst = (int)(Math.random()*721+1);

        if (controller.createEnemy(name, type, removeScore, giveScore, xPst, yPst)==true){
            System.out.println("The enemy was created");
            enemies++;
        }else {
            System.out.println("Error");
        }
    }

    /**
     * Desc:This method ask the necesary instances to register a treasure and generate randomly the coordinates 
     * of the treasure. After,  this method calls the method create tresure() from controller class to 
     * finish registration.
     * Post: The treasure will be registered. 
     */

    public static void createTreasure (){
        System.out.println("Enter the treasure name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter the image URL");
        String imageUrl = sc.nextLine();
        System.out.println("If you find this treasure, how many points will it to give you?");
        int giveScore = sc.nextInt();
        int xPst = (int)(Math.random()*1281+1);
        int yPst = (int)(Math.random()*721+1);

        if (controller.createTreasure(name, imageUrl, giveScore, xPst, yPst)){
            System.out.println("The treasure was created ");
            treasures++;
        }else {
            System.out.println("Error");
        }

    }
    /**
     * Desc: This method shows all players registered to the user. The user chooses one and must enter 
     * the points that wants add or remove. Finally this method calls the modifyScoreToPlayer() from 
     * controller class to does the changes in the score of selected player. 
     * Pre: The system must has players registered 
     * Post: The score of selected player will be modified
     */
    public static void modifyScoreToPlayer (){
        int decision;
        int points;
        System.out.println("Here are the available players: ");
        System.out.println(controller.showPlayers());
        System.out.println("Enter the number of player that you want to modify the score");
        int position = sc.nextInt();
        System.out.println("Do you want:"
        +"\n1. Add points"
        +"\n2. Remove points");
        decision=sc.nextInt();
        if (decision==1){
            System.out.println("How many points do you want to add to the player?");
            points=sc.nextInt();
        }else {
            System.out.println("How many points do you want to remove to the player?");
            points=sc.nextInt();
            points*=-1;
        }
        controller.modifyScoreToPlayer(position-1, points);
        System.out.println("The changes were apliqued");
    }

    /**
     * Desc: This method show to the user new options, with this options the user 
     * could add treasure or enemi to a level. 
     */
    public static void asociateMenu (){

        boolean start = false;
        int variable;

        System.out.println("What do you wish asociate?");

        while (!start){
            System.out.println("\n1.Enemy to level"
            +"\n2.Treasure to level"
            +"\n3.Close asociate menu");
            variable = sc.nextInt();

            if (variable ==1 ){
                if (enemies>0){
                    addEnemyToLevel();
                }else {
                    System.out.println("There is not enemies registered yet");
                }
            }else if (variable==2){
                if(treasures>0){
                    addTreasureToLevel();
                }else{
                    System.out.println("There is not treasures registered yet");
                }
            }else {
                start=true;
            }
        }
    }

    /**
     * Desc: This method show to the user all available enemies, the user choose one and enter the level that wants 
     * add the selected enemy. After this method calls the method addEnemyToLevel() from controller class to finish the 
     * asociation.
     * Pre: The system must has enemies registered and levels initializated. 
     * Post: If the enemi is not in the level yet, the enemy will be asociated to level. 
     */

    public static void addEnemyToLevel (){
        System.out.println("Here are the available enemies:");
        System.out.println(controller.showEnemies());
        System.out.println("Choose one. Enter its number ");
        int position =sc.nextInt();
        System.out.println("To what level would you like add the enemy");
        int level = sc.nextInt();

        if (controller.addEnemyToLevel(position-1, level-1)){
            System.out.println("The enemy was added to level "+level);
        }else {
            System.out.println("Error");
        }
    }

    /**
     * Desc: This method show to the user all available treasures, the user choose one, enter how many treasures wants add to level and enter the level that wants 
     * add the selected treasure. After this method calls the method addTreasureToLevel() from controller class to finish the 
     * asociation.
     * Pre: The system must has treasures registered and levels initializated. 
     * Post: The treasures will be added to level. 
     */

    public static void addTreasureToLevel (){
        System.out.println("Here are the available treasures:");
        System.out.println(controller.showTreasures());
        System.out.println("Choose one. Enter its number");
        int position = sc.nextInt();
        System.out.println("How mani treasures of these do you want to add to the level?");
        int reps = sc.nextInt();
        System.out.println("To what level would you like add the treasure/s");
        int level = sc.nextInt();

        if (controller.addTreasureToLevel(position-1, level-1, reps)){
            System.out.println("The treasure/s was added to level "+level);
        }else {
            System.out.println("Error");
        }
    }

    /**
     * Desc: This method can increase level of a player. For this, the method shows all players registered to the user 
     * and ask the player number and the level that wants increase to the player. After, this method calls the 
     * method increaseLevelOfPlayer() from controller to be able to increase level of player. 
     * Pre:The system must has players registered
     * Post:If the player has required points to pass the levels entered, the system will level ud the player    
     */

    public static void increaseLevelOfPlayer(){
        System.out.println("There are the players");
        System.out.println(controller.showPlayers());
        System.out.println("Enter the number of player that you want to increase level");
        int position = sc.nextInt();
        System.out.println("Enter the number of level that you want increase the player selected");
        int leveles = sc.nextInt();

        if (controller.increaseLevelOfPlayer(position-1, leveles-1)){
            System.out.println("The level player was increased");
        }else {
            System.out.println("The player cannot raise those levels");
        }
    }

    /**
     * Desc: This method shows all treasures and enemies for a level. For this the method ask to user a number level. 
     * After it calls the method allTreasuresAndEnemies() from controller to search the items. 
     * Post: If the system has enemies or treasures, it show all to the user, else it shows a message.  
     */

    public static void allTreasuresAndEnemies (){
        System.out.println("Enter a level to show the enemies and tresures");
        int level = sc.nextInt();
        System.out.println(controller.allTreasuresAndEnemies(level-1));
    }

    /**
     * Desc: This method shows how many times repeat a treasure in all levels. For this shows to te user al treasures
     * and ask the treasure number. After this methos calls th method  treasureRpeats() from contoller class. Finally show a message to the user. 
     * Post: The system will show the message to the user. 
     */

    public static void treasureRepeats (){
        System.out.println("There are the treasures:");
        System.out.println(controller.showTreasures());
        System.out.println("Enter the treasure number");
        int position = sc.nextInt();
        System.out.println("The treasure selected is repeated "+controller.treasureRpeats(position-1)+" times in the game\n");
    }

    /**
     * Desc: This method ask to the user a type. After it calls the method counterEnemiesType() from controller class for know 
     * how many enemies are of entered type. 
     * Post:The system shows a String whit the number of enemies tha are of the type entered. 
     */

    public static void countEnemyType (){
        System.out.println("Choose the type of enemies that you want to count"
                +"\n1.OGRE" 
                +"\n2.ABSTRACT"
                +"\n3.BOSS"
                +"\n4.MAGIC");
        int decision = sc.nextInt();
        System.out.println(controller.counterEnemiesType(decision-1));
    }

    /**
     * Desc: This method show the most repeated treasure. For this, it calls the method mostRepeatedTreasure() from
     * controller class. 
     * Pre:The system must has treasures saved in any level
     * Post:The system shows to the user the most repeated treasure and its number of repeats. 
     */

    public static void mostRepeatedTreasure (){

        System.out.println("The most repeated treasure is: ");
        System.out.println(controller.mostRepetedTreasure());
    }

    /**
     * Desc: This method search the enemy that gives more score if the player beat it. For this the method calls the method
     * enemyGivesMore() from controller. 
     * Pre: The system must has enemmies asociated to eny level. 
     * Post: The System shows the enemy ant its level. 
     */

    public static void enemyGivesMore (){
        System.out.println(controller.enemyGivesMore());
    }

    /**
     * Desc: This method count how many consonants there are in the all enemy names. For this, it calls the method
     * consonants() from controller class.
     * Pre: The system must has enemies registered
     * Post: Th system shows a message with the number of consonants.  
     */

    public static void consonants (){
        System.out.println("There are "+controller.consonants()+" in the game");
    }
    /**
     * Desc:This method show the top five of players by their score. For this, this method calls the method topFive() from 
     * controller class. 
     * Pre: The system must has players registered
     * Post: The system will show tre top five to the user. 
     */
    public static void topFive (){
        System.out.println("There are the 5 better players");
        System.out.println(controller.topFive());
    }
 
}