# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 15.04.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                                         |Eseguito da          |
|--------------|--------------------------------------------------------------------------------------|---------------------|
|08:20 - 09:00 | Riunione generale                                                                    | Tutti (no Michea)   |
|09:00 - 09:50 | Ripresa vecchio codice                                                               | Tutti (no Michea)   |
|10:05 - 11:35 | Tentativo implementazione Live Stream  (VLC)                                         | Gianni e Alessandro |
|10:05 - 11:35 | Fixaggio Drone e Leap, Continuava ad atterrare + Leap non rilevato/funzionava male   | Samuele             |
|12:30 - 13:30 | Fixing dei problemi genarli dell'applicazione                                        | Tutti               |
|13:30 - 14:00 | Implementazione della cronologia dei comandi nel panel.                              | Samuele             |
|13:30 - 14:00 | Fix problema decollo drone                                                           | Michea e Alessandro |
|13:30 - 14:00 | Tentativo implementazione Live Stream (VLC/Codice)                                   | Gianni              |
|14:15 - 14:20 | Riunione con il professore per lo storico dei comandi                                | Samuele e Michea    |
|14:15 - 14:40 | Tentativo implementazione Live Stream (Codice)                                       | Gianni e Alessandro |
|14:20 - 14:40 | Fix del codice per la registrazione e l'esecuzione dei comandi registrati.           | Samuele             |
|14:40 - 15:45 | Tentativo implementazione Live Stream                                                | Tutti (no Samuele)  |
|14:40 - 15:45 | Implementazione guida tramite tastiera (base di Michea e Gianni).                    | Samuele             |

######NB: Michea arrivato a 12:30.


## Problemi riscontrati e soluzioni adottate


1. Nonostante non siano stati creati nuovi oggetti su porte già occupate, apparivano alcuni errori del tipo che si stava tentando di utilizzare porte già occupate. Il problema appariva quando si facevano giri troppo lunghi per scambiare i riferimenti di alcuni oggetti ad altri, per mettere a posto il problema, siamo andati per tentativi provando diversi modi per scambiare i riferimenti delle classi. Tutt'ora la ragione del problema e come siamo riusciti a metterlo a posto è sconosciuto.
2. Non siamo ancora riusciti a implementare la Live stream. Per questo ci stiamo lavorando in tanti. Sotto consiglio del docente abbiamo provato ad usare VLC, infatti il programma è fatto anche per riprodurre un flusso video `UDP`, temiamo però che il flusso sia codificato in maniera particolare, e che quindi non riusciamo a riprodurlo. L'errore viene però restituito in fase di instaurazione della connessione, quindi dobbiamo fare ricerche ulteriori. 
3. Implementando lo storico dei comandi ci siamo accorti che le troppe istruzioni stampate potevano confondere, abbiamo valutato perciò di limitarle. Tuttavia il docente ci ha detto di mantenere l'integrità dei dati, e di lasciare la stampa così com'era. Tuttavia dobbiamo aggiungere una legenda per comprendere le istruzioni.
4. Anche provando a implementare la Live tramite codice Java, anche tramite librerie esterne come `JCodec`, non siamo riusciti a farla funzionare. Dobbiamo perciò studiare una soluzione e trovare un modo di procedere.

Ecco quindi le soluzioni riassunte:
>1. Scambio dei riferimenti tra le classi:
>2. Uso di VLC.
>3. Consultazione con docente.


## Punto della situazione rispetto alla pianificazione

Oggi non abbiamo lavorato particolarmente bene, perciò abbiamo perso un po' di terreno, che prevediamo di recuperare.
## Programma di massima per la prossima giornata di lavoro
1. Implementazione Live. (Tentativo)
2. Finire implementazione tastiera.
3. Documentazione e Gantt.

