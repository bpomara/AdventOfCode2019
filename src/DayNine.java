import java.util.ArrayList;
import java.util.Scanner;

public class DayNine {
    public static long[] convertToArray(String inputList) {
        ArrayList<Long> list = new ArrayList<>();
        String input = inputList.concat(",");
        while (input.contains(",")) {
            list.add(Long.parseLong(input.substring(0,input.indexOf(","))));
            input = input.substring(input.indexOf(",") + 1);
        }
        long[] array = new long[1200];
        for(int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void compute(long[] input) {
        Scanner scan = new Scanner(System.in);
        long parameter1;
        long parameter2;
        int jumpBy;
        int opcodeLocation = 0;
        int relativeBase = 0;
        int[] opcodeArray = intToArray(input[opcodeLocation]);
        int opcodeFunction = opcodeArray[3] * 10 + opcodeArray[4];
        while (opcodeFunction != 99) {
            //System.out.println(input[opcodeLocation]);
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
                if (opcodeArray[2] == 0) input[(int) input[opcodeLocation + 1]] = scan.nextInt();
                else input[relativeBase + (int) input[opcodeLocation + 1]] = scan.nextInt();
                jumpBy = 2;
            }
            else if (opcodeFunction == 4) {
                if (opcodeArray[2] == 0) parameter1 = input[(int) input[opcodeLocation + 1]];
                else if (opcodeArray[2] == 1) parameter1 = input[opcodeLocation + 1];
                else parameter1 = input[relativeBase+(int) input[opcodeLocation+1]];
                System.out.println(parameter1);
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
        compute(convertToArray("1102,34463338,34463338,63,1007,63,34463338,63,1005,63,53,1102,3,1,1000,109,988,209,12,9,1000,209,6,209,3,203,0,1008,1000,1,63,1005,63,65,1008,1000,2,63,1005,63,904,1008,1000,0,63,1005,63,58,4,25,104,0,99,4,0,104,0,99,4,17,104,0,99,0,0,1102,521,1,1028,1101,0,36,1000,1102,30,1,1005,1101,21,0,1013,1101,26,0,1006,1102,31,1,1017,1101,24,0,1007,1101,0,1,1021,1102,27,1,1019,1101,23,0,1010,1101,0,38,1012,1102,35,1,1001,1101,25,0,1003,1102,20,1,1004,1101,0,37,1009,1101,424,0,1023,1102,39,1,1008,1102,406,1,1027,1102,1,413,1026,1101,0,29,1002,1102,1,0,1020,1102,34,1,1014,1102,1,28,1018,1102,1,33,1011,1102,300,1,1025,1102,1,22,1015,1102,305,1,1024,1101,32,0,1016,1102,427,1,1022,1101,512,0,1029,109,14,1205,6,197,1001,64,1,64,1106,0,199,4,187,1002,64,2,64,109,-18,1207,8,19,63,1005,63,215,1105,1,221,4,205,1001,64,1,64,1002,64,2,64,109,10,1208,-1,28,63,1005,63,237,1106,0,243,4,227,1001,64,1,64,1002,64,2,64,109,-2,2102,1,0,63,1008,63,22,63,1005,63,263,1105,1,269,4,249,1001,64,1,64,1002,64,2,64,109,11,21107,40,39,0,1005,1015,289,1001,64,1,64,1106,0,291,4,275,1002,64,2,64,109,9,2105,1,0,4,297,1105,1,309,1001,64,1,64,1002,64,2,64,109,-13,2101,0,-5,63,1008,63,25,63,1005,63,329,1105,1,335,4,315,1001,64,1,64,1002,64,2,64,109,1,1206,8,353,4,341,1001,64,1,64,1105,1,353,1002,64,2,64,109,3,2108,37,-6,63,1005,63,375,4,359,1001,64,1,64,1106,0,375,1002,64,2,64,109,-16,1207,2,36,63,1005,63,397,4,381,1001,64,1,64,1105,1,397,1002,64,2,64,109,28,2106,0,0,1001,64,1,64,1106,0,415,4,403,1002,64,2,64,109,-3,2105,1,-1,1106,0,433,4,421,1001,64,1,64,1002,64,2,64,109,-12,2108,25,-6,63,1005,63,449,1105,1,455,4,439,1001,64,1,64,1002,64,2,64,109,-19,1202,8,1,63,1008,63,38,63,1005,63,479,1001,64,1,64,1105,1,481,4,461,1002,64,2,64,109,14,2107,25,0,63,1005,63,497,1105,1,503,4,487,1001,64,1,64,1002,64,2,64,109,24,2106,0,-3,4,509,1001,64,1,64,1105,1,521,1002,64,2,64,109,-20,1208,-2,37,63,1005,63,543,4,527,1001,64,1,64,1106,0,543,1002,64,2,64,109,7,21102,41,1,0,1008,1018,43,63,1005,63,563,1105,1,569,4,549,1001,64,1,64,1002,64,2,64,109,-7,1205,10,587,4,575,1001,64,1,64,1106,0,587,1002,64,2,64,109,-11,1202,5,1,63,1008,63,30,63,1005,63,609,4,593,1106,0,613,1001,64,1,64,1002,64,2,64,109,4,1201,5,0,63,1008,63,34,63,1005,63,637,1001,64,1,64,1105,1,639,4,619,1002,64,2,64,109,12,1206,5,651,1105,1,657,4,645,1001,64,1,64,1002,64,2,64,109,9,21101,42,0,-7,1008,1018,39,63,1005,63,677,1105,1,683,4,663,1001,64,1,64,1002,64,2,64,109,-2,21101,43,0,-8,1008,1015,43,63,1005,63,705,4,689,1106,0,709,1001,64,1,64,1002,64,2,64,109,-25,2107,38,10,63,1005,63,727,4,715,1106,0,731,1001,64,1,64,1002,64,2,64,109,7,2102,1,2,63,1008,63,24,63,1005,63,757,4,737,1001,64,1,64,1105,1,757,1002,64,2,64,109,-13,1201,10,0,63,1008,63,29,63,1005,63,779,4,763,1105,1,783,1001,64,1,64,1002,64,2,64,109,30,21108,44,41,-3,1005,1019,803,1001,64,1,64,1106,0,805,4,789,1002,64,2,64,109,-2,21102,45,1,-7,1008,1013,45,63,1005,63,827,4,811,1105,1,831,1001,64,1,64,1002,64,2,64,109,-16,21107,46,47,7,1005,1011,849,4,837,1106,0,853,1001,64,1,64,1002,64,2,64,109,9,21108,47,47,0,1005,1013,875,4,859,1001,64,1,64,1106,0,875,1002,64,2,64,109,-10,2101,0,2,63,1008,63,30,63,1005,63,901,4,881,1001,64,1,64,1105,1,901,4,64,99,21102,1,27,1,21102,1,915,0,1106,0,922,21201,1,51805,1,204,1,99,109,3,1207,-2,3,63,1005,63,964,21201,-2,-1,1,21101,942,0,0,1106,0,922,22101,0,1,-1,21201,-2,-3,1,21101,0,957,0,1105,1,922,22201,1,-1,-2,1105,1,968,21201,-2,0,-2,109,-3,2105,1,0"));
        //compute(convertToArray("104,1125899906842624,99"));
    }
}
