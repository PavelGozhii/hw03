package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{2, 3, 4, 6, 10};
        int[] arr3 = mergeArray(arr1, arr2);

        Arrays.stream(arr3).forEach((i) -> System.out.print(arr3[i - 1] + " "));
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

        long start = System.nanoTime();
        System.out.println(printTextPerRole(roles, textLines));
        long finish = System.nanoTime();
        System.out.println(finish - start);

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
        StringBuilder text = new StringBuilder();
        for (int index = 0; index < roles.length; index++) {
            text.append(new StringBuilder(roles[index]) + ":\n");
            for (int element = 0; element < textLines.length; element++) {
                if (roles[index].equals(textLines[element].substring(0, textLines[element].indexOf(":")))) {
                    text.append((element + 1) + ")" +
                            textLines[element].substring(textLines[element].indexOf(":") + 1) + "\n");
                }
            }
            if (index != roles.length - 1) {
                text.append("\n");
            }
        }
        return text.toString();
    }

}


