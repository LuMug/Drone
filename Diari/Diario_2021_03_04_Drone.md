# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 04.03.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 08:45 | Riunione di gruppo e resoconto del lavoro                           |Tutti                       |
|08:50 - 09:00 | Tentativo ripresa Live Stream                                       |Alessandro e Gianni         |
|08:50 - 09:50 | Calibrazione Leap-Motion                                            |Samuele                     |
|08:50 - 09:00 | Ripresa ImageFrame                                                  |Michea                      |
|09:00 - 09:30 | Discussione con Docente problema batteria                           |Tutti                       |
|09:30 - 09:50 | Calibrazione Leap Motion                                            |Samuele                     |
|09:30 - 09:50 | Ricerche possibili soluzioni per batteria                           |Alessandro, Gianni e Michea |
|10:05 - 10:15 | Consultazione docente su procedimento                               |Tutti                       |
|10:15 - 10:30 | Creazione di un simulatore per testare la comunicazione con il drone|Alessandro e Gianni        |
|10:15 - 10:30 | Ricerca e fix impostazioni / calibrazione Leap Motion               |Michea e Samuele            |
|10:30 - 11:35 | Consultazione elettronici per batteria                              |Alessandro e Michea         |
|10:30 - 11:35 | Instaurazione Socket per comunicazione con il drone                 |Gianni                      |
|10:30 - 11:35 | Calibrazione Leap Motion                                            |Samuele                     |
|12:30 - 13:15 | Test Socket con Stream video                                        |Gianni e Samuele            |
|12:30 - 13:15 | Revisione Trello + revisione codice ImageTest                       |Michea                      |
|12:30 - 13:15 | Ricerche + domande su sistema di guida con Leap Motion              |Samuele                     |
|13:15 - 14:00 | Test Socket con comunicazione dati                                  |Gianni e Alessandro         |
|13:15 - 14:00 | Test Sensore Leap Motion                                            |Samuele e Michea            |
|14:00 - 14:45 | Test e implementazione guida tramite tasti                          |Gianni e Michea             |
|14:00 - 15:45 | Nuovi test con Leap Motion                                          |Samuele                     |
|14:00 - 15:45 | Live Drone con file .mp4                                            |Alessandro                  |
|14:45 - 15:45 | Test e implementazione guida tramite tasti                          |Gianni                      |
|14:45 - 15:45 | Diario                                                              |Michea                      |

## Problemi riscontrati e soluzioni adottate

1. Poco dopo aver iniziato a lavorare, il primo problema della giornata ci si è palesato. Benché la batteria del drone fornitaci dalla scuola fosse stata costantemente sotto carica per tutto il giorno precedente (Mercoledì 3 marzo 2020), al nostro arrivo il drone presentava alcuni problemi. Abbiamo infatti provato a testare alcune cose senza farlo decollare ma il drone si è scaricato dopo 2 minuti. Inoltre la batteria dava segni di caricamento, anche dopo una buona mezz'ora in carica il livello indicato dall'app mobile di `DJI` indicava il livello sempre vicino allo 0%.
Per questo ci siamo consultati con il docente temevamo infatti che il problema stesse nelle componenti del drone, come ad esempio un chip danneggiato dall'rigonfiamento della batteria originale.
Dopo una consultazione con il docente, abbiamo provato a cercare soluzioni online, abbiamo aperto il drone per verificare se a vista ci fossero pezzi danneggiati, ma non abbiamo trovato nulla. Perciò siamo andati dai docenti Bartesaghi e Scheurer, sezione elettronica, che tramite una scarica elettrica più forte di quella abituale per la ricarica ha come "sbloccato" i circuiti.

2. Durante la creazione del `socket` per la comunicazione con il drone, ci siamo resi conto di una nostra incomprensione su chi fosse il `server` e chi il `client`, infatti secondo la nostra concezione il `server` era il drone, ma in realtà questo compito è svolto dal nostro PC. Per questo abbiamo leggermente modificato lo schema per la simulazione del drone. Con le dovute modifiche e la classe `echoUdpClient` abbiamo simulato con successo la comunicazione.
Questo ci ha anche permesso di comunicare e sistemare finalmente il nostro `socket`.

3. Durante lo svolgimento della calibrazione del `Leap Motion`, abbiamo dovuto ripensare al sistema di guida. Infatti abbiamo avuto qualche dubbio su come gestire i movimenti della mano, se limitarci a creare un sistema di coordinate fisso oppure se creare un sistema simile ad un "acceleratore", quindi considerare anche di quanto la mano si muovesse, per poi adattare movimenti e velocità di conseguenza. Dato che era già parzialmente implementato, abbiamo tenuto il sistema ad "acceleratore". Inoltre questo sistema è molto più intuitivo.

4. Mentre sviluppavamo la logica per la guida tramite i tasti, ci siamo accorti che dovessimo ideare un sistema per mantenere i tasti che vengono premuti.  Ora, infatti, glie eventi vengono presi separatamente, il drone si sposta quindi molto a scatti, e non in maniera fluida come dovrebbe. La nostra logica presenta anche un altro problema, con il fatto che gli eventi vengono presi distintamente, si sommano pure. Quindi il drone eseguirà molte istruzioni uguali una in fila all'altra, senza possibilità di interromperle. 
Perciò dovremmo trovare una soluzione.

5. Nella creazione del codice per il salvataggio di un file mp4, abbiamo avuto dei problemi nell'apertura del file finale. Anche se il file aumenta di peso man mano che la registrazione procede, quando la rec viene interrotta non abbiamo un file leggibile. Pensiamo che sia collegato all'`header` e alla `tail` del file.
Nella prossima lezione dovremmo trovare una soluzione


Ecco quindi le soluzioni riassunte:

> 1. Ricerche online.
> 2. Consultazioni docenti elettronica.
> 3. Riunione tra di noi e considerazioni sull'usabilità.
> 4. Prove di guida drone e calibrazioni al codice.



## Punto della situazione rispetto alla pianificazione
Per la prima volta ci traviamo stringato con i tempi, oggi avremmo dovuto precedere velocemente, ma siamo stati rallentati da tutti i problemi sulla batteria. Perciò prevediamo di recuperare la prossima lezione.

## Programma di massima per la prossima giornata di lavoro
1. Sistemare il codice scritto oggi.
2. Trovare una soluzione per la guida tramite tasti.
3. Implementare la possibilità di combinare 2 o più istruzioni con i tasti.
4. Sistemare lo stream del video live.