package br.com.formulario.VIEW;

import java.text.ParseException;

public class Validation {
	private static final char [] NUMBERS = 
		{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static final char [] SPECIAL_CHARACTERS = 
		{'!', '@', '$', '%', '&', '*', '(', ')', '=', '+','{','}',
				'[', ']', '?', '<', '>', ':', ';', ',', '.', '/', '|'};



	public static boolean haveOnlyLetters(String text) {
		if (haveNumber(text) || haveSpecialCharacters(text)) {
			return false;
		}
		else if(text.isBlank()) {
			return false;
		}
		return true;
	}

	public static boolean haveNumber(String text) {
		return existsIn(text, NUMBERS);
	}

	public static boolean haveSpecialCharacters(String text) {
		return existsIn(text, SPECIAL_CHARACTERS);
	}

	private static boolean existsIn(String text, char [] arrayCharacter) {
		for (int i = 0; i < text.length(); i++) {
			if (exists(text.charAt(i), arrayCharacter)) {
				return true;
			}
		}
		return false;
	}

	private static boolean exists(char character, char [] arrayCharacter) {
		for (char singleChar: arrayCharacter) {
			if (character == singleChar) {
				return true;
			}
		}
		return false;
	}

	public static boolean haveOneChar(String character) {
		return character.length() == 1;
	}

	public static boolean haveOnlyNumber(String number) {
		String numberWithoutSpaces = removeSpaces(number);
		return haveOnlyNumber(numberWithoutSpaces, 0);
	}

	private static boolean haveOnlyNumber(String number, int index) {
		if (index == number.length()) { // Acaba a recursão
			return true;
		}
		if (!exists(number.charAt(index), NUMBERS)) {
			return false;
		}
		return haveOnlyNumber(number, ++index);
	}

	private static String removeSpaces(String text) {
		return getTextWithout(text, " ");
	}

	private static String getTextWithout(String text, String removeText) {
		String [] words =  text.split(removeText);
		String newText = "";
		for (String word : words) {
			newText += word;
		}
		return newText;	
	}

	public static boolean isDate(String date) {
		String [] splitDate = date.split("/");
		if (splitDate.length == 3) {
			String day = splitDate[0];
			String month = splitDate[1];
			String year = splitDate[2];
			if (lessThan(day, 32) & lessThan(month, 13) & lessThan(year, 2023)) {
				return true;
			}
		}
		return false;
	} // FIXINGGGGGG

	private static boolean lessThan(String number, int limit) {
		try {
			return Integer.parseInt(number) <= limit;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean isCPF(String cpf) {
		return haveOnlyNumber(cpf) && cpf.length() == 11;
	}



}
