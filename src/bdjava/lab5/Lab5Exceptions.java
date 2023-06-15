package bdjava.lab5;

public class Lab5Exceptions {
    public static class EmptyLineException extends Exception {
        private String location;
        public EmptyLineException (String location) {
            super("Обязательно нужно ввести данные!");
            this.location = location;
        }
        public String getErrorLocation () {
            return location;
        }
    }
    public static class NegativeNumberException extends Exception {
        private String location;
        public NegativeNumberException(String location, String value) {
            super("Используйте пожалуйста положительные числа! Введенное значение: " + value);
            this.location = location;
        }
        public String getErrorLocation () {
            return location;
        }
    }
}