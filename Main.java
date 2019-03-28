package com.company;

public class Main {

    public static void main(String[] args) {


        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{2, 3, 4, 6, 10};
        int[] arr3 = mergeArray(arr1, arr2);

        for (int i : arr3) {
            System.out.println(i + " ");
        }

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
        int[] result = new int[arr1.length + arr2.length];
        int indexArr1 = 0;
        int indexArr2 = 0;
        for (int index = 0; index < result.length; index++) {
            if (indexArr1 < arr1.length && indexArr2 < arr2.length) {
                if (arr1[indexArr1] < arr2[indexArr2]) {
                    result[index] = arr1[indexArr1];
                    indexArr1++;
                } else {
                    result[index] = arr2[indexArr2];
                    indexArr2++;
                }
            } else if (indexArr1 >= arr1.length) {
                result[index] = arr2[indexArr2];
                indexArr2++;
            } else {
                result[index] = arr1[indexArr1];
                indexArr1++;
            }
        }

        return result;
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < roles.length; index++) {
            result.append(new StringBuilder(roles[index]) + ":\n");
            for (int element = 0; element < textLines.length; element++) {
                if (roles[index].equals(textLines[element].substring(0, textLines[element].indexOf(":")))) {
                    result.append(element + 1);
                    result.append(")");
                    result.append(textLines[element].substring(textLines[element].indexOf(":") + 1) + "\n");
                }
            }
            if (index != roles.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

}


