
# Currency Converter

This project is a simple Java-based Currency Converter application that allows users to convert currency values between various currencies. The application uses the Exchange Rate API to fetch live exchange rates and the Gson library to parse the JSON responses.

## Features

- Convert between various predefined currency pairs, including:
    - Dolar (USD) to Argentine Peso (ARS) and vice versa
    - Dolar (USD) to Brazilian Real (BRL) and vice versa
    - Dolar (USD) to Colombian Peso (COP) and vice versa
- Custom currency conversion by entering currency codes (ISO 4217 standard).
- Continuously prompts the user for conversions until they choose to exit.

## Technologies

- **Java**: The core programming language for the application.
- **Exchange Rate API**: For fetching up-to-date currency exchange rates.
- **Gson**: A JSON parsing library to deserialize API responses.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to install the following tools and configure their dependencies:

1. **Java** (versions 8 or higher)
    - Install Java by following the instructions [here](https://docs.oracle.com/en/java/javase/21/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)
    ```sh
    java -version
    ```
    Should return something like:
    ```sh
    java version "1.8.0"
    Java(TM) SE Runtime Environment (build 1.8.0-b132)
    Java HotSpot(TM) 64-Bit Server VM (build 25.0-b70, mixed mode)
    ```

2. **Git**
    - Install Git by following the instructions [here](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

    Verify the installation:
    ```sh
    git --version
    ```
    Should return something like:
    ```sh
    git version 2.25.1
    ```

## Installing

1. Clone the repository and navigate into the project directory:
    ```sh
    git clone https://github.com/Sebasvasquezz/Currency-Converter.git
    ```

## Usage

1. Run the `Principal` class.
2. Follow the on-screen instructions:
    - Choose a currency conversion option (1-8).
    - Enter the amount to convert.
    - The application will fetch the latest exchange rate and display the converted amount.
3. Optionally, you can specify custom currency codes by selecting option 7.

## Prerequisites

- **API Key**: You need an API key for the Exchange Rate API. Replace the placeholder key (`41dad1394ee8f5c5392d528e`) in the code with your own API key.

## Example

```plaintext
***************************************************************
Bienvenido al Conversor de moneda.
1. Dólar =>> Peso argentino.
2. Peso argentino =>> Dólar.
3. Dólar =>> Real brasileño.
4. Real brasileño =>> Dólar.
5. Dólar =>> Peso colombiano.
6. Peso colombiano =>> Dólar.
7. Ingresar las siglas de las monedas.
8. Salir
Eliga una las siguientes opciones (1-8):
7
Sigla de la moneda inicial:
USD
Sigla de la moneda final:
ARS
Ingrese el valor a convertir:
25
El valor de 25,00 [USD] corresponde al valor final de 24931,25 [ARS].
```
## Execution
<video controls src="images/execution.mp4" title="Title"></video>

## Built With

* [Java](https://www.java.com/es/) - Programming language and computing platform
* [Git](http://git-scm.com/) - Version Control System


## Versioning

I use [GitHub](https://github.com/) for versioning. For the versions available, see the [tags on this repository](https://github.com/Sebasvasquezz/Currency-Converter.git).

## Authors

* **Juan Sebastian Vasquez Vega**  - [Sebasvasquezz](https://github.com/Sebasvasquezz)

## Date

November 11, 2024

## License

This project is licensed under the GNU License - see the [LICENSE.txt](LICENSE.txt) file for details.
