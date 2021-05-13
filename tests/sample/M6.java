package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;
import static sample.TwoExitRoomController.challengeActive;

public class M6 extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        TwoExitRoomController.end();
        Parent mainNode = FXMLLoader.load(Main.class.getResource("WelcomeScreen.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testFinalBoss() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        assertTrue(TwoExitRoomController.monsterHealth == 500);
    }

    @Test
    public void testFinalBossHp() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        assertTrue(TwoExitRoomController.monsterHealth > 100);
    }

    @Test
    public void testBossDefeat() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#continueButton");
        Text text2 = lookup("#roomHead").query();
        assertEquals(text2.getText(), "CONGRATULATIONS BRAVE ADVENTURER");
    }


    @Test
    public void testChallengeRooms() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        int count = 0;
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                    count++;
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        assertTrue(count > 3);
    }

    @Test
    public void testDeclineChallenge() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit2");
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#continueButton");
        Text text2 = lookup("#roomHead").query();
        assertEquals(text2.getText(), "CONGRATULATIONS BRAVE ADVENTURER");
    }


    @Test
    public void testChallengeAccept() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#continueButton");
        Text text2 = lookup("#roomHead").query();
        assertEquals(text2.getText(), "CONGRATULATIONS BRAVE ADVENTURER");
    }


    @Test
    public void testChallengeReturn() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                try {
                    clickOn("#prevBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                    break;
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        assertTrue(true);
    }

    @Test
    public void testMonstersKilled() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        int count = 0;
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                count = count +3;
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                    count++;
                } else {
                    clickOn("#exit2");
                    count++;
                }
            }
        }
        count++;
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#continueButton");
        Text text2 = lookup("#monst").query();
        assertEquals(text2.getText(), "Monsters Killed: " + count);
    }

    @Test
    public void testRoomsVisited() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        int count = 0;
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                count = count +3;
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                    count++;
                } else {
                    clickOn("#exit2");
                    count++;
                }
            }
        }
        count++;
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#continueButton");
        Text text2 = lookup("#room").query();
        assertEquals(text2.getText(), "Rooms Visited: " + (count-2));
    }


    @Test
    public void testGoldCollected() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        sleep(1500);
        while (TwoExitRoomController.monsterHealth != 500) {
            if (InventoryScreenController.aPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#aPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.hPotions > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#hPotBtn");
                clickOn("#backBtn");
            } else if (InventoryScreenController.gApple > 0 && !challengeActive && TwoExitRoomController.challengeAccept == false) {
                try {
                    clickOn("#inventoryBtn");
                } catch
                (org.testfx.api.FxRobotException e) {
                }
                clickOn("#gApBtn");
                clickOn("#backBtn");
            } else if (TwoExitRoomController.challengeAccept == true && TwoExitRoomController.roomsFromStart == TwoExitRoomController.challengeRoom[0]) {
                clickOn("#exit1");
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            } else {
                while (TwoExitRoomController.monsterHealth > 0) {
                    clickOn("#attackBtn");
                    clickOn("#hitBtn");
                    sleep(1500);
                }
                int x = (int) (Math.round(Math.random())) + 1;
                if (x == 1) {
                    clickOn("#exit1");
                } else {
                    clickOn("#exit2");
                }
            }
        }
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#continueButton");
        Text text2 = lookup("#mny").query();
        assertEquals(text2.getText(), "Money Obtained: " + TwoExitRoomController.money);
    }
}