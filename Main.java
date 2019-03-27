package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        int[] arr1 = new int[]{1,2, 3, 4, 5};
        int[] arr2 = new int[]{2,3, 4, 6, 10};
        int[] arr3 = mergeArray(arr1, arr2);

        Arrays.stream(arr3).forEach((i) -> System.out.print(arr3[i-1] + " "));
        System.out.println();

        String[] roles = new String[]{"Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};

        String[] textLines
                = new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(printTextPerRole(roles, textLines));
    }

    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int index_arr1 = 0;
        int index_arr2 = 0;
        for (int index = 0; index < arr.length; index++) {
            if (index_arr1 < arr1.length && index_arr2 < arr2.length) {
                if (arr1[index_arr1] < arr2[index_arr2]) {
                    arr[index] = arr1[index_arr1];
                    index_arr1++;
                } else {
                    arr[index] = arr2[index_arr2];
                    index_arr2++;
                }
            } else if (index_arr1 >= arr1.length) {
                arr[index] = arr2[index_arr2];
                index_arr2++;
            } else {
                arr[index] = arr1[index_arr1];
                index_arr1++;
            }
        }

        return arr;
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        HashMap<String, StringBuilder> scenario = new HashMap<>();
        for (int i = 0; i < roles.length; i++) {
            scenario.put(roles[i], null);
        }
        for (int index = 0; index < roles.length; index++) {
            scenario.put(roles[index], new StringBuilder(roles[index] + ":\n"));
            for (int element = 0; element < textLines.length; element++) {
                String name = textLines[element].substring(0, textLines[element].indexOf(":"));
                if (roles[index].equals(name)) {
                    StringBuilder tempString = scenario.get(roles[index]);
                    String textToString = textLines[element].substring(textLines[element].indexOf(":") + 1);
                    tempString.append(element + 1 + ")" + textToString + "\n");
                    scenario.put(roles[index], tempString);
                }
            }
        }
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            text.append(scenario.get(roles[i]));
            if (i != roles.length - 1) {
                text.append("\n");
            }
        }
        return text.toString();
    }

}




