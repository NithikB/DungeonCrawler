package sample;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TwoExitRoomController implements Initializable {
    @FXML
    private Text gold;
    protected static int money;
    private static int roomNumber = 1;
    protected static int roomsFromStart = 1;
    protected static int endRoomNum;
    private static boolean endRoomExit;
    @FXML
    private ImageView backImage;
    @FXML
    private Text roomHead;
    @FXML
    private Text hp;
    @FXML
    private ImageView monster;
    @FXML
    private Button attackBtn;
    @FXML
    private Button hitBtn;
    @FXML
    private Button exit1;
    @FXML
    private Button exit2;
    @FXML
    private Text alert;
    @FXML
    private Text gAppleBonus;
    private static boolean[] defeated = new boolean[100];
    @FXML
    private Button prevBtn;
    @FXML
    private Button inventoryBtn;
    protected static int monsterHealth;
    protected static int playerHealth = 100;
    protected static boolean prevVisited = false;
    protected static boolean lastIsStartingRoom;
    private static boolean inv = false;
    private static boolean exitRoom = false;
    protected static int monstersKilled = 0;
    protected static int lastExit;
    protected boolean hitMonster = false;
    protected static int attackBonus = 0;
    private static boolean newWeapon = false;
    protected static int[] challengeRoom = new int[2];
    protected static int challengeMonsters = 3;
    protected static boolean challengeAccept = true;
    protected static boolean challengeActive = false;
    protected static int outMoney;
    protected static int outRooms;
    protected static int outMonsters;
    protected static boolean challengeOne = true;

    private String[] monsters = {"images/monster1.png", "images/monster2.png",
        "images/monster3.png"};

    public void initialize(URL url, ResourceBundle rb) {
        gAppleBonus.setVisible(false);
        alert.setVisible(false);
        inventoryBtn.setVisible(true);
        if (inv) {
            inv = false;
            roomHead.setText("Room " + roomNumber);
            gold.setText("Gold: " + money);
            hp.setText("HP: " + playerHealth);
            hitBtn.setVisible(false);
            if (prevVisited) {
                if (lastExit == 1) {
                    exit1.setVisible(true);
                    exit2.setVisible(false);
                } else {
                    exit2.setVisible(true);
                    exit1.setVisible(false);
                }
                prevBtn.setVisible(false);
                monster.setVisible(false);
                attackBtn.setVisible(false);
            } else if (exitRoom) {
                gAppleBonus.setVisible(false);
                roomHead.setText("Exit Room - FINAL BOSS");
                attackBtn.setVisible(true);
                attackBtn.setText("Attack! FINAL BOSS HP: " + monsterHealth);
                monster.setImage(new Image("images/finalboss.png"));
                exit1.setVisible(false);
                exit2.setVisible(false);
            }
            else if (defeated[roomNumber]) {
                exit1.setVisible(true);
                exit2.setVisible(true);
                monster.setVisible(false);
                attackBtn.setVisible(false);
                prevBtn.setVisible(false);
            } else {
                attackBtn.setVisible(true);
                attackBtn.setText("Attack! Monster HP: " + monsterHealth);
                monster.setImage(new Image(monsters[roomNumber % 3]));
                exit1.setVisible(false);
                exit2.setVisible(false);
                if (prevVisited) {
                    prevBtn.setVisible(false);
                } else {
                    prevBtn.setVisible(true);
                }
            }
            return;
        }
        gAppleBonus.setVisible(false);
        money = Room1Controller.money;
        roomNumber += Room1Controller.exitNum;
        lastExit = Room1Controller.exitNum;
        gold.setText("Gold: " + money);
        roomHead.setText("Room " + roomNumber);
        randomEnd();
        lastIsStartingRoom = true;
        hp.setText("HP: " + playerHealth);
        hitBtn.setVisible(false);
        if (!prevVisited) {
            monsterHealth = ((roomNumber % 3) + 1) * 50;
        }
        monster.setImage(new Image(monsters[roomNumber % 3]));
        attackBtn.setText("Attack! Monster HP: " + monsterHealth);
        exit1.setVisible(false);
        exit2.setVisible(false);

    }

    public void exit1(ActionEvent actionEvent) throws IOException {
        if (challengeAccept == true && (challengeOne == true && roomsFromStart == challengeRoom[0] || roomsFromStart == challengeRoom[1])) {
            if (roomsFromStart == challengeRoom[1]) {
                challengeAccept = false;
            }
            challengeActive = true;
            exit1.setText("Exit 1");
            exit2.setText("Exit 2");
            challengeRoom();
            return;
        }
        if (endRoomExit && roomsFromStart > endRoomNum) {
            finalBoss();
            return;
        }
        backImage.setImage(new Image("images/room2.png"));
        alert.setVisible(false);
        lastIsStartingRoom = false;
        monster.setVisible(true);
        attackBtn.setVisible(true);
        roomNumber++;
        roomsFromStart++;
        roomHead.setText("Room " + roomNumber);
        if ((challengeOne == true && roomsFromStart == challengeRoom[0] || roomsFromStart == challengeRoom[1]) && challengeAccept == true) {
            challengeRoomInit();
            return;
        }
        if (!prevVisited) {
            monsterHealth = ((roomNumber % 3) + 1) * 50;
        }
        attackBtn.setText("Attack! Monster HP: " + monsterHealth);
        prevVisited = false;
        monster.setImage(new Image(monsters[roomNumber % 3]));
        lastExit = 1;
        exit1.setVisible(false);
        exit2.setVisible(false);
        prevBtn.setVisible(true);
        inventoryBtn.setVisible(true);

    }

    public void exit2(ActionEvent actionEvent) throws IOException {
        if (challengeAccept == true && (challengeOne && roomsFromStart == challengeRoom[0] || roomsFromStart == challengeRoom[1])) {
            if (roomsFromStart == challengeRoom[1]) {
                challengeAccept = false;
            }
            challengeActive = false;
            roomHead.setText("Room " + roomNumber);
            backImage.setImage(new Image("images/room2.png"));
            monster.setVisible(true);
            attackBtn.setVisible(true);
            monsterHealth = ((roomNumber % 3) + 1) * 50;
            attackBtn.setText("Attack! Monster HP: " + monsterHealth);
            monster.setImage(new Image(monsters[roomNumber % 3]));
            exit1.setVisible(false);
            exit2.setVisible(false);
            prevBtn.setVisible(true);
            inventoryBtn.setVisible(true);
            exit1.setText("Exit 1");
            exit2.setText("Exit 2");
            return;
        }
        backImage.setImage(new Image("images/room2.png"));
        if (!endRoomExit && roomsFromStart > endRoomNum) {
            finalBoss();
            return;
        }
        alert.setVisible(false);
        lastIsStartingRoom = false;
        roomNumber += 2;
        roomsFromStart++;
        monster.setVisible(true);
        attackBtn.setVisible(true);
        roomHead.setText("Room " + roomNumber);
        if ((challengeOne == true && roomsFromStart == challengeRoom[0] || roomsFromStart == challengeRoom[1]) && challengeAccept == true) {
            challengeRoomInit();
            return;
        }
        if (!prevVisited) {
            monsterHealth = ((roomNumber % 3) + 1) * 50;
        }

        prevVisited = false;
        attackBtn.setText("Attack! Monster HP: " + monsterHealth);
        monster.setImage(new Image(monsters[roomNumber % 3]));
        lastExit = 2;
        exit1.setVisible(false);
        exit2.setVisible(false);
        prevBtn.setVisible(true);
        inventoryBtn.setVisible(true);
    }

    public void finalBoss() {
        exitRoom = true;
        roomHead.setText("Exit Room - FINAL BOSS");
        InventoryScreenController.gApple += 3;
        monsterHealth = 500;
        alert.setVisible(false);
        attackBtn.setVisible(true);
        attackBtn.setText("Attack! FINAL BOSS HP: " + monsterHealth);
        backImage.setImage(new Image("images/exitRoom.jpg"));
        monster.setImage(new Image("images/finalboss.png"));
        monster.setVisible(true);
        exit1.setVisible(false);
        exit2.setVisible(false);
        gAppleBonus.setVisible(true);
    }

    public void challengeRoomInit() {
        backImage.setImage(new Image("images/black.jpg"));
        challengeMonsters -= 1;
        monster.setVisible(false);
        attackBtn.setVisible(false);
        roomHead.setText("ACCEPT CHALLENGE?");
        exit1.setText("YES");
        exit2.setText("NO");
        exit1.setVisible(true);
        exit2.setVisible(true);
        prevBtn.setVisible(false);
        inventoryBtn.setVisible(false);
    }
    public void challengeRoom() {
        roomHead.setText("CHALLENGE - Room " + roomNumber);
        monster.setVisible(true);
        attackBtn.setVisible(true);
        exit1.setVisible(false);
        exit2.setVisible(false);
        if (challengeMonsters == -1) {
            monster.setVisible(false);
            attackBtn.setVisible(false);
            challengeActive = false;
            InventoryScreenController.gApple += 3;
            gAppleBonus.setVisible(true);
            exit1.setVisible(true);
            exit2.setVisible(true);
            prevBtn.setVisible(false);
            prevVisited = false;
            backImage.setImage(new Image("images/room2.png"));
            defeated[roomNumber] = true;
            roomHead.setText("Room " + roomNumber);
            money += (int) (Math.random() * 3) * 50;
            gold.setText("Gold: " + money);
            challengeMonsters = 2;
            challengeOne = false;
            return;
        }
        monster.setImage(new Image(monsters[challengeMonsters % 3]));
        monsterHealth = ((challengeMonsters % 3) + 1) * 50;
        attackBtn.setText("Attack! Monster HP: " + monsterHealth);
    }

    public void prev(ActionEvent actionEvent) throws IOException {
        if (lastExit == 1) {
            exit1.setVisible(true);
        } else {
            exit2.setVisible(true);
        }
        roomsFromStart--;
        roomNumber -= lastExit;
        roomHead.setText("Room " + roomNumber);
        prevVisited = true;
        prevBtn.setVisible(false);
        monster.setVisible(false);
        attackBtn.setVisible(false);
        if (lastIsStartingRoom) {
            Parent root = FXMLLoader.load(getClass().getResource("Initial Game Screen.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
            return;
        }
    }

    public void inv(ActionEvent actionEvent) throws IOException {
        inv = true;
        Parent root = FXMLLoader.load(getClass().getResource("InventoryScreen.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void attack(ActionEvent actionEvent) throws IOException, InterruptedException {
        gAppleBonus.setVisible(false);
        hitBtn.setVisible(true);
        hitBtn.setTranslateX(-500 + (int) (Math.random() * 1001));
        hitBtn.setTranslateY(-250 + (int) (Math.random() * 501));
        hitBtn.setVisible(true);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(1000),
                        new KeyValue(hitBtn.visibleProperty(), false)));
        timeline.play();
        hitBtn.setVisible(false);
    }

    public void randomEnd() {
        endRoomNum = (int) Math.random() * 5 + 6;
        endRoomExit = (endRoomNum % 2 == 1);
        challengeRoom[0] = (int) (Math.random() * 4) + 2;
        challengeRoom[1] = challengeRoom[0]+2;
    }

    public static void randomEnd1() {
        endRoomNum = (int) Math.random() * 5 + 6;
        endRoomExit = (endRoomNum % 2 == 1);
        challengeRoom[0] = (int) (Math.random() * 4) + 2;
        challengeRoom[1] = challengeRoom[0]+2;
    }



    public void hit(ActionEvent actionEvent) throws IOException, InterruptedException {
        hitMonster = true;
        hitBtn.setVisible(false);
        monsterHealth -= (attackBonus + 50);
        if (attackBonus > 0) {
            attackBonus -= 5;
        }
        hitMonster = false;
        if (monsterHealth <= 0) {
            monstersKilled++;
            if (challengeActive && (roomsFromStart == challengeRoom[0] || roomsFromStart == challengeRoom[1])) {
                challengeMonsters--;
                challengeRoom();
                return;
            }
            monster.setVisible(false);
            attackBtn.setVisible(false);
            exit1.setVisible(true);
            exit2.setVisible(true);
            prevBtn.setVisible(false);
            prevVisited = false;
            defeated[roomNumber] = true;
            money += (int) (Math.random() * 3) * 50;
            if (exitRoom) {
                end();
                alert.setVisible(false);
                Parent root = FXMLLoader.load(getClass().getResource("ExitRoom.fxml"));
                Scene nextScene = new Scene(root);
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(nextScene);
                window.show();
            }
            gold.setText("Gold: " + money);

            if (!newWeapon) {
                alert.setText("+1 New Weapon!");
                Thread.sleep(10);
                alert.setVisible(true);
                Thread.sleep(10);
                newWeapon = true;
                InventoryScreenController.newWeapon = true;
            } else {
                int temp = (int) (Math.random() * 5) + 1;
                if (temp == 5) {
                    InventoryScreenController.gApple++;
                    alert.setText("+1 Golden Apple!");
                } else if (temp == 3 || temp == 4) {
                    InventoryScreenController.hPotions++;
                    alert.setText("+1 Health Potion!");
                } else if (temp == 2) {
                    InventoryScreenController.aPotions++;
                    alert.setText("+1 Attack Potion!");
                }
                if (temp != 1) {
                    alert.setVisible(true);
                }
            }

            return;
        }

        boolean monsterAttack = (int) Math.random() * 2 == 0 ? true : false;
        if (monsterAttack) {
            playerHealth -= 10;
            hp.setText("HP: " + playerHealth);
        }
        if (exitRoom) {
            attackBtn.setText("Attack! FINAL BOSS HP: " + monsterHealth);
        } else {
            attackBtn.setText("Attack! Monster HP: " + monsterHealth);
        }
        if (playerHealth <= 0) {
            end();
            alert.setVisible(false);
            Parent root = FXMLLoader.load(getClass().getResource("LossScreen.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
            return;
        }


        return;
    }

    protected static void end() {
        outMonsters = monstersKilled;
        challengeOne = true;
        outMoney = money;
        outRooms = roomsFromStart+1;
        monstersKilled = 0;
        monsterHealth = 0;
        playerHealth = 100;
        roomNumber = 1;
        roomsFromStart = 1;
        prevVisited = false;
        lastIsStartingRoom = false;
        lastExit = 0;
        defeated = new boolean[100];
        inv = false;
        attackBonus = 0;
        newWeapon = false;
        InventoryScreenController.newWeapon = false;
        InventoryScreenController.aPotions = 1;
        InventoryScreenController.hPotions = 1;
        InventoryScreenController.gApple = 1;
        exitRoom = false;
        challengeMonsters = 3;
        challengeAccept = true;
        challengeActive = false;
        randomEnd1();
    }

}
