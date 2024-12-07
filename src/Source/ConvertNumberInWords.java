/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

class ConvertNumberInWords {

      private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String convertNumberToWords(int number) {
        if (number == 0) {
            return "Zero";
        }
        if (number < 0) {
            return "Minus " + convertNumberToWords(-number);
        }
        String words = "";
        if ((number / 1000000) > 0) {
            words += convertNumberToWords(number / 1000000) + " Million ";
            number %= 1000000;
        }
        if ((number / 1000) > 0) {
            words += convertNumberToWords(number / 1000) + " Thousand ";
            number %= 1000;
        }
        if ((number / 100) > 0) {
            words += convertNumberToWords(number / 100) + " Hundred ";
            number %= 100;
        }
        if (number > 0) {
            if (number < 10) {
                words += units[number];
            } else if (number < 20) {
                words += teens[number - 10];
            } else {
                words += tens[number / 10] + " " + units[number % 10];
            }
        }
        return words;
    }
}
