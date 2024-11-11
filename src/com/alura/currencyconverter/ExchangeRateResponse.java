package com.alura.currencyconverter;

import java.util.Map;
/**
 * Represents the response from the Exchange Rate API, containing details of the currency conversion results.
 */
public record ExchangeRateResponse(String result, String base_code, Map<String, Double> conversion_rates ) {
    /**
     * Gets the status of the response, indicating if the API request was successful or not.
     *
     * @return a string representing the result status, typically "success" if the request succeeded.
     */
    public String result() {
        return result;
    }

    /**
     * Gets the base currency code used in the conversion rates.
     *
     * @return a string representing the ISO 4217 currency code (e.g., "USD" for US Dollar) for the base currency.
     */
    public String base_code() {
        return base_code;
    }

    /**
     * Retrieves the map of conversion rates for different currencies relative to the base currency.
     *
     * @return a Map where the keys are ISO 4217 currency codes, and the values are the conversion rates.
     */
    public Map<String, Double> conversion_rates() {
        return conversion_rates;
    }
}

