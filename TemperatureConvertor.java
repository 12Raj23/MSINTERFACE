

    import java.util.Scanner;

    public class TemperatureConvertor {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt user for input
            System.out.println("Enter the temperature value:");
            double temperature = scanner.nextDouble();

            System.out.println("Enter the unit of measurement (C for Celsius, F for Fahrenheit, K for Kelvin):");
            char unit = scanner.next().toUpperCase().charAt(0);

            // Convert and display the temperature in the other two units
            switch (unit) {
                case 'C':
                    convertFromCelsius(temperature);
                    break;
                case 'F':
                    convertFromFahrenheit(temperature);
                    break;
                case 'K':
                    convertFromKelvin(temperature);
                    break;
                default:
                    System.out.println("Invalid unit of measurement.");
            }

            scanner.close();
        }

        // Convert Celsius to Fahrenheit and Kelvin
        private static void convertFromCelsius(double celsius) {
            double fahrenheit = (celsius * 9/5) + 32;
            double kelvin = celsius + 273.15;

            System.out.println(celsius + "°C is equal to " + fahrenheit + "°F and " + kelvin + "K.");
        }

        // Convert Fahrenheit to Celsius and Kelvin
        private static void convertFromFahrenheit(double fahrenheit) {
            double celsius = (fahrenheit - 32) * 5/9;
            double kelvin = celsius + 273.15;

            System.out.println(fahrenheit + "°F is equal to " + celsius + "°C and " + kelvin + "K.");
        }

        // Convert Kelvin to Celsius and Fahrenheit
        private static void convertFromKelvin(double kelvin) {
            double celsius = kelvin - 273.15;
            double fahrenheit = (celsius * 9/5) + 32;

            System.out.println(kelvin + "K is equal to " + celsius + "°C and " + fahrenheit + "°F.");
        }
    }

