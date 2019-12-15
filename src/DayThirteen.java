import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DayThirteen {
    public static int[][] screen = new int[50][20];
    public static int currentBallX;
    public static int currentPaddleX;
    public static int numOfBlocks;

    public static long[] convertToArray(String inputList) {
        ArrayList<Long> list = new ArrayList<>();
        String input = inputList.concat(",");
        while (input.contains(",")) {
            list.add(Long.parseLong(input.substring(0,input.indexOf(","))));
            input = input.substring(input.indexOf(",") + 1);
        }
        long[] array = new long[list.size()+1000];
        for(int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void compute(long[] input) {
        Scanner scan = new Scanner(System.in);
        long parameter1;
        long parameter2;
        int x = -1;
        int y = -1;
        int outputCounter = 1;
        int jumpBy;
        int opcodeLocation = 0;
        int relativeBase = 0;
        int[] opcodeArray = intToArray(input[opcodeLocation]);
        int opcodeFunction = opcodeArray[3] * 10 + opcodeArray[4];
        while (opcodeFunction != 99) {
            opcodeArray = intToArray(input[opcodeLocation]);
            opcodeFunction = opcodeArray[3] * 10 + opcodeArray[4];
            if (opcodeFunction == 1) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                if (opcodeArray[1] == 0) parameter2 = input[(int) input[opcodeLocation + 2]];
                else if (opcodeArray[1] == 1) parameter2 = input[opcodeLocation + 2];
                else parameter2 = input[relativeBase+(int) input[opcodeLocation+2]];
                if (opcodeArray[0] == 0)input[(int) input[opcodeLocation + 3]] = parameter1 + parameter2;
                else input[relativeBase+(int) input[opcodeLocation + 3]] = parameter1 + parameter2;
                jumpBy = 4;
            }
            else if (opcodeFunction == 2) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                if (opcodeArray[1] == 0) parameter2 = input[(int) input[opcodeLocation + 2]];
                else if (opcodeArray[1] == 1) parameter2 = input[opcodeLocation + 2];
                else parameter2 = input[relativeBase+(int) input[opcodeLocation+2]];
                if (opcodeArray[0] == 0)input[(int) input[opcodeLocation + 3]] = parameter1 * parameter2;
                else input[relativeBase+(int) input[opcodeLocation + 3]] = parameter1 * parameter2;
                jumpBy = 4;
            }
            else if (opcodeFunction == 3) {
                int joystick;
                if (currentBallX > currentPaddleX) joystick = 1;
                else if (currentBallX < currentPaddleX) joystick = -1;
                else joystick = 0;
                if (opcodeArray[2] == 0) input[(int) input[opcodeLocation + 1]] = joystick;
                else input[relativeBase + (int) input[opcodeLocation + 1]] = joystick;
                jumpBy = 2;
            }
            else if (opcodeFunction == 4) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                if (outputCounter % 3 == 1)x = (int) parameter1;
                else if (outputCounter % 3 == 2)y = (int) parameter1;
                else if (outputCounter % 3 == 0){
                    if (x == -1 && y == 0) System.out.println(parameter1);
                    else {
                        screen[x][y] = (int) parameter1;
                        display();
                    }
                }
                outputCounter++;
                jumpBy = 2;
            }
            else if (opcodeFunction == 5) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                if (opcodeArray[1] == 0) parameter2 = input[(int) input[opcodeLocation + 2]];
                else if (opcodeArray[1] == 1) parameter2 = input[opcodeLocation + 2];
                else parameter2 = input[relativeBase+(int) input[opcodeLocation+2]];
                if (parameter1 != 0) {
                    opcodeLocation = (int) parameter2;
                    jumpBy = 0;
                }else {
                    jumpBy = 3;
                }
            }
            else if (opcodeFunction == 6) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                if (opcodeArray[1] == 0) parameter2 = input[(int) input[opcodeLocation + 2]];
                else if (opcodeArray[1] == 1) parameter2 = input[opcodeLocation + 2];
                else parameter2 = input[relativeBase+(int) input[opcodeLocation+2]];
                if (parameter1 == 0) {
                    opcodeLocation = (int) parameter2;
                    jumpBy = 0;
                }else {
                    jumpBy = 3;
                }
            }
            else if (opcodeFunction == 7) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                if (opcodeArray[1] == 0) parameter2 = input[(int) input[opcodeLocation + 2]];
                else if (opcodeArray[1] == 1) parameter2 = input[opcodeLocation + 2];
                else parameter2 = input[relativeBase+(int) input[opcodeLocation+2]];
                if (parameter1 < parameter2) {
                    if (opcodeArray[0] == 0) input[(int) input[opcodeLocation + 3]] = 1;
                    else input[relativeBase+(int) input[opcodeLocation + 3]] = 1;
                }else {
                    if (opcodeArray[0] == 0) input[(int) input[opcodeLocation + 3]] = 0;
                    else input[relativeBase+(int) input[opcodeLocation + 3]] = 0;
                }
                jumpBy = 4;
            }
            else if (opcodeFunction == 8) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                if (opcodeArray[1] == 0) parameter2 = input[(int) input[opcodeLocation + 2]];
                else if (opcodeArray[1] == 1) parameter2 = input[opcodeLocation + 2];
                else parameter2 = input[relativeBase+(int) input[opcodeLocation+2]];
                if (parameter1 == parameter2) {
                    if (opcodeArray[0] == 0)input[(int) input[opcodeLocation + 3]] = 1;
                    else input[relativeBase+(int) input[opcodeLocation + 3]] = 1;
                }else {
                    if (opcodeArray[0] == 0)input[(int) input[opcodeLocation + 3]] = 0;
                    else input[relativeBase+(int) input[opcodeLocation + 3]] = 0;
                }
                jumpBy = 4;
            }
            else if (opcodeFunction == 9) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                relativeBase += parameter1;
                jumpBy = 2;
            }
            else if (opcodeFunction == 99) {
                return;
            }
            else {
                System.out.println("Error in opcode" + input[opcodeLocation]);
                jumpBy = 1;
            }
            opcodeLocation = opcodeLocation + jumpBy;
        }
    }

    public static void display() {
        numOfBlocks = 0;
        for (int y = 0; y < screen[0].length; y++) {
            for (int x = 0; x < screen.length; x++) {
                switch (screen[x][y]) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case 2:
                        System.out.print("@");
                        numOfBlocks++;
                        break;
                    case 3:
                        System.out.print("_");
                        currentPaddleX = x;
                        break;
                    case 4:
                        System.out.print("O");
                        currentBallX = x;
                        break;
                    default:
                        System.out.print("?");
                }
            }
            System.out.println();
        }
        System.out.println(numOfBlocks);
    }

    public static int[] intToArray(long input){
        String integer;
        if (input < 10)integer = "0000"+input;
        else if (input < 100)integer = "000"+input;
        else if (input < 1000)integer = "00"+input;
        else if (input < 10000)integer = "0"+input;
        else integer = ""+input;
        int[] output = new int[5];
        for (int i = 0; i < 5; i++) {
            int digit = (int) Long.parseLong(integer.substring(i,i+1));
            output[i] = digit;
        }
        return output;
    }

    public static void main(String[] args) {
        int numOfNums = 0;
        compute(convertToArray("2,380,379,385,1008,2399,519291,381,1005,381,12,99,109,2400,1102,0,1,383,1101,0,0,382,20101,0,382,1,20102,1,383,2,21101,37,0,0,1106,0,578,4,382,4,383,204,1,1001,382,1,382,1007,382,44,381,1005,381,22,1001,383,1,383,1007,383,20,381,1005,381,18,1006,385,69,99,104,-1,104,0,4,386,3,384,1007,384,0,381,1005,381,94,107,0,384,381,1005,381,108,1105,1,161,107,1,392,381,1006,381,161,1102,1,-1,384,1105,1,119,1007,392,42,381,1006,381,161,1102,1,1,384,20102,1,392,1,21102,18,1,2,21101,0,0,3,21102,138,1,0,1105,1,549,1,392,384,392,20102,1,392,1,21102,1,18,2,21101,3,0,3,21102,1,161,0,1105,1,549,1102,1,0,384,20001,388,390,1,20102,1,389,2,21102,180,1,0,1105,1,578,1206,1,213,1208,1,2,381,1006,381,205,20001,388,390,1,20102,1,389,2,21102,1,205,0,1106,0,393,1002,390,-1,390,1101,0,1,384,20101,0,388,1,20001,389,391,2,21101,0,228,0,1106,0,578,1206,1,261,1208,1,2,381,1006,381,253,21002,388,1,1,20001,389,391,2,21101,0,253,0,1105,1,393,1002,391,-1,391,1101,0,1,384,1005,384,161,20001,388,390,1,20001,389,391,2,21102,1,279,0,1105,1,578,1206,1,316,1208,1,2,381,1006,381,304,20001,388,390,1,20001,389,391,2,21101,304,0,0,1105,1,393,1002,390,-1,390,1002,391,-1,391,1102,1,1,384,1005,384,161,20101,0,388,1,21001,389,0,2,21101,0,0,3,21101,338,0,0,1106,0,549,1,388,390,388,1,389,391,389,21001,388,0,1,20102,1,389,2,21102,4,1,3,21102,1,365,0,1106,0,549,1007,389,19,381,1005,381,75,104,-1,104,0,104,0,99,0,1,0,0,0,0,0,0,193,20,15,1,1,22,109,3,22102,1,-2,1,22102,1,-1,2,21101,0,0,3,21102,414,1,0,1106,0,549,22101,0,-2,1,22102,1,-1,2,21101,429,0,0,1105,1,601,2101,0,1,435,1,386,0,386,104,-1,104,0,4,386,1001,387,-1,387,1005,387,451,99,109,-3,2106,0,0,109,8,22202,-7,-6,-3,22201,-3,-5,-3,21202,-4,64,-2,2207,-3,-2,381,1005,381,492,21202,-2,-1,-1,22201,-3,-1,-3,2207,-3,-2,381,1006,381,481,21202,-4,8,-2,2207,-3,-2,381,1005,381,518,21202,-2,-1,-1,22201,-3,-1,-3,2207,-3,-2,381,1006,381,507,2207,-3,-4,381,1005,381,540,21202,-4,-1,-1,22201,-3,-1,-3,2207,-3,-4,381,1006,381,529,21201,-3,0,-7,109,-8,2105,1,0,109,4,1202,-2,44,566,201,-3,566,566,101,639,566,566,1202,-1,1,0,204,-3,204,-2,204,-1,109,-4,2106,0,0,109,3,1202,-1,44,593,201,-2,593,593,101,639,593,593,21001,0,0,-2,109,-3,2105,1,0,109,3,22102,20,-2,1,22201,1,-1,1,21101,0,443,2,21101,0,386,3,21102,880,1,4,21101,0,630,0,1105,1,456,21201,1,1519,-2,109,-3,2106,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,2,0,2,0,0,0,0,0,0,2,0,0,2,0,2,0,2,0,0,2,2,2,2,2,0,2,2,2,2,0,2,2,2,2,0,0,0,0,0,0,1,1,0,0,2,2,0,2,0,0,0,2,2,0,0,2,0,2,2,2,0,0,0,0,0,0,0,2,0,0,0,2,0,0,0,0,2,0,2,2,2,0,0,0,1,1,0,0,0,2,2,0,2,2,0,0,0,2,0,2,2,0,0,0,0,2,0,0,0,0,0,0,0,2,2,0,0,2,2,0,2,0,0,2,0,0,0,0,1,1,0,2,0,0,2,2,2,2,0,2,2,0,2,0,0,2,2,0,0,2,2,2,2,0,2,0,0,0,0,0,0,0,0,0,0,2,0,2,0,0,0,0,1,1,0,2,2,0,0,2,0,0,0,0,2,0,2,0,0,2,0,2,2,0,2,2,0,0,2,0,0,0,0,0,0,2,2,2,2,0,0,0,2,0,0,0,1,1,0,2,2,2,2,0,0,2,0,2,0,0,2,2,0,0,0,0,0,0,2,2,0,2,0,0,0,0,0,0,0,2,2,2,0,0,2,2,2,0,0,0,1,1,0,2,0,2,0,0,0,0,0,0,2,0,2,0,2,2,2,2,0,2,0,2,2,0,2,2,0,2,2,0,0,2,0,0,2,0,0,0,0,0,2,0,1,1,0,0,0,2,0,0,0,2,2,0,0,2,2,0,0,2,0,2,0,0,2,0,2,0,0,0,2,0,0,0,0,0,2,2,2,0,0,2,2,0,2,0,1,1,0,0,0,2,0,0,2,0,2,0,2,2,2,2,0,2,0,2,0,0,0,0,0,0,2,2,0,0,2,0,2,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,0,0,0,2,0,2,0,0,2,2,0,2,0,0,0,2,2,0,0,0,2,0,0,2,0,2,2,0,0,0,0,0,0,0,2,2,2,2,0,1,1,0,0,2,2,0,2,0,2,0,2,0,0,2,0,0,2,2,2,2,0,0,2,0,2,2,2,0,2,2,2,0,0,2,0,0,2,2,2,0,2,0,0,1,1,0,2,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,2,0,2,0,0,0,0,2,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,70,58,29,33,6,46,59,57,27,46,31,1,33,3,13,87,13,93,53,58,97,48,1,76,24,32,17,5,56,47,11,8,83,35,15,60,92,90,87,4,31,29,46,91,13,80,65,89,30,23,63,61,93,96,92,10,69,8,19,57,49,29,51,31,43,12,63,55,20,34,69,73,75,10,58,42,38,18,22,72,53,78,47,96,40,39,19,93,44,60,61,23,31,30,78,67,66,37,1,29,42,78,40,90,55,82,27,33,82,51,81,76,89,34,17,52,83,19,79,62,77,75,36,72,97,20,22,63,69,90,10,51,82,88,16,82,8,2,72,93,70,87,97,85,81,55,93,33,7,40,54,37,58,41,41,93,97,8,16,3,98,73,37,40,98,69,92,56,15,1,8,13,35,27,75,96,50,62,42,63,16,10,86,74,65,69,6,95,57,48,86,46,4,34,2,61,40,18,96,6,55,60,81,62,45,42,15,25,1,85,20,5,5,84,41,63,19,40,89,9,37,67,68,83,37,10,31,28,98,7,81,64,9,87,29,30,42,54,66,54,66,35,94,85,78,29,38,34,37,12,54,39,94,63,46,77,75,53,71,10,63,94,9,66,1,8,19,10,41,16,85,57,55,24,5,95,27,62,39,95,56,30,48,33,78,45,67,48,46,14,10,81,12,62,5,63,12,20,52,63,46,43,8,18,36,37,38,20,57,45,86,82,7,35,95,89,71,9,50,23,42,74,54,40,31,89,75,10,9,20,16,41,89,4,26,5,65,37,91,87,78,3,36,56,34,45,97,87,52,60,80,7,12,92,23,21,28,73,76,71,7,23,92,53,56,33,24,35,60,22,56,36,94,1,36,85,16,38,62,56,50,93,77,26,65,42,65,41,97,84,96,70,56,71,61,58,97,71,37,93,46,21,74,90,87,9,69,3,38,78,81,63,79,4,9,13,20,28,88,1,10,68,57,64,43,62,38,69,50,71,38,23,14,24,35,52,16,95,47,66,6,7,34,35,15,41,4,81,56,72,83,13,69,67,46,17,52,56,69,86,39,36,98,48,65,98,73,6,62,73,17,3,35,40,27,61,69,6,55,38,63,27,5,7,16,40,96,63,70,10,26,3,91,61,94,61,6,60,13,37,65,21,52,28,57,76,52,32,5,77,64,54,12,73,82,50,72,17,33,88,97,86,71,96,24,36,89,84,15,80,11,4,51,44,67,58,62,21,4,38,69,64,26,36,88,35,70,49,24,34,59,65,31,81,35,23,90,56,63,80,49,48,95,59,3,67,53,46,69,45,11,64,64,71,56,79,29,83,43,79,82,76,47,85,65,49,12,45,81,80,98,84,47,4,90,73,85,40,17,44,61,47,66,58,7,45,32,82,45,16,97,30,96,77,39,66,28,47,32,35,77,85,18,14,95,40,89,69,19,95,18,85,74,42,30,80,87,15,57,25,38,39,68,35,5,73,34,3,43,61,72,23,26,81,86,15,1,36,43,65,42,70,16,78,70,72,81,43,20,76,34,73,63,6,42,87,6,66,86,87,69,45,54,11,40,38,17,79,36,85,76,69,9,79,80,67,26,49,85,54,12,63,34,89,12,86,33,63,50,91,18,41,64,98,88,15,83,88,95,22,68,92,59,68,20,82,44,51,11,26,22,87,41,20,76,56,54,58,75,30,65,89,70,30,93,89,28,92,70,12,80,38,59,48,90,30,5,76,5,91,34,67,88,87,77,27,3,82,35,49,27,68,43,21,40,7,62,26,2,48,9,38,95,87,94,93,58,45,48,96,65,17,33,62,45,74,24,93,88,29,93,20,19,48,11,80,88,31,61,30,69,14,3,95,48,4,33,82,38,24,33,88,48,87,67,48,22,34,49,94,78,10,71,9,19,74,74,10,39,28,4,2,96,12,40,26,12,3,10,90,62,37,61,32,86,81,98,45,56,59,47,50,48,86,1,42,96,27,22,40,51,95,23,14,26,17,4,30,17,52,519291"));
        for (int[] line : screen) {
            for (int code : line) {
                if (code == 2) numOfNums++;
            }
        }
        System.out.println(numOfNums);
    }
}
