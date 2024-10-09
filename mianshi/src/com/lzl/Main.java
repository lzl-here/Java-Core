package com.lzl;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static HashMap<String, Integer> nameNumsMap = new HashMap<>();
    private static HashMap<String, String> namePosMap = new HashMap<>();
    private static String[][] earth;
    public static void main(String[] args) {
        int n = 0, m = 0, k = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        earth = new String[m][n];
        String[] places = new String[k];
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            places[i] = scanner.nextLine();
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        String[] commands = new String[q];
        for (int i = 0; i < q; i++) {
            commands[i] = scanner.nextLine();
        }

        process2(places, commands);
    }


    private static void process2(String[] places, String[] commands) {
        for (int i = 0; i < places.length; i++) {
            String place = places[i];
            String[] split = place.split(" ");
            String name = split[0];
            int x = Integer.parseInt(split[1]) - 1;
            int y = Integer.parseInt(split[2]) - 1;
            placeInit(x, y, name);
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            String[] split = command.split(" ");
            String name = split[0];
            String move = split[1];
            doMove(name, move);
        }
    }

    private static void doMove(String name, String move) {
        String pos = namePosMap.get(name);
        if (pos == null) {
            System.out.println("unexisted empire.");
            return;
        }

        int x = Integer.parseInt(pos.split("_")[0]);
        int y = Integer.parseInt(pos.split("_")[1]);

        if (move.equals("W")) {
            y = y - 1;
        } else if (move.equals("A")) {
            x = x - 1;
        } else if (move.equals("S")) {
            y = y + 1;
        } else if (move.equals("D")) {
            x = x + 1;
        }

        if (x < 0 || x >= earth[0].length || y < 0 || y >= earth.length) {
            System.out.println("out of bounds!");
        } else if (earth[y][x] == null) {
            System.out.println("vanquish!");
            namePosMap.put(name, x + "_" + y);
            nameNumsMap.compute(name, (k, i) -> i + 1);
            earth[y][x] = name;
        } else if (earth[y][x].equals(name)) {
            System.out.println("peaceful.");
            namePosMap.put(name, x + "_" + y);
        } else if (!earth[y][x].equals(name)) {
            if (nameWins(name, earth[y][x])) {
                System.out.println(name + " wins!");
                nameNumsMap.compute(name, (k, i) -> i + 1);
                namePosMap.put(name, x + "_" + y);
                clearName(earth[y][x]);
                earth[y][x] = name;
            } else {
                System.out.println(earth[y][x] + " wins!");
                clearName(name);
            }
        }
    }

    private static boolean nameWins(String nameA, String nameB) {
        if (nameNumsMap.get(nameA) > nameNumsMap.get(nameB)) {
            return true;
        }
        if (nameNumsMap.get(nameA) < nameNumsMap.get(nameB)) {
            return false;
        }
        return larger(nameA, nameB);
    }

    private static void placeInit(int x, int y, String name) {
        if (earth[y][x] == null) {
            earth[y][x] = name;
            nameNumsMap.put(name, 1);
            namePosMap.put(name, x + "_" + y);
            return;
        }

        String otherName = earth[y][x];
        if (larger(name, otherName)) {
            clearName(otherName);
            earth[y][x] = name;
            nameNumsMap.put(name, 1);
            namePosMap.put(name, x + "_" + y);
        } else {
            clearName(name);
        }
    }

    private static void clearName(String name) {
        nameNumsMap.remove(name);
        namePosMap.remove(name);
        for (int i = 0; i < earth.length; i++) {
            for (int j = 0; j < earth[i].length; j++) {
                if (name.equals(earth[i][j])) {
                    earth[i][j] = null;
                }
            }
        }
    }

    private static boolean larger(String a, String b) {
        if (a.startsWith(b)) {
            return true;
        }
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) > b.charAt(i);
            }
            i++;
        }
        return false;
    }


}
