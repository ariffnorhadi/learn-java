package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] note_values = {50, 20, 10, 5, 2, 1};

        // row_index, column_index
        int[][] main_array = main_array(note_values);

        int amount = 147;
        perform_calculation(note_values, main_array, amount);

        print_notes_required(main_array);
    }

    public static int[][] perform_calculation(int[] note_values, int[][] main_array, int amount ){
        int note_value_index = 0;
        for (int value : note_values) {
            if (value != 1) {
                if (amount >= value) {
                    main_array[note_value_index][1] = amount / value;
                    amount -= main_array[note_value_index][1] * value;
                }
            } else {
                main_array[note_value_index][1] = amount;
            }
            note_value_index++;
        }
        return main_array;
    }

    public static int[][] main_array(int[] note_values){
        int[][] main_array = new int[note_values.length][2];
        int row_index_counter = 0;
        for (int note : note_values) {
            main_array[row_index_counter][0] = note;
            row_index_counter++;
        }
        return main_array;
    }

    public static void print_notes_required(int[][] main_array) {
        StringBuilder message = new StringBuilder();
        for (int[] note : main_array) {
            message.append("\n").append("RM").append(note[0]).append(": ").append(note[1]);
        }
        System.out.println(message);
    }
}
