import java.math.BigDecimal;

//Scrivi un programma Java dove imposti 2 BigDecimal e 1 operazione aritmetica
//(Addizione, sottrazione, moltiplicazione e divisione, min e max) definita in un enum
//Crei un metodo per calcolare l'operazione richiesta e e ritorni il risultato.
//Il tipo di operazione, i due dati in input e il risultato dovranno essere stampati a schermo
public class Main {

    // Metodo per eseguire l'operazione aritmetica con due numeri BigDecimal
    public static BigDecimal eseguiOperazione(BigDecimal num1, BigDecimal num2, OperazioneAritmetica operazione) {

        // Utilizzo di uno switch-case per determinare l'operazione da eseguire
        switch (operazione) {

            // Caso di addizione
            case ADDIZIONE:
                return num1.add(num2);

            // Caso di sottrazione
            case SOTTRAZIONE:
                return num1.subtract(num2);

            // Caso di moltiplicazione
            case MOLTIPLICAZIONE:
                return num1.multiply(num2);

            // Caso di divisione
            case DIVISIONE:
                // Controllo se il secondo numero è zero per evitare la divisione per zero
                if (num2.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Impossibile dividere per zero");
                }
                return num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);

            // Caso di calcolo del minimo tra i due numeri
            case MIN:
                return num1.min(num2);

            // Caso di calcolo del massimo tra i due numeri
            case MAX:
                return num1.max(num2);

            // Se l'operazione non è supportata, viene lanciata un'eccezione
            default:
                throw new IllegalArgumentException("Operazione non supportata: " + operazione);
        }
    }

    public static void main(String[] args) {
        // Definizione di due numeri BigDecimal
        BigDecimal num1 = new BigDecimal("23.1");
        BigDecimal num2 = new BigDecimal("43.2");

        // Definizione dell'operazione da eseguire
        OperazioneAritmetica operazione = OperazioneAritmetica.DIVISIONE;

        // Chiamata al metodo per eseguire l'operazione e ottenere il risultato
        BigDecimal risultato = eseguiOperazione(num1, num2, operazione);

        // Stampa dei dettagli dell'operazione eseguita e del risultato
        System.out.println("Primo numero: " + num1);
        System.out.println("Secondo numero: " + num2);
        System.out.println("Operazione: " + operazione);
        System.out.println("Risultato: " + risultato);
    }

}